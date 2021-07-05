package churrasco.servicesImpl;

import churrasco.entities.MainUser;
import churrasco.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserServiceImpl userServiceImpl;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;       
        
        if(!username.contains("@"))
            user = userServiceImpl.getByUsername(username).get();
        else
            user = userServiceImpl.getByEmail(username).get();
                        
        return MainUser.build(user);
    }            
    
}
