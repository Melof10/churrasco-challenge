package churrasco.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginUserDTO {
                    
    @NotBlank
    private String username;         
    @NotBlank
    private String password;
    
}
