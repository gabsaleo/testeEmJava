package com.example.testeemjava.model;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private Integer id;

    private String name;

    private String email;

    private String password;

    private String creationDate;

    private String userType;

    private  Address address;

    public UserDTO(Integer id, String name,
    String password, String creationDate,
    String userType, Address address) {

        this.id = id;
        this.name = name;
        this.password = password;
        this.creationDate = creationDate;
        this.userType = userType;
        this.address = address;
    }


    public UserDTO() {
    }

    public UserDTO(Integer id) {
        this.id = id;
    }

    public UserDTO(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    }



