package com.sardogs.registerapp.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.sardogs.registerapp.data.Dog;
import com.sardogs.registerapp.data.DogHandler;

@Service
public class DogService {

    private List<DogHandler> handlers = new ArrayList<>();
    private List<Dog> dogs = new ArrayList<>();

    public DogService() {   
        handlers.add(new DogHandler(1, "Justiina", "Ronkainen", List.of("EA1", "Etsinnän peruskurssi")));
        handlers.add(new DogHandler(2, "Jokke", "Luikku", List.of("")));
        handlers.add(new DogHandler(3, "Liisa", "Ihme", List.of("EA1", "Etsinnän peruskurssi", "Jäljen kouluttajakoulutus")));

        dogs.add(new Dog(1, 1, "Riki", "2015-07-27", "Mix", "Male", List.of("Harjoitus-VIRTA", "HL", "JP")));
        dogs.add(new Dog(2, 1, "Ramona", "2019-08-08", "Lagotto romagnolo", "Female", List.of("JP")));
        dogs.add(new Dog(3, 2, "Pamela", "2021-12-03", "Lagotto romagnolo", "Female", List.of("")));
        dogs.add(new Dog(4, 3, "Cooper", "2014-11-14", "Lapponian herder", "Male", List.of("VIRTA","HL","JL")));

    }

    public void addHandler(DogHandler handler) {
        handlers.add(handler);
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public List<DogHandler> getHandlers() {
        return new ArrayList<>(handlers);
    }

    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public List<Dog> getDogsByHandler(int handlerId) {
        List<Dog> newDogs = new ArrayList<>();
        for (Dog dog : dogs) {
            if(dog.getHandlerId() == handlerId) {
                newDogs.add(dog);
            }
        }
        return new ArrayList<>(newDogs);
    }

    public DogHandler findHandler(int id) {
        for (DogHandler handler : handlers) {
            if(handler.getId() == id) {
                return handler;
            }
        }
        return null;
    }

    public Dog findDog(int id) {
        for (Dog dog : dogs) {
            if(dog.getId() == id) {
                return dog;
            }
        }
        return null;
    }

    public boolean removeHandler(int id) {
        DogHandler handler = findHandler(id);
    
        if(handler != null) {
            return handlers.remove(handler);
        } 
        return false;
    }

    public boolean removeDog(int id) {
        Dog dog = findDog(id);
    
        if(dog != null) {
            return dogs.remove(dog);
        } 
        return false;
    }

    public int numberOfHandlers() {
        return handlers.size();
    }

    public int numberOfDogs() {
        return dogs.size();
    }

    public int getAge(int id) {
        Dog dog = findDog(id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();  
        LocalDate birthDate = LocalDate.parse(dog.getBDate(), formatter);
        return Period.between(birthDate, today).getYears();
    }

    public double meanDogAge() {
        double ageSum = 0;
        for (Dog dog : dogs) {
            ageSum += getAge(dog.getId());
        }
        double meanAge = ageSum / dogs.size();
        return meanAge;
    }



}
