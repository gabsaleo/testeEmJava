package com.example.testeemjava.Presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.testeemjava.Contracts.CadastrarContract;
import com.example.testeemjava.Infra.LoginServices;
import com.example.testeemjava.Infra.RetrofitClient;
import com.example.testeemjava.model.Address;
import com.example.testeemjava.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastrarPresenter implements CadastrarContract.Presenter {

    CadastrarContract.View view;

    public CadastrarPresenter(CadastrarContract.View view) {
        this.view = view;
    }

    @Override
    public void cadastrarUsuario(String nome, String email, String password, String phone,
                                 String rua, String nro, String cidade, String estado,
                                 String pais, String logradouro, String bairro) {
        User user = new User(null, nome, email, password, phone,
                new Address(rua, nro, cidade, estado, pais, logradouro, bairro));

        LoginServices services = new RetrofitClient().getRetrofit();
        view.showProgress(false);
        try {
            view.showProgress(true);
            Call<Void> cadastrar = services.cadastrarUser(user);
            cadastrar.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.code() == 200) {
                        view.showProgress(false);
                        Log.i("deu certo", "200");
                        Toast.makeText(view.getContext(), "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                        view.navigateToLogin();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    view.showProgress(false);
                    Toast.makeText(view.getContext(), "Não foi possivel cadastrar o usuário", Toast.LENGTH_SHORT).show();
                }

            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean validUsername(String email) {
        if (!email.matches("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + // regex para a validação de email
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+")) {
            view.errorUsername("Email inválido");//se a validação falhar, essa mensagem de erro aparecerá para o usuário

            view.enableButton(false);//se a validação falhar, o botão de "Login" é desabilitado
            return false;
        }
        view.enableButton(true);//se a validação for OK, o botão de "Login" é habilitado
        return true;

    }

    @Override
    public boolean validName(String nome) {
        if(nome.isEmpty()){
            view.errorName("O nome é obrigatório");
            view.enableButton(false);
            return false;
        }
        view.enableButton(true);
        return true;

    }

    @Override
    public boolean validPassword(String senha) {
        if(senha.isEmpty()){
            view.errorSenha("A senha é obrigatória");
            view.enableButton(false);
            return false;
        }
        view.enableButton(true);
        return true;
    }

    @Override
    public boolean validRua(String rua) {
        if(rua.isEmpty()){

            view.errorRua("O nome da rua deve ser informado");
            view.enableButton(false);
            return false;
        }
        view.enableButton(true);
        return true;
    }

    @Override
    public boolean validNroCasa(String nroCasa) {
        if(nroCasa.isEmpty()){

            view.errorNroCasa("O numero da casa deve ser informado");
            view.enableButton(false);
            return false;
        }
        view.enableButton(true);
        return true;
    }

    @Override
    public boolean validEstado(String estado) {
        if(estado.isEmpty()){

            view.errorEstado("Um estado deve ser informado");
            view.enableButton(false);
            return false;
        }
        view.enableButton(true);
        return true;
    }

    @Override
    public boolean validTelefone(String telefone) {
        if(telefone.isEmpty()){

            view.errorTelefone("Um numero de celular deve ser informado");
            view.enableButton(false);
            return false;
        }
        view.enableButton(true);
        return true;
    }

    @Override
    public boolean validCidade(String toString) {
        if(toString.isEmpty()){

            view.errorCidade("A cidade deve ser informada");
            view.enableButton(false);
            return false;
        }
        view.enableButton(true);
        return true;
    }

}//fim presenter


