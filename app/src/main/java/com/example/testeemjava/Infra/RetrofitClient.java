package com.example.testeemjava.Infra;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static String BASE_URL = "https://ancient-fortress-81160.herokuapp.com/api/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit = null;
    private static Gson gson = new GsonBuilder().create();

//    private static HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor()
//            .setLevel(HttpLoggingInterceptor.Level.BODY);
//    private  static OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder()
//            .addInterceptor(httpLoggingInterceptor);
//    private static OkHttpClient okHttpClient = httpBuilder.build();

    public RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public LoginServices getRetrofit(){
        return retrofit.create(LoginServices.class);
    }

//    public static synchronized RetrofitClient getInstance(){
//        if(mInstance == null){
//            mInstance = new RetrofitClient();
//        }
//        return mInstance;
//    }

//    public <T> T createService (Class <T> serviceClass){
//        if(retrofit == null){
//            retrofit = new Retrofit.Builder()
//                    .client(okHttpClient)
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create(gson))
//                    .build();
//        }
//
//        return retrofit.create(serviceClass);
//    }
}
