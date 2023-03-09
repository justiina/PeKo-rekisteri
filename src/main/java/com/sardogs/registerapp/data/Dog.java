package com.sardogs.registerapp.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dog extends BasicInfo {
    private int id;
    private int handlerId;
    private String name;
    private String breed;
    private String sex;
    private String bDate;
    
    public Dog() {
        this(9999,9999,"","","","", new ArrayList<String>());
    }

    public Dog(int id, int handlerId, String name, String breed, String sex) {
        this(id, handlerId, name, "", breed, sex, new ArrayList<String>());
    }

    public Dog(int id, int handlerId, String name, String bDate, String breed, String sex, List<String> training) {
        this.id = id;
        this.handlerId = handlerId;
        this.name = name;
        this.bDate = bDate;
        this.breed = breed;
        this.sex = sex;
        this.setRegisterDate(LocalDate.now());
        this.setTraining(training);
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

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBDate() {
        return this.bDate;
    }

    public void setBDate(String bDate) {
        this.bDate = bDate;
    }

}