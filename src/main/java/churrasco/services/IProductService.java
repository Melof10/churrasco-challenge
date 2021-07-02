package churrasco.services;

import churrasco.dto.ProductDTO;
import java.util.List;

public interface IProductService {

    public List<ProductDTO> findAll() throws Exception;
    
    public ProductDTO save(ProductDTO productDTO) throws Exception;        

}
