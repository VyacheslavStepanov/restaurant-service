package com.sweb.bestlunch.restaurantservice.lunchset;

import com.sweb.bestlunch.restaurantservice.lunchset.LunchSet;
import com.sweb.bestlunch.restaurantservice.lunchset.LunchSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "http://localhost:8080")
public class SearchController  {

    private LunchSetRepository lunchSetRepository;

    @Autowired
    public SearchController(LunchSetRepository lunchSetRepository) {
        this.lunchSetRepository = lunchSetRepository;
    }

    @GetMapping("/all")
    public List<LunchSetFacade> getAll(){
        List<LunchSetFacade> items = new ArrayList<>();
        List<LunchSet> lunchsets = lunchSetRepository.findAll();
        lunchsets.forEach(lunchSet -> items.add(new LunchSetFacade(lunchSet)));
        return items;
    }
}
