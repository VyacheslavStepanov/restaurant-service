package com.sweb.bestlunch.restaurantservice.lunchset;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sweb.bestlunch.restaurantservice.product.Product;
import com.sweb.bestlunch.restaurantservice.restaurant.Restaurant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="lunch_sets")
public class LunchSet {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany
    @JoinTable(name="lunchset_product",
        joinColumns = @JoinColumn(name="lunchset_id"),
        inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private List<Product> products = new ArrayList<>();

    private String description;

    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LunchSet() {
    }
}
