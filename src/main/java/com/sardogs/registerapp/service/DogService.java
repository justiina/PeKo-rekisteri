package com.sardogs.registerapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sardogs.registerapp.data.Dog;

@Service
public class DogService {
    private List<Dog> dogs = new ArrayList<>();

    public DogService() {
        dogs = Arrays.asList(
            new Dog(1,1,"Riki"),
            new Dog(2,1,"Ramona"),
            new Dog(3,2,"Pamela"),
            new Dog(4,3,"Tara")
        );
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public Dog findDog(int id) {
        for (Dog dog : dogs) {
            if(dog.getId() == id) {
                return dog;
            }
        }
        return null;
    }

    public boolean deleteDog(int id) {
        Dog d = findDog(id);
    
        if(d != null) {
            return dogs.remove(d);
        } 
        return false;
    }   
}
