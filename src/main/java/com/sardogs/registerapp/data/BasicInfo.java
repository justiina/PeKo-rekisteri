package com.sardogs.registerapp.data;

import java.time.LocalDate;
import java.util.List;

public abstract class BasicInfo {
    private LocalDate registerDate;
    private List<String> training;

    public BasicInfo() {
    }

    public BasicInfo(LocalDate registerDate, List<String> training) {
        this.registerDate = registerDate;
        this.training = training;
    }

    public LocalDate getRegisterDate() {
        return this.registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
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

