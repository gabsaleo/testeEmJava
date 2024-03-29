package com.example.testeemjava.LoginPackage;

import android.content.Context;

public class LoginContract {

    public interface View{

        void navigateToList();

        Context getContext();

        void showProgress(final boolean show);

        void errorUsername(String email_inválido);

        void enableButton(boolean b);

        void errorPassword(String s);

        void finalizarActivity();
    }
    public interface Presenter{

        void login(String username, String password);

        String validUsername(String user);

        boolean validPassword(String password);
    }



}
