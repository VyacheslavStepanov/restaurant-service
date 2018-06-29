package com.sweb.bestlunch.restaurantservice;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RestaurantController {
    private RestaurantRepository repository;

    @Autowired
    public RestaurantController(RestaurantRepository repository){
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/restaurants")
    public List<Restaurant> retrieveRestaurants(){

        List<Restaurant> restaurants = repository.findAll();
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/restaurant/add")
    public ResponseEntity<String> saveOrUpdateRestaurant(@RequestBody Restaurant restaurant){
        repository.save(restaurant);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/restaurant/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
