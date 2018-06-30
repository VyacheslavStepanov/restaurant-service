package com.sweb.bestlunch.restaurantservice.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/product")
public class ProductController {

    private ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository){
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Product> getProducts(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        Optional<Product> optionalProduct = repository.findById(id);
        return optionalProduct.orElse(null);
    }

    @PostMapping("/product/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void saveOrUpdateProduct(@RequestBody Product product){
        repository.save(product);
    }

    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long id){
        repository.deleteById(id);
    }
}




