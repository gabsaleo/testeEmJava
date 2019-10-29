package com.example.testeemjava.Contracts;

import android.content.Context;

import com.example.testeemjava.fragments.adapter.Adapter;

public class SearchContract {

    public interface View{

        void configAdapter(Adapter adapter);

        Context getContext();
    }
    public interface Presenter{

        void filter(String trim);

        void getAnimals();
    }


}
