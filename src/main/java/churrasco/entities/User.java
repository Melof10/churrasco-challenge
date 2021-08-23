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

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}        
    
}
