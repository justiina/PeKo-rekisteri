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
import com.sardogs.registerapp.data.DogHandler;
import com.sardogs.registerapp.service.DogService;

@RestController
public class DogRestController {

    DogService ds;

    public DogRestController(DogService ds) {
        this.ds = ds;        
    }

    // List all dogs and dog handlers
    @GetMapping("/dogs")
    public List<Dog> getDogs() {
        return ds.getDogs();
    }

    @GetMapping("/handlers")
    public List<DogHandler> getHandlers() {
        return ds.getHandlers();
    }

    // List dogs by dog handler
    @GetMapping("/dogsbyhandler/{handlerId}")
    public List<Dog> dogsByHandler(@PathVariable int handlerId) {       
        return ds.getDogsByHandler(handlerId); 
    }

    // Number of registered dogs and dog handlers
    @GetMapping("/info")
    public String getInfo() {
        return "There are " + ds.numberOfDogs() + " registered dogs and " + ds.numberOfHandlers() + " dog handlers in the system.";
    }

    // Add dogs and dog handlers
    @PostMapping("/handler")
    public String addHandler(@RequestBody DogHandler handler) {
        ds.addHandler(handler);
        return "Dog handler added";
    }

    @PostMapping("/dog")
    public String addDog(@RequestBody Dog dog) {
        ds.addDog(dog);
        return "Dog added";
    }

    // Remove dogs and dog handlers
    @DeleteMapping("/delhandler")
    public String removeHandler(@RequestBody DogHandler handler) {
        if(ds.removeHandler(handler.getId()) == true) {
            return "Dog handler removed";
        }
        return "Dog handler id was not found";
    }

    @DeleteMapping("/deldog")
    public String removeDog(@RequestBody Dog dog) {
        if(ds.removeDog(dog.getId()) == true) {
            return "Dog removed";
        }
        return "Dog id was not found";
    }

    // Find one dog and dog handler
    @GetMapping("/handler/{id}")
    public ResponseEntity<DogHandler> getHandler(@PathVariable int id) {
        DogHandler handler = ds.findHandler(id);

        if(handler != null) {
            return new ResponseEntity<>(handler, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/dog/{id}")
    public ResponseEntity<Dog> getDog(@PathVariable int id) {
        Dog d = ds.findDog(id);

        if(d != null) {
            return new ResponseEntity<>(d, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get one dogs age
    @GetMapping("/dogage/{id}")
    public String dogAge(@PathVariable int id) {
        Dog dog = ds.findDog(id);
        if(dog != null) {
            if(ds.getAge(id) > 1) {
                return dog.getName() +" is " + ds.getAge(id) + " years old.";
            }
            return dog.getName() +" is " + ds.getAge(id) + " year old.";
        }
        return "Dog id was not found";        
    }

    // Get mean age of all registered dogs
    @GetMapping("/meanage")
    public String meanAge() {        
        return "Mean age of all registered dogs is: " + ds.meanDogAge() + " years.";
    }
}
