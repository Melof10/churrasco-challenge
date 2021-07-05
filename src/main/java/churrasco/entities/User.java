package churrasco.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    
    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "username", unique = true)
    private String username;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "role")
    private String role;
    
    @Column(name = "created")
    private Date created;
    
    @Column(name = "updated")
    private Date updated;

    public User(){
        
    }
    
    public User(String email, String username, String firstName, String lastName, String password, String role, Date created, Date updated) {
        this.idUser = idUser;
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.created = created;
        this.updated = updated;
    }
    
    public User(long idUser, String email, String username, String firstName, String lastName, String password, String role, Date created, Date updated) {
        this.idUser = idUser;
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.created = created;
        this.updated = updated;
    }        
    
}
