package churrasco.services;

import java.util.List;
import churrasco.entities.Product;

public interface IProductService {

    public List<Product> findAll() throws Exception;

}
