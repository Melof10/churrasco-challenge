package churrasco.services;

import churrasco.entities.User;
import java.util.Optional;

public interface IUserService {                
    
    public Optional<User> getByUsername(String username);
    
    public Optional<User> getByEmail(String email);
    
    public boolean existsByUsername(String username);
    
    public boolean existsByEmail(String email);
    
    public void save(User user);
    
}
