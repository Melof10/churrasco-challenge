package churrasco.util;

import churrasco.dto.ProductDTO;
import churrasco.entities.Product;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("convertEntityDto")
public class ConvertEntityDto {
    
    @Autowired
    private ModelMapper modelMapper;                            
    
    public List<ProductDTO> convertToDTOProductEntity(List<Product> products){        
        ArrayList<ProductDTO> productsDTO = new ArrayList<ProductDTO>();
        
        for (Product product : products) {
            productsDTO.add(modelMapper.map(product, ProductDTO.class));            
        }                
        
        return productsDTO;
    }
    
}
