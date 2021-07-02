package churrasco.servicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import churrasco.entities.Product;
import churrasco.repositories.IProductRepository;
import churrasco.services.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() throws Exception {
        try {            
            return  iProductRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
