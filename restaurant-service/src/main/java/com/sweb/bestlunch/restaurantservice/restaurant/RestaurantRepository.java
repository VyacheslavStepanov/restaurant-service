package com.sweb.bestlunch.restaurantservice.restaurant;

import com.sweb.bestlunch.restaurantservice.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
