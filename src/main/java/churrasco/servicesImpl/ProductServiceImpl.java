package churrasco.servicesImpl;

import churrasco.dto.ProductDTO;
import churrasco.entities.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import churrasco.repositories.IProductRepository;
import churrasco.services.IProductService;
import churrasco.util.ConvertEntityDto;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired    
    private IProductRepository iProductRepository;
    
    @Autowired
    private ConvertEntityDto convertEntityDto;

    @Override
    public List<ProductDTO> findAll() throws Exception {
        try {                        
            return convertEntityDto.convertToDTOProductEntity(iProductRepository.findAll());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Product save(ProductDTO productDTO) throws Exception {
        try {
            Product product = new Product();                        
            product.setId(productDTO.getId());                                        
            product.setSku(productDTO.getSku());
            product.setCode(productDTO.getCode());
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPicture(productDTO.getPicture());
            product.setPrice(productDTO.getPrice());
            product.setCurrency(productDTO.getCurrency());
            
            iProductRepository.save(product);
            
            return product;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
