package com.example.testeemjava.MainPackage;

import android.view.MenuItem;

import com.example.testeemjava.R;
import com.example.testeemjava.AddPetPackage.AddPet;
import com.example.testeemjava.HomePackage.Home;
import com.example.testeemjava.fragments.Menu;
import com.example.testeemjava.SearchPackage.Search;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }



    @Override
    public void identifyItemClicked(MenuItem menuItem) {
        switch(menuItem.getItemId()){

            case(R.id.ic_home):
                view.showFragment(new Home(view));
                break;
            case(R.id.ic_add_pet):
                view.showFragment(new AddPet(view));
                break;

            case(R.id.ic_search):
                view.showFragment(new Search(view));
                break;

            case(R.id.ic_menu):
                view.showFragment(new Menu());
                break;


        }
    }
}
