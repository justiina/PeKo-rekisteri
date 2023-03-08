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
            new Dog(1, 1, "Riki", "2015-07-27", List.of("Harjoitus-Virta", "HL", "JP")),
            new Dog(2, 1, "Ramona", "2019-08-08", List.of("JP")),
            new Dog(3, 2, "Pamela", "2021-12-03", List.of("")),
            new Dog(4, 3, "Cooper", "2014-11-14", List.of("VIRTA","HL","JL"))
        );

    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public List<Dog> getDogsByHandler(int handlerId) {
        for (Dog dog : dogs) {
            if(dog.getHandlerId() == handlerId) {
                dogs.add(dog);
            }
        }
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

    public boolean removeDog(int id) {
        Dog d = findDog(id);
    
        if(d != null) {
            return dogs.remove(d);
        } 
        return false;
    }   
}
