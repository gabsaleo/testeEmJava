package com.example.testeemjava.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testeemjava.Contracts.SearchContract;
import com.example.testeemjava.Infra.LoginServices;
import com.example.testeemjava.Infra.RetrofitClient;
import com.example.testeemjava.Presenter.SearchPresenter;
import com.example.testeemjava.R;
import com.example.testeemjava.fragments.adapter.Adapter;
import com.example.testeemjava.model.Animal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Search extends Fragment implements SearchContract.View {

    private List<Animal> animalList = new ArrayList<>();
    View view;
    EditText editBusca;
    private Adapter adapter;
    SearchContract.View viewSearch;
    RecyclerView recyclerView;
    SearchContract.Presenter presenter;

    public Search(SearchContract.View view) {
        viewSearch = view;
        this.presenter = new SearchPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);



        editBusca = view.findViewById(R.id.editBusca);
        recyclerView = view.findViewById(R.id.recyclerViewBusca);

        presenter.getAnimals();
        return view;
    }

    public void configAdapter (Adapter adapterList) {
        adapter = new Adapter(getContext(), animalList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapterList);


    }//fim configAdapter
    
    @Override
    public void onResume() {
        super.onResume();
        editBusca.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.filter(s.toString().trim());
            }
        });
    }


}//fim class
