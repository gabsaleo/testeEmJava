package com.example.testeemjava.model;

public class Address {


    private int id;

    private String street;

    private String number;

    private String city;

    private String state;

    private String country;

    private String complements;

    private String district;

    private  User user;

    public Address(String street, String number, String city, String state, String country, String complements, String district) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.country = country;
        this.complements = complements;
        this.district = district;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getComplements() {
        return complements;
    }

    public void setComplements(String complements) {
        this.complements = complements;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", complements='" + complements + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
