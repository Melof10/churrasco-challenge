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
    @Size(max = 11)
    @NotNull
    private long sku;

    @Column(name = "code", unique = true)
    @Size(max = 11)
    @NotNull
    private int code;

    @Column(name = "name")
    @Size(max = 40)
    @NotEmpty
    private String name;

    @Column(name = "description")
    @Size(max = 255)
    private String description;

    @Column(name = "picture")
    @Size(max = 255)
    private String picture;

    @Column(name = "price", precision = 10, scale = 2)
    @NotNull
    private double price;

    @Column(name = "currency")
    @Size(max = 3)
    private String currency;

}
