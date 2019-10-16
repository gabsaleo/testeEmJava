package com.example.testeemjava;

import android.app.Application;

import com.example.testeemjava.model.UserDTO;

public class AppPet extends Application {

    public static AppPet instance;

    private static UserDTO userDTO;


    public static AppPet getInstance() {
        return instance;
    }

    public static void setInstance(AppPet instance) {
        AppPet.instance = instance;
    }

    public static UserDTO getUserDTO() {
        return userDTO;
    }

    public static void setUserDTO(UserDTO userDTO) {
        AppPet.userDTO = userDTO;
    }
}
