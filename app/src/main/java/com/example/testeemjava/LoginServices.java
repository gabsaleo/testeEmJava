package com.example.testeemjava;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LoginServices {

//    @GET("users")
//    Call<List<User>> getUsers();


    @POST("users")
    Call<Void> cadastrarUser(@Body User user);

    @POST("users/login")
    Call<User> loginUser(@Body User user);





}
