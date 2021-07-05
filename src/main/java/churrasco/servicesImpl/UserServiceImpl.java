package churrasco.servicesImpl;

import churrasco.entities.User;
import churrasco.repositories.IUserRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import churrasco.services.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
    
    @Autowired
    private IUserRepository iUserRepository;
    
    public Optional<User> getByUsername(String username){
        return iUserRepository.findByUsername(username);
    }
    
    public Optional<User> getByEmail(String email){
        return iUserRepository.findByEmail(email);
    }
    
    public boolean existsByUsername(String username){
        return iUserRepository.existsByUsername(username);
    }
    
    public boolean existsByEmail(String email){
        return iUserRepository.existsByEmail(email);
    }
    
    public void save(User user){
        iUserRepository.save(user);
    }
    
}
