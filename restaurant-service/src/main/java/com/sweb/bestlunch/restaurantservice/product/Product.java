package com.sweb.bestlunch.restaurantservice.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sweb.bestlunch.restaurantservice.restaurant.Restaurant;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="cost_price")
    private Double costPrice;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    private Restaurant restaurant;

    public Product(){}
    public Product(String name, String description){
        this.name =  name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
