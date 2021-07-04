package churrasco.security.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MainUser implements UserDetails{
    
    private String email;        
    private String username;        
    private String firstName;        
    private String lastName;        
    private String password;        
    private Collection<? extends GrantedAuthority> authorities;
    private Date created;        
    private Date updated;

    public MainUser(String email, String username, String firstName, String lastName, String password, Collection<? extends GrantedAuthority> authorities, Date created, Date updated) {
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.authorities = authorities;
        this.created = created;
        this.updated = updated;
    }    
    
    public static MainUser build(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        
        return new MainUser(
            user.getEmail(), 
            user.getUsername(), 
            user.getFirstName(), 
            user.getLastName(), 
            user.getPassword(), 
            authorities, 
            user.getCreated(), 
            user.getUpdated()
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }            

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }
    
}
