package churrasco.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginUserDTO {
                    
    
    private String username;         
    private String email;
    @NotBlank
    private String password;
    
	public LoginUserDTO(String username, String email, @NotBlank String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public LoginUserDTO() {
    	
    }
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
