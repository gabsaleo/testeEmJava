package com.example.testeemjava.AddPetPackage;

import android.view.View;

import com.example.testeemjava.MainPackage.MainContract;

public class AddPetPresenter implements AddPetContract.Presenter{

    private AddPetContract.View view;

    public AddPetPresenter(AddPetContract.View view) {
        this.view = view;
    }
}
