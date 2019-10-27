package com.example.testeemjava.Presenter;

import android.content.Context;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;

import com.example.testeemjava.Contracts.SearchContract;
import com.example.testeemjava.Infra.LoginServices;
import com.example.testeemjava.Infra.RetrofitClient;
import com.example.testeemjava.fragments.adapter.Adapter;
import com.example.testeemjava.model.Animal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPresenter implements SearchContract.Presenter{

    SearchContract.View view;
    private List<Animal> animalList = new ArrayList<>();
    private Adapter adapter;

    public SearchPresenter(SearchContract.View view) {
        this.view = view;
    }

    @Override
    public void filter(String nome) {
        ArrayList<Animal> animal = new ArrayList<>();
        if(adapter != null) {
            for (Animal animais: animalList) {
                if (animais.getName().toLowerCase().contains(nome.toLowerCase())) {
                    animal.add(animais);
                } else if (animais.getBreed().toLowerCase().contains(nome.toLowerCase())) {
                    animal.add(animais);
                }
            }
            if (animal == null) {
                adapter.filterAdapter(animalList);
                view.configAdapter(adapter);
            } else {
                adapter.filterAdapter(animal);
                view.configAdapter(adapter);
            }
        }
    }//fim filter

    @Override
    public void getAnimals() {
        LoginServices services = new RetrofitClient().getRetrofit();
        services.getAnimals().enqueue(new Callback<List<Animal>>() {
            @Override
            public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {

                animalList = response.body();
                for (Animal a : animalList) {
                    Log.d("uhu", a.urlImage);
                }
                view.configAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Animal>> call, Throwable t) {

            }

        });
    }//fim getAnimals

}
