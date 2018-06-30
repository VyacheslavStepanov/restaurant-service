package com.sweb.bestlunch.restaurantservice;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class RestaurantController {
    private RestaurantRepository repository;

    @Autowired
    public RestaurantController(RestaurantRepository repository){
        this.repository = repository;
    }

    @GetMapping("/restaurants")
    public List<Restaurant> retrieveRestaurants(){

        List<Restaurant> restaurants = repository.findAll();
        return repository.findAll();
    }

    @PostMapping("/restaurant/add")
    public ResponseEntity<String> saveOrUpdateRestaurant(@RequestBody Restaurant restaurant){
        repository.save(restaurant);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/restaurant/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRestaurant(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurant(@PathVariable Long id){
        Optional<Restaurant> optionalRestaurant = repository.findById(id);
        return optionalRestaurant.orElse(null);
    }
}
