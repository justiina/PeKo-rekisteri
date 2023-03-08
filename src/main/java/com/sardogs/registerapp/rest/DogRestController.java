package com.sardogs.registerapp.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;

import com.sardogs.registerapp.data.Dog;
import com.sardogs.registerapp.service.DogService;

@RestController
public class DogRestController {

    DogService ds;

    public DogRestController(DogService ds) {
        this.ds = ds;        
    }

    @GetMapping("/dogs")
    public List<Dog> getDogs() {
        return ds.getDogs();
    }

    @GetMapping("/info")
    public String getInfo() {
        return ds.numberOfDogs();
    }

    @PostMapping("/dog")
    public String addDog(@RequestBody Dog dog) {
        ds.addDog(dog);
        return "Dog added";
    }

    @DeleteMapping("/deldog")
    public String removeDog(@RequestBody Dog dog) {
        ds.removeDog(dog.getId());
        return "Dog removed";
    }

    @GetMapping("/dog/{id}")
    public ResponseEntity<Dog> getDog(@PathVariable int id) {
        Dog d = ds.findDog(id);

        if(d != null) {
            return new ResponseEntity<>(d, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/dogage/{id}")
    public String dogAge(@PathVariable int id) {
        Dog d = ds.findDog(id);
        return d.getName() +" is: " + d.dogAge() + " years old.";
    }

    @GetMapping("/meanage")
    public String meanAge() {        
        return "Mean age of all dogs is: " + ds.meanDogAge() + " years.";
    }
}
