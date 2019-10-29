package com.example.testeemjava.HomePackage;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testeemjava.MainPackage.MainContract;
import com.example.testeemjava.HomePackage.adapter.Adapter;
import com.example.testeemjava.Infra.LoginServices;
import com.example.testeemjava.Infra.RetrofitClient;
import com.example.testeemjava.R;
import com.example.testeemjava.model.Animal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends Fragment {

    private ArrayList<Animal> animalList = new ArrayList<>();
    private Adapter adapter;

    private View view;
    public Animal animal;
    private RecyclerView recyclerView;
    MainContract.View viewContract;

    public Home(MainContract.View viewContract) {
        this.viewContract = viewContract;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);



        recyclerView = view.findViewById(R.id.recyclerView);

        getAnimals();
        return view;

    }

    public void filter(String nome) {
        ArrayList<Animal> filterList = new ArrayList<>();
        if(adapter != null) {
            for (Animal animal : animalList) {
                if (animal.getName().toLowerCase().contains(nome.toLowerCase())) {
                    filterList.add(animal);
                } else if (animal.getBreed().toLowerCase().contains(nome.toLowerCase())) {
                    filterList.add(animal);
                }
            }
            if (filterList == null) {
                adapter.filterList(animalList);
                configAdapter(adapter);
            } else {
                adapter.filterList(filterList);
                configAdapter(adapter);
            }
        }
    }




    private void getAnimals() {
        LoginServices services = new RetrofitClient().getRetrofit();
        services.getAnimals().enqueue(new Callback<List<Animal>>() {
            @Override
            public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {

                animalList = (ArrayList<Animal>) response.body();
                for (Animal a : animalList){
                    Log.d("uhu", a.urlImage);
                }
                configAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<Animal>> call, Throwable t) {

            }

        });


    }

    public void configAdapter(Adapter adapter){
    adapter = new Adapter(getContext(), animalList);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(adapter);


    }
}
