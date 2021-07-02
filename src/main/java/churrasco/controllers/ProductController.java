package churrasco.controllers;

import churrasco.dto.ProductDTO;
import churrasco.entities.Product;
import churrasco.services.IProductService;
import java.util.List;
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
    public ResponseEntity<List<ProductDTO>> findAll() throws Exception {
        try {
            List<ProductDTO> products = iProductService.findAll();
            
            if(!products.isEmpty())
                return new ResponseEntity<>(products, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                        
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
