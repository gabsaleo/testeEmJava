package com.example.testeemjava.SearchPackage;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testeemjava.MainPackage.MainContract;
import com.example.testeemjava.R;
import com.example.testeemjava.HomePackage.adapter.Adapter;
import com.example.testeemjava.Model.Animal;

import java.util.ArrayList;
import java.util.List;

public class Search extends Fragment implements SearchContract.View {

    private List<Animal> animalList = new ArrayList<>();
    View view;
    EditText editBusca;
    SearchContract.View viewSearch;
    RecyclerView recyclerView;
    SearchContract.Presenter presenter;
    private Adapter mAdapter;
    MainContract.View viewContract;
    private RecyclerView.LayoutManager mLayoutManager;

    public Search(MainContract.View viewContract) {
        this.viewContract = viewContract;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        this.presenter = new SearchPresenter(this);

        editBusca = view.findViewById(R.id.editBusca);
        recyclerView = view.findViewById(R.id.recyclerViewBusca);
        mAdapter = new Adapter(getContext(), animalList);


        presenter.getAnimals();

        return view;
    }

    public void configAdapter(Adapter adapter){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);


    }//fim configAdapter
    @Override
    public void onResume() {
        super.onResume();
        editBusca.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.filter(s.toString().trim());
            }
        });
    }




}//fim class
