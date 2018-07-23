package com.sweb.bestlunch.restaurantservice.product;

import com.sweb.bestlunch.restaurantservice.restaurant.Restaurant;
import com.sweb.bestlunch.restaurantservice.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("restaurant/{restaurantId}/product")
public class ProductController {

    private ProductRepository productRepository;
    private RestaurantRepository restaurantRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, RestaurantRepository restaurantRepository){
        this.productRepository = productRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/all")
    public List<Product> getProducts(@PathVariable("restaurantId") Long restaurantId){
        return productRepository.findAllByRestaurantId(restaurantId);
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable("restaurantId") Long restaurantId,@PathVariable("productId") Long productId){
        return productRepository.findByRestaurantIdAndId(restaurantId, productId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void saveOrUpdateProduct(@RequestBody Product updatedProduct, @PathVariable("restaurantId") Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(new Restaurant());
        updatedProduct.setRestaurant(restaurant);
        productRepository.save(updatedProduct);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long id){
        productRepository.deleteById(id);
    }
}




