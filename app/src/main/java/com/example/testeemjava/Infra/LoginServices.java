package com.example.testeemjava.Infra;

import com.example.testeemjava.model.UserDTO;
import com.example.testeemjava.model.Animal;
import com.example.testeemjava.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginServices {

    @GET("contacts")
    Call<List<Animal>> getAnimals();

    @POST("contacts")
    Call<Void> postPet(@Body Animal animal);

    @POST("users")
    Call<Void> alterarUser(@Body User user);

    @POST("users")
    Call<Void> cadastrarUser(@Body User user);

    @POST("users/login")
    Call<UserDTO> loginUser(@Body User user);





}
