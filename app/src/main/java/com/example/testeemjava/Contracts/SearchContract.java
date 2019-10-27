package com.example.testeemjava.Contracts;

import com.example.testeemjava.fragments.adapter.Adapter;

public class SearchContract {

    public interface View{

        void configAdapter(Adapter adapter);
    }
    public interface Presenter{

        void filter(String trim);

        void getAnimals();
    }


}
