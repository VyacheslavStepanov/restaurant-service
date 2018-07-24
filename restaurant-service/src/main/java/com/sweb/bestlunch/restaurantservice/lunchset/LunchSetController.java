package com.sweb.bestlunch.restaurantservice.lunchset;

import com.sweb.bestlunch.restaurantservice.product.Product;
import com.sweb.bestlunch.restaurantservice.product.ProductRepository;
import com.sweb.bestlunch.restaurantservice.restaurant.Restaurant;
import com.sweb.bestlunch.restaurantservice.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/restaurant/{restaurantId}/lunchset")
public class LunchSetController {
    private LunchSetRepository lunchSetRepository;
    private RestaurantRepository restaurantRepository;
    private ProductRepository productRepository;

    @Autowired
    public LunchSetController(LunchSetRepository lunchSetRepository, RestaurantRepository restaurantRepository, ProductRepository productRepository) {
        this.lunchSetRepository = lunchSetRepository;
        this.restaurantRepository = restaurantRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    public List<LunchSet> getLunchSets(@PathVariable Long restaurantId){
        return lunchSetRepository.findAllByRestaurantId(restaurantId);
    }

    @DeleteMapping("/{lunchsetId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLunchSets(@PathVariable Long lunchsetId){
        lunchSetRepository.deleteById(lunchsetId);
    }

    @PostMapping("/save")
    public LunchSet saveLunchset(@RequestBody LunchSet updatedLunchset, @PathVariable Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(new Restaurant());
        updatedLunchset.setRestaurant(restaurant);
        lunchSetRepository.save(updatedLunchset);
        System.out.println("saved lunchset with id "+ updatedLunchset.getId());
        return updatedLunchset;
    }

    @PostMapping("/{lunchsetId}/products/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProducts(@RequestBody List<Long> ids, @PathVariable Long restaurantId, @PathVariable Long lunchsetId){
        List<Product> products = new ArrayList<>();
        ids.forEach(id -> products.add(productRepository.findByRestaurantIdAndId(restaurantId,id)));

        LunchSet lunchset = lunchSetRepository.findByRestaurantIdAndId(restaurantId, lunchsetId);
        lunchset.setProducts(products);
        lunchSetRepository.save(lunchset);
    }

    @GetMapping("/{lunchsetId}")
    public LunchSet getLunchset(@PathVariable Long lunchsetId, @PathVariable Long restaurantId){
        return lunchSetRepository.findByRestaurantIdAndId(restaurantId, lunchsetId);
    }

    @GetMapping("/{lunchsetId}/productsIds")
    public List<Long> getProducts(@PathVariable Long lunchsetId, @PathVariable Long restaurantId){
        LunchSet lunchset = lunchSetRepository.findByRestaurantIdAndId(restaurantId, lunchsetId);
        return lunchset.getProducts().stream().map(Product::getId).collect(Collectors.toList());
    }
}
