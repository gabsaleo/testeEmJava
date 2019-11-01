package com.example.testeemjava.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.testeemjava.Others.AppPet;
import com.example.testeemjava.R;
import com.example.testeemjava.CadastrarUsuPackage.CadastrarActivity;

public class Menu extends Fragment {

    private View view;
    private TextView textViewNome, textEmail, textTelefone, Rua, Nro, Bairro, Cidade, Estado;
    private Button botaoSair, botaoAlterar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_menu, container, false);
        textViewNome =   view.findViewById(R.id.textNome);
        textEmail = view.findViewById(R.id.textEmail);
        botaoSair = view.findViewById(R.id.botaoSair);
        textTelefone = view.findViewById(R.id.textTelefone);
        Rua = view.findViewById(R.id.textRua);
        Nro = view.findViewById(R.id.textNro);
        Bairro = view.findViewById(R.id.textBairro);
        Cidade = view.findViewById(R.id.textCidade);
        Estado = view.findViewById(R.id.textEstado);



        textViewNome.setText(AppPet.getUserDTO().getName());
        textEmail.setText(AppPet.getUserDTO().getEmail());
        textTelefone.setText(AppPet.getUserDTO().getPhone());
        Rua.setText(AppPet.getUserDTO().getAddress().getStreet());
        Nro.setText(AppPet.getUserDTO().getAddress().getNumber());
        Bairro.setText(AppPet.getUserDTO().getAddress().getDistrict());
        Cidade.setText(AppPet.getUserDTO().getAddress().getCity());
        Estado.setText(AppPet.getUserDTO().getAddress().getState());
        botaoSair.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog (getContext(), R.style.CustomAlertDialog);
                dialog.requestWindowFeature (Window.FEATURE_NO_TITLE);
                dialog.setContentView (layout);
                dialog.setCancelable (false);
                dialog.getWindow ().setSoftInputMode (WindowManager.LayoutParams.
                        SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                dialog.show();
            }
        });

//        Bundle bundle = new Bundle();
        return view;

    }
}
