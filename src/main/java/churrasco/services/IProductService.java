package churrasco.services;

import churrasco.dto.ProductDTO;
import churrasco.entities.Product;
import java.util.List;

public interface IProductService {

    public List<ProductDTO> findAll() throws Exception;
    
    public Product save(ProductDTO productDTO) throws Exception;        

}
