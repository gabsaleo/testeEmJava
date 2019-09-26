package com.example.testeemjava.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.testeemjava.R;

public class Menu extends Fragment {

    private View view;
    private TextView textViewNome, textEmail;
    private Button botaoSair;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_menu, container, false);
        textViewNome =   view.findViewById(R.id.textNome);
        textEmail = view.findViewById(R.id.textEmail);
        botaoSair = view.findViewById(R.id.botaoSair);




        return view;

    }
}
