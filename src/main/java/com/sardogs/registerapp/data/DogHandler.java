package com.sardogs.registerapp.data;

import java.time.LocalDate;
import java.util.List;

public class DogHandler {
    private int id;
    private String fname;
    private String lname;
    private LocalDate registerDate;
    private List<String> training;
    
    public DogHandler() {
        this(9999,"","",List.of(""));
    }

    public DogHandler(int id, String fname, String lname, List<String> training) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.registerDate = LocalDate.now();
        this.training = training;
    }
    
    public DogHandler(int id, String fname, String lname) {
        this(id, fname, lname, List.of(""));
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public List<String> getTraining() {
        return this.training;
    }

    public void setTraining(List<String> training) {
        this.training = training;
    }

    public void addTraining(String training) {
        this.training.add(training);
    }
}