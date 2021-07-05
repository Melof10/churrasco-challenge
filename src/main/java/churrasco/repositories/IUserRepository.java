package churrasco.repositories;

import churrasco.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{
        
    public Optional<User> findByUsername(String username);        
    
    public Optional<User> findByEmail(String email);        
        
    public boolean existsByUsername(String username);
        
    public boolean existsByEmail(String email);
    
}
