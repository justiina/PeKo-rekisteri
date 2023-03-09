package com.sardogs.registerapp.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DogHandler extends BasicInfo {
    private int id;
    private String fname;
    private String lname;
    
    public DogHandler() {
        this(9999,"","",new ArrayList<String>());
    }

    public DogHandler(int id, String fname, String lname) {
        this(id, fname, lname, new ArrayList<String>());
    }

    public DogHandler(int id, String fname, String lname, List<String> training) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.setRegisterDate(LocalDate.now());
        this.setTraining(training);
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
}