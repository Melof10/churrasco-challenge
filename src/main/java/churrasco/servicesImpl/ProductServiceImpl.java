package churrasco.servicesImpl;

import churrasco.dto.ProductDTO;
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

}
