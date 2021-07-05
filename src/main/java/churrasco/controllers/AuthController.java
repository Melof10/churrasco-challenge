package churrasco.controllers;

import churrasco.messages.Message;
import churrasco.dto.JwtDTO;
import churrasco.dto.LoginUserDTO;
import churrasco.dto.NewUserDTO;
import churrasco.entities.User;
import churrasco.security.jwt.JwtProvider;
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
import churrasco.servicesImpl.UserServiceImpl;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin
public class AuthController {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserServiceImpl iUserServiceImpl;
    
    @Autowired
    private JwtProvider jwtProvider;
    
    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@Valid @RequestBody NewUserDTO newUserDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("Información inválida"), HttpStatus.BAD_REQUEST);        
        if(iUserServiceImpl.existsByUsername(newUserDTO.getUsername()))
            return new ResponseEntity(new Message("Username en uso"), HttpStatus.BAD_REQUEST);        
        if(iUserServiceImpl.existsByEmail(newUserDTO.getUsername()))
            return new ResponseEntity(new Message("Email en uso"), HttpStatus.BAD_REQUEST);
        
        User user = new User(newUserDTO.getEmail(), newUserDTO.getUsername(), 
                            newUserDTO.getFirstName(), newUserDTO.getLastName(), 
                            passwordEncoder.encode(newUserDTO.getPassword()), 
                            newUserDTO.getRole(), newUserDTO.getCreated(), 
                            newUserDTO.getUpdated());                        
                
        user.setRole(newUserDTO.getRole());                    
        iUserServiceImpl.save(user);
        
        return new ResponseEntity(new Message(("Usuario creado correctamente")), HttpStatus.CREATED);
    }
    
    @PostMapping(value = "/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUserDTO loginUserDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("Información inválida"), HttpStatus.BAD_REQUEST);        
        
        Authentication authentication = null;                
        
        if(loginUserDTO.getUsername() != null)            
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDTO.getUsername(), loginUserDTO.getPassword()));        
        else
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDTO.getEmail(), loginUserDTO.getPassword()));        
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
                
        return new ResponseEntity(jwtDTO, HttpStatus.OK);
    }   
    
}
