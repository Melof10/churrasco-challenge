package churrasco.security.dto;

import java.sql.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NewUser {
    
    @NotBlank
    private String email;         
    @NotBlank
    private String username;                
    @Email    
    private String firstName;            
    private String lastName;                
    @NotBlank
    private String password;            
    private String role;    
    private Date created;            
    private Date updated;
    
}
