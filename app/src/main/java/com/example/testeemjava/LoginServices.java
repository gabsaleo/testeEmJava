package com.example.testeemjava;

import com.example.testeemjava.modelos.Animal;
import com.example.testeemjava.model.User;
import com.example.testeemjava.modelos.SpinnerAddPet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginServices {

//    @GET("users")
//    Call<List<Animal>> getUsers();

    @GET("contacts")
    Call<List<Animal>> getAnimals();

    @POST("contacts")
    Call<Animal> postPet(@Body Animal animal);

//    @GET("contacts")
//    Call<List<SpinnerAddPet>> getSpinner();

    @POST("users")
    Call<Void> cadastrarUser(@Body User user);

    @POST("users/login")
    Call<User> loginUser(@Body User user);





}
