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
    
}
