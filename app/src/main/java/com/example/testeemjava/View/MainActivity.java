package com.example.testeemjava.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.testeemjava.Contracts.MainContract;
import com.example.testeemjava.Presenter.MainPresenter;
import com.example.testeemjava.R;
import com.example.testeemjava.fragments.AddPet;
import com.example.testeemjava.fragments.Home;
import com.example.testeemjava.fragments.Menu;
import com.example.testeemjava.fragments.Search;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private BottomNavigationView bottomNavigationView;
    private Fragment AddPet;
    private View view;
    MainContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
       bottomNavigationView.setOnNavigationItemSelectedListener( menuItem -> {
            presenter.identifyItemClicked(menuItem);
            return true;
       });
        showFragment(new Home(this));

    }

    public void showFragment(Fragment fragment){
        getSupportFragmentManager ()
                .beginTransaction ()
                .replace (R.id.frame_layout_home, fragment)
                .commit ();
    }

}
