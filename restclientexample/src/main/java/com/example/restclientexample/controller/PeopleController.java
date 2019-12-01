package com.example.restclientexample.controller;

import com.example.restclientexample.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.people}")
    private String urlPeople;

    @GetMapping("/{id}")
    public People getPeople(@PathVariable("id") int id){
        People people = restTemplate.getForObject(urlPeople+id, People.class);
        return people;
    }
}
