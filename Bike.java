package com.reservation;

public class Bike {
    private String licensePlate;
    private String make;
    private int year;

    public Bike(String licensePlate, String make, int year) {
        this.licensePlate = licensePlate;
        this.make = make;
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Bike [License Plate: " + licensePlate + ", Make: " + make + ", Year: " + year + "]";
    }
}
