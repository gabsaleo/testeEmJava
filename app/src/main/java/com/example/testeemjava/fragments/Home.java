package com.example.testeemjava.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testeemjava.Adapter;
import com.example.testeemjava.Animal;
import com.example.testeemjava.R;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {

    private List<Animal> animalList;
    private View view;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        loadUI();
        inputList();
        configAdapter();

        return view;

    }

    private void inputList() {

        if(animalList == null){
            animalList = new ArrayList<Animal>();
            animalList.add(new Animal("Astolfo", R.drawable.beagle));
            animalList.add(new Animal("Mel", R.drawable.dog_grande));
            animalList.add(new Animal("Caixinha", R.drawable.doguineo));
        }
    }
    private void loadUI(){
        recyclerView = view.findViewById(R.id.recyclerView);
    }
    private void configAdapter(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        Adapter adapter = new Adapter(animalList);
        recyclerView.setAdapter(adapter);
    }
}
