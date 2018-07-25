package com.sweb.bestlunch.restaurantservice.lunchset;

public class LunchSetFacade {
    private final Long id;
    private final String description;
    private final String restaurantName;

    public LunchSetFacade(LunchSet lunchset) {
        this.id = lunchset.getId();
        this.description = lunchset.getDescription();
        this.restaurantName = lunchset.getRestaurant().getName();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getRestaurantName() {
        return restaurantName;
    }
}
