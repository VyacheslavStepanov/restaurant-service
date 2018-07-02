package com.sweb.bestlunch.restaurantservice.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("restaurant/{restaurantId}/product")
public class ProductController {

    private ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository){
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Product> getProducts(@PathVariable("restaurantId") Long restaurantId){
        return repository.findAllByRestaurantId(restaurantId);
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable("restaurantId") Long restaurantId,@PathVariable("productId") Long productId){
        return repository.findByRestaurantIdAndId(restaurantId, productId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void saveOrUpdateProduct(@RequestBody Product product, @PathVariable("restaurantId") Long restaurantId){
        repository.save(product);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long id){
        repository.deleteById(id);
    }
}




