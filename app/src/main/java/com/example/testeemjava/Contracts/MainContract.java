package com.example.testeemjava.Contracts;

import android.view.MenuItem;

import androidx.fragment.app.Fragment;

import com.example.testeemjava.fragments.AddPet;

public class MainContract {

    public interface View{

        void showFragment(Fragment fragment);
    }
    public interface Presenter{

        void identifyItemClicked(MenuItem menuItem);

    }
}
