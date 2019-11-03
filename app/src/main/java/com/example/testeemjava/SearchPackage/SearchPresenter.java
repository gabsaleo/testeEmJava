package com.example.testeemjava.SearchPackage;

import android.util.Log;

import com.example.testeemjava.Infra.LoginServices;
import com.example.testeemjava.Infra.RetrofitClient;
import com.example.testeemjava.HomePackage.adapter.Adapter;
import com.example.testeemjava.model.Animal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPresenter implements SearchContract.Presenter{

    SearchContract.View view;
    private ArrayList<Animal> animalList = new ArrayList<>();
    private Adapter adapter;

    public SearchPresenter(SearchContract.View view) {
        this.view = view;
    }

    @Override
    public void filter(String nome) {

        ArrayList<Animal> filterAnimal = new ArrayList<>();
        if(adapter != null) {
            for (Animal colaborador : animalList) {
                if (colaborador.getName().toLowerCase().contains(nome.toLowerCase())) {
                    filterAnimal.add(colaborador);
                } else if (colaborador.getBreed().toLowerCase().contains(nome.toLowerCase())) {
                    filterAnimal.add(colaborador);
                }else if (colaborador.getColor().toLowerCase().contains(nome.toLowerCase())) {
                    filterAnimal.add(colaborador);
                }
            }
            if (filterAnimal == null) {
                adapter.filterList(animalList);
                view.configAdapter(adapter);
            } else {
                adapter.filterList(filterAnimal);
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
                setAdapterListener();
                animalList = (ArrayList<Animal>) response.body();
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

    public void setAdapterListener(){
       adapter = new Adapter(view.getContext(), animalList);
    }

}
