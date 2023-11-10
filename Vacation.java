package com.reservation;

public class Vacation {
    private String country;
    private String city;
    private String season;

    public Vacation(String country, String city, String season) {
        this.country = country;
        this.city = city;
        this.season = season;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return city + ", " + country + " during " + season;
    }
}
