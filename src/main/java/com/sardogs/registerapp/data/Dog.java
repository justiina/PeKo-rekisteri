package com.sardogs.registerapp.data;

import java.time.LocalDate;
import java.util.List;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Dog extends DogType {
    private int id;
    private int handlerId;
    private String name;
    private String bDate;
    private LocalDate registerDate;
    private List<String> training;
    
    public Dog() {
    }

    public Dog(int id, int handlerId, String name, String breed, String sex) {
        this(id, handlerId, name, "", breed, sex, List.of(""));
    }

    public Dog(int id, int handlerId, String name, String bDate, String breed, String sex, List<String> training) {
        this.id = id;
        this.handlerId = handlerId;
        this.name = name;
        this.bDate = bDate;
        this.setBreed(breed);
        this.setSex(sex);
        this.registerDate = LocalDate.now();
        this.training = training;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHandlerId() {
        return this.handlerId;
    }

    public void setHandlerId(int handlerId) {
        this.handlerId = handlerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBDate() {
        return this.bDate;
    }

    public void setBDate(String bDate) {
        this.bDate = bDate;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public List<String> getTraining() {
        return this.training;
    }

    public void setTraining(List<String> training) {
        this.training = training;
    }

    public int dogAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();  
        LocalDate birthDate = LocalDate.parse(this.bDate, formatter);
        return Period.between(birthDate, today).getYears();
    }
}