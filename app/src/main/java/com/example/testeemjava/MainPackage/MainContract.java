package com.example.testeemjava.MainPackage;

import android.view.MenuItem;

import androidx.fragment.app.Fragment;

public class MainContract {

    public interface View{

        void showFragment(Fragment fragment);
    }
    public interface Presenter{

        void identifyItemClicked(MenuItem menuItem);

    }
}
