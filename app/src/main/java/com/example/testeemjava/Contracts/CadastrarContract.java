package com.example.testeemjava.Contracts;

import android.content.Context;

public class CadastrarContract {

    public interface View{

        Context getContext();

        void showProgress(boolean b);

        void navigateToLogin();

        void errorUsername(String s);

        void enableButton(boolean b);

        void errorName(String nome);

        void errorSenha(String senha);

        void errorRua(String rua);

        void errorNroCasa(String nroCasa);

        void errorEstado(String estado);

        void errorCidade(String cidade);

        void errorTelefone(String s);
    }






    public interface Presenter{
        void cadastrarUsuario(String nome, String email, String password,String telefone,String rua, String nro,
                              String cidade, String estado, String pais, String logradouro, String bairro);

        boolean validUsername(String email);

        boolean validName(String nome);

        boolean validPassword(String senha);

        boolean validRua(String rua);

        boolean validNroCasa(String nroCasa);

        boolean validEstado(String estado);

        boolean validTelefone(String telefone);

        boolean validCidade(String toString);
    }



}
