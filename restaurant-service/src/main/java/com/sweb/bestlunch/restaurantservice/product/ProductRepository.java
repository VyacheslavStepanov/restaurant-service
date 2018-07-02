package com.sweb.bestlunch.restaurantservice.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    public List<Product> findAllByRestaurantId(Long id);
    public Product findByRestaurantIdAndId(Long restaurantId, Long ProductId);
}
