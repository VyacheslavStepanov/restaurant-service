package com.sweb.bestlunch.restaurantservice.lunchset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LunchSetRepository extends JpaRepository<LunchSet,Long> {
    List<LunchSet> findAllByRestaurantId(Long id);
    LunchSet findByRestaurantIdAndId(Long restaurantId, Long lunchsetId);
}
