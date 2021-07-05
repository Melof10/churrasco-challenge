package churrasco.controllers;

import churrasco.messages.Message;
import churrasco.dto.JwtDTO;
import churrasco.dto.LoginUser;
import churrasco.dto.NewUser;
import churrasco.entities.User;
import churrasco.security.jwt.JwtProvider;
import churrasco.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin
public class AuthController {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private JwtProvider jwtProvider;
    
    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("Información inválida"), HttpStatus.BAD_REQUEST);        
        if(userService.existsByUsername(newUser.getUsername()))
            return new ResponseEntity(new Message("Username en uso"), HttpStatus.BAD_REQUEST);        
        if(userService.existsByEmail(newUser.getUsername()))
            return new ResponseEntity(new Message("Email en uso"), HttpStatus.BAD_REQUEST);
        
        User user = new User(newUser.getEmail(), newUser.getUsername(), 
                            newUser.getFirstName(), newUser.getLastName(), 
                            passwordEncoder.encode(newUser.getPassword()), 
                            newUser.getRole(), newUser.getCreated(), 
                            newUser.getUpdated());                
        String rol;
        
        if(newUser.getRole().contains("admin"))
            user.setRole(newUser.getRole());
        
        userService.save(user);
        
        return new ResponseEntity(new Message(("Usuario creado correctamente")), HttpStatus.CREATED);
    }
    
    @PostMapping(value = "/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("Información inválida"), HttpStatus.BAD_REQUEST);        
        
        Authentication authentication 
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDTO, HttpStatus.OK);
    }   
    
}