package com.example.testeemjava.View;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.testeemjava.Contracts.LoginContract;
import com.example.testeemjava.Infra.RetrofitClient;
import com.example.testeemjava.Presenter.LoginPresenter;
import com.example.testeemjava.R;
import com.example.testeemjava.model.User;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    EditText editName, editSenha;
    Button button;
    RetrofitClient retrofitClient;
    TextView botaoCadastrar;
    LoginContract.Presenter presenter;
    List<User> users;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();
        showProgress(false);

        presenter = new LoginPresenter(this);//inicializa a presenter

        editName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    presenter.validUsername(editName.getText().toString());
                }
            }
        });
        editSenha.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    editSenha.getText().toString();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUsuario();
            }
        });
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastrarActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initComponents() {
        users = new ArrayList<>();
        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.button);
        botaoCadastrar = findViewById(R.id.botaoCadastrar);
        editName = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        button = findViewById(R.id.button);
    }

    public void loginUsuario(){

        presenter.login(editName.getText().toString(), editSenha.getText().toString());
//        if (presenter.validPassword(editSenha.getText().toString())) {
//
//        }
    }

    @Override
    public void navigateToList() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showProgress(final boolean show) {
        int shortAnimTime = getResources ().getInteger (android.R.integer.config_shortAnimTime);

        button.setVisibility (show ? View.INVISIBLE : View.VISIBLE);
        button.animate ().setDuration (shortAnimTime).alpha (
                show ? 0 : 1).setListener (new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                button.setVisibility (show ? View.INVISIBLE : View.VISIBLE);
            }
        });

        progressBar.setVisibility (show ? View.VISIBLE : View.GONE);
        progressBar.animate ().setDuration (shortAnimTime).alpha (
                show ? 1 : 0).setListener (new AnimatorListenerAdapter () {
            @Override
            public void onAnimationEnd(Animator animation) {
                progressBar.setVisibility (show ? View.VISIBLE : View.GONE);
            }
        });

    }

    @Override
    public void errorUsername(String s) {
        editName.setError(s);
    }


    @Override
    public void enableButton(boolean b) {
        button.setEnabled(b);
    }

    @Override
    public void errorPassword(String s) {
        editSenha.setError(s);
    }


//    public void retornaToast(){
//
//
//       LoginServices services = new RetrofitClient().getRetrofit();
//       Call<List<Animal>> login = services.getUsers();
//        login.enqueue(new Callback<List<Animal>>() {
//            @Override
//            public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {
//                try{
//                    users = response.body();
//
//                    for(Animal u : users){
//                        if(editName.getText().toString().equals(u.getEmail()) && editSenha.getText().toString().equals(u.getPassword())){
//                            Toast.makeText(LoginActivity.this, "entrou", Toast.LENGTH_SHORT).show();
//                        }else{
//                            Toast.makeText(LoginActivity.this, "Errou", Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Animal>> call, Throwable t) {
//
//            }
//        });


}
