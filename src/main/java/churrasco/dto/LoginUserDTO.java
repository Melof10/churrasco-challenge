package churrasco.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginUserDTO {
                    
    
    private String username;         
    private String email;
    @NotBlank
    private String password;
    
}
