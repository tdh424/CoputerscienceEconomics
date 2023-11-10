package com.reservation;

public class Car {
    private String licensePlate;
    private int year;
    private String make;
    private int numberOfDoors;

    public Car(String licensePlate, int year, String make, int numberOfDoors) {
        this.licensePlate = licensePlate;
        this.year = year;
        this.make = make;
        this.numberOfDoors = numberOfDoors;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return year + " " + make + " (" + numberOfDoors + "-door) with license plate: " + licensePlate;
    }
}

