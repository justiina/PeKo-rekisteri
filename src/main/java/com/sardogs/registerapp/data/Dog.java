package com.sardogs.registerapp.data;

import java.sql.Date;
import java.util.List;

public class Dog extends DogType {
    private int id;
    private int handlerId;
    private String name;
    private Date bDate;
    private Date registerDate;
    private List<String> training;

    public Dog() {
    }

    public Dog(int id, int handlerId, String name) {
        this.id = id;
        this.handlerId = handlerId;
        this.name = name;
    }

    public Dog(int id, int handlerId, String name, Date bDate, Date registerDate, List<String> training) {
        this.id = id;
        this.handlerId = handlerId;
        this.name = name;
        this.bDate = bDate;
        this.registerDate = registerDate;
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

    public Date getBDate() {
        return this.bDate;
    }

    public void setBDate(Date bDate) {
        this.bDate = bDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public List<String> getTraining() {
        return this.training;
    }

    public void setTraining(List<String> training) {
        this.training = training;
    }
}