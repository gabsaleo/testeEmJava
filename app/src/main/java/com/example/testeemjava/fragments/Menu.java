package com.example.testeemjava.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.testeemjava.Others.AppPet;
import com.example.testeemjava.R;
import com.example.testeemjava.CadastrarUsuPackage.CadastrarActivity;

public class Menu extends Fragment {

    private View view;
    private TextView textViewNome, textEmail;
    private Button botaoSair, botaoAlterar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_menu, container, false);
        textViewNome =   view.findViewById(R.id.textNome);
        textEmail = view.findViewById(R.id.textEmail);
        botaoSair = view.findViewById(R.id.botaoSair);
        botaoAlterar = view.findViewById(R.id.botaoAlterar);


        textViewNome.setText(AppPet.getUserDTO().getName());
        textEmail.setText(AppPet.getUserDTO().getEmail());
        botaoAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CadastrarActivity.class);
                intent.putExtra("user", AppPet.getUserDTO());
                startActivity(intent);
            }
        });
        botaoSair.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "clicou em sair", Toast.LENGTH_SHORT).show();
            }
        });

//        Bundle bundle = new Bundle();
        return view;

    }
}
