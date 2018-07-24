package com.sweb.bestlunch.restaurantservice.product;

import com.sweb.bestlunch.restaurantservice.lunchset.LunchSet;
import com.sweb.bestlunch.restaurantservice.lunchset.LunchSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController  {

    private LunchSetRepository lunchSetRepository;

    @Autowired
    public SearchController(LunchSetRepository lunchSetRepository) {
        this.lunchSetRepository = lunchSetRepository;
    }

    @GetMapping("/all")
    public List<LunchSet> getAll(){
        return lunchSetRepository.findAll();
    }
}
