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

	public Product(int id, @NotNull long sku, @NotNull int code, @NotBlank String name, String description,
			String picture, @NotNull(message = "El precio es obligatorio") double price, String currency) {
		super();
		this.id = id;
		this.sku = sku;
		this.code = code;
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.price = price;
		this.currency = currency;
	}
    
    public Product() {
    	
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getSku() {
		return sku;
	}

	public void setSku(long sku) {
		this.sku = sku;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
