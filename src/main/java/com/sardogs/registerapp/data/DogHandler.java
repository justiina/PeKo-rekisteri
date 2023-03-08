package com.sardogs.registerapp.data;

import java.sql.Date;
import java.util.List;

public class DogHandler {
    private int id;
    private int dogId;
    private String fname;
    private String lname;
    private Date bDate;
    private List<String> training;
    
    public DogHandler() {
    }

    public DogHandler(int id, int dogId, String fname, String lname, Date bDate, List<String> training) {
        this.id = id;
        this.dogId = dogId;
        this.fname = fname;
        this.lname = lname;
        this.bDate = bDate;
        this.training = training;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDogId() {
        return this.dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getBDate() {
        return this.bDate;
    }

    public void setBDate(Date bDate) {
        this.bDate = bDate;
    }

    public List<String> getTraining() {
        return this.training;
    }

    public void setTraining(List<String> training) {
        this.training = training;
    }
}