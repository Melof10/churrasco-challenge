package churrasco.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product{   

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "SKU", unique = true)    
    @NotNull
    private long sku;

    @Column(name = "code", unique = true)    
    @NotNull
    private int code;

    @Column(name = "name")    
    @NotBlank
    private String name;

    @Column(name = "description")    
    private String description;

    @Column(name = "picture")    
    private String picture;

    @Column(name = "price")
    @NotNull(message="El precio es obligatorio")
    private double price;

    @Column(name = "currency")    
    private String currency;

}
