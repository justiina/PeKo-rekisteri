package com.sardogs.registerapp.data;

public abstract class DogType {
    private String breed;
    private String sex;

    public DogType() {
    }

    public DogType(String breed, String sex) {
        this.breed = breed;
        this.sex = sex;
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
}
