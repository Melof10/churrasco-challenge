package churrasco.dto;

import java.sql.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NewUserDTO {
    
    @Email 
    @NotBlank
    private String email;         
    @NotBlank
    private String username;                       
    private String first_name;            
    private String last_name;                
    @NotBlank
    private String password;            
    private String role;    
    private Date created;            
    private Date updated;
	
    public NewUserDTO(@Email @NotBlank String email, @NotBlank String username, String first_name, String last_name,
			@NotBlank String password, String role, Date created, Date updated) {
		super();
		this.email = email;
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.role = role;
		this.created = created;
		this.updated = updated;
	}
    
    public NewUserDTO() {
    	
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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
