package churrasco.controllers;

import churrasco.errors.config.EntityNotFoundException;
import churrasco.dto.ProductDTO;
import churrasco.entities.Product;
import churrasco.services.IProductService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    
    @Autowired
    private IProductService iProductService;
    
    @GetMapping(value = "/all")
    public List<ProductDTO> findAll() throws EntityNotFoundException{
        return iProductService.findAll();
    }
    
    @PostMapping(value = "/save")
    public Product create(@Valid @RequestBody ProductDTO productDTO) throws EntityNotFoundException{                        
        return iProductService.save(productDTO);
    }        
    
}
