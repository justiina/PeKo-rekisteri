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
        handlers.add(new DogHandler(1, "Justiina", "Ronkainen", new ArrayList<String>(List.of("EA1", "Etsinnän peruskurssi"))));
        handlers.add(new DogHandler(2, "Jokke", "Luikku", new ArrayList<String>()));
        handlers.add(new DogHandler(3, "Liisa", "Ihme", new ArrayList<String>(List.of("EA1", "Etsinnän peruskurssi", "Jäljen kouluttajakoulutus"))));

        dogs.add(new Dog(1, 1, "Riki", "2015-07-27", "Mix", "Male", new ArrayList<String>(List.of("Harjoitus-VIRTA", "HL", "JP"))));
        dogs.add(new Dog(2, 1, "Ramona", "2019-08-08", "Lagotto romagnolo", "Female", new ArrayList<String>(List.of("JP"))));
        dogs.add(new Dog(3, 2, "Pamela", "2021-12-03", "Lagotto romagnolo", "Female", new ArrayList<String>()));
        dogs.add(new Dog(4, 3, "Cooper", "2014-11-14", "Lapponian herder", "Male", new ArrayList<String>(List.of("VIRTA","HL","JL"))));

    }

    // Add and get dogs and dog handlers
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

    // Get dog's name by id
    public String getDogName(int id) {
        Dog dog = findDog(id);
        return dog.getName();
    }

    // Update dogs and dog handlers
    public DogHandler updateHandler(int id, DogHandler newData) {
        DogHandler handler = findHandler(id);
        newData.setId(id);
        if(handler != null) {
            newData.setRegisterDate(handler.getRegisterDate());
            handlers.set(handlers.indexOf(handler), newData);
            return newData;
        }
        return null;
    }

    public Dog updateDog(int id, Dog newData) {
        Dog dog = findDog(id);
        newData.setId(id);
        if(dog != null) {
            newData.setRegisterDate(dog.getRegisterDate());
            dogs.set(dogs.indexOf(dog), newData);
            return newData;
        }
        return null;
    }

    // Add training
    public boolean addHandlerTraining(int id, String training) {
        DogHandler hanlder = findHandler(id);
        if(hanlder != null) {
            return hanlder.addTraining(training);
        }
        return false;
    }

    public boolean addDogTraining(int id, String training) {
        Dog dog = findDog(id);
        if(dog != null) {
            return dog.addTraining(training);
        }
        return false;
    }

    // Get one dog handlers dogs
    public List<Dog> getDogsByHandler(int handlerId) {
        List<Dog> newDogs = new ArrayList<>();
        for (Dog dog : dogs) {
            if(dog.getHandlerId() == handlerId) {
                newDogs.add(dog);
            }
        }
        return new ArrayList<>(newDogs);
    }

    // Find dog and dog handler by id
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

    // Remove dog and dog handler
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

    // Get number of registered dogs and dog handlers
    public int numberOfHandlers() {
        return handlers.size();
    }

    public int numberOfDogs() {
        return dogs.size();
    }

    // Calculate age of the dog from birth date and current date
    public int getAge(int id) {
        Dog dog = findDog(id);
        if(dog != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate today = LocalDate.now();  
            LocalDate birthDate = LocalDate.parse(dog.getBDate(), formatter);
            return Period.between(birthDate, today).getYears();
        }
        return 999;

    }

    public double meanDogAge() {
        double ageSum = 0;
        for (Dog dog : dogs) {
            if(dog != null) {
                ageSum += getAge(dog.getId());
            }
        }
        double meanAge = ageSum / dogs.size();
        return meanAge;
    }
}
