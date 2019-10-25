package com.example.testeemjava.Contracts;

import android.content.Context;

public class CadastrarContract {

    public interface View{

        Context getContext();

        void showProgress(boolean b);

        void navigateToLogin();

        void errorUsername(String s);

        void enableButton(boolean b);
    }






    public interface Presenter{
        void cadastrarUsuario(String nome, String email, String password,String telefone,String rua, String nro,
                              String cidade, String estado, String pais, String logradouro, String bairro);

        boolean validUsername(String email);
    }



}
