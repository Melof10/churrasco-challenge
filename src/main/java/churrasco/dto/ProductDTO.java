package churrasco.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class ProductDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private int id;
    private long sku;
    private int code;
    private String name;
    private String description;
    private String picture;
    private double price;
    private String currency;
    
}
