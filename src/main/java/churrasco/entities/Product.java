package churrasco.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
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
    @Length(max = 11)
    @NotNull
    private long sku;

    @Column(name = "code", unique = true)
    @Length(max = 11)
    @NotNull
    private int code;

    @Column(name = "name")
    @Length(max = 40)
    @NotEmpty
    private String name;

    @Column(name = "description")
    @Length(max = 255)
    private String description;

    @Column(name = "picture")
    @Length(max = 255)
    private String picture;

    @Column(name = "price", precision = 10, scale = 2)
    @NotNull
    private double price;

    @Column(name = "currency")
    @Length(max = 3)
    private String currency;

}
