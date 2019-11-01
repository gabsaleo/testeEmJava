package com.example.testeemjava.LoginPackage;

import android.util.Log;
import android.widget.Toast;

import com.example.testeemjava.Others.AppPet;
import com.example.testeemjava.LoginPackage.LoginContract;
import com.example.testeemjava.Infra.LoginServices;
import com.example.testeemjava.Infra.RetrofitClient;
import com.example.testeemjava.Model.User;
import com.example.testeemjava.Model.UserDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {

    public LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void login(String username, String password) {
        final User user = new User(username, password);
        LoginServices services = new RetrofitClient().getRetrofit();
        view.showProgress(false);
        try {
            view.showProgress(true);
//            view.enableButton(false);
            Call<UserDTO> login = services.loginUser(user);
            login.enqueue(new Callback<UserDTO>() {
                @Override
                public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                    if (response.code() == 200) {
                        view.showProgress(false);
//                        view.enableButton(true);
                        UserDTO body = response.body();
                        AppPet.setUserDTO(body);
                        Log.d("body", body.toString());
                        view.navigateToList();
                        view.finalizarActivity();


                    }
                }

                @Override
                public void onFailure(Call<UserDTO> call, Throwable t) {
                    view.showProgress(false);
                    Toast.makeText(view.getContext(), "Algo deu errado", Toast.LENGTH_SHORT).show();
                    t.getMessage();
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
        }

    @Override
    public String validUsername(String username) {
        if (!username.matches("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + // regex para a validação de email
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+")) {
            view.errorUsername("Email inválido");//se a validação falhar, essa mensagem de erro aparecerá para o usuário

            view.enableButton(false);//se a validação falhar, o botão de "Login" é desabilitado
        }
        view.enableButton(true);//se a validação for OK, o botão de "Login" é habilitado
        return username;
    }

    @Override
    public boolean validPassword(String password) {
        if (password.matches("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]" +
                "(?=.*[!@#$*_%^&+=])(?=\\S+$)(?=\\S+$).{3,}$")) { // regex para validação de senha

            return true;
        }
        view.errorPassword("A senha deve no minímo 4 caracteres, 1 caractere maiúsculo," +
                " 1 caractere especial e 1 número");//se a validação falhar, essa mensagem de erro aparecerá para o usuário
        return false;
    }
}
