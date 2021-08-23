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
    
	public ProductDTO(int id, long sku, int code, String name, String description, String picture, double price,
			String currency) {
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
    
    public ProductDTO() {
    	
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
