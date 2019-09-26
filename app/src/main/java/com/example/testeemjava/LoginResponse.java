package com.example.testeemjava;

import com.example.testeemjava.model.User;

import java.util.List;

public class LoginResponse {


    private List<User> users;

    public LoginResponse(List<User> users) {
        this.users = users;
    }


}
