package com.example.testeemjava.View;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.testeemjava.Contracts.CadastrarContract;
import com.example.testeemjava.Infra.LoginServices;
import com.example.testeemjava.Infra.RetrofitClient;
import com.example.testeemjava.Others.MaskEditUtil;
import com.example.testeemjava.Presenter.CadastrarPresenter;
import com.example.testeemjava.R;
import com.example.testeemjava.model.Address;
import com.example.testeemjava.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastrarActivity extends AppCompatActivity implements CadastrarContract.View {


    CadastrarContract.Presenter presenter;
    EditText editNome, editEmail, editSenha;
    EditText editCidade, editPais, editRua, editNro, editEstado, editLogradouro, editBairro;
    Button button;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        presenter = new CadastrarPresenter(this);

        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);

        editRua = findViewById(R.id.editRua);
        editNro = findViewById(R.id.editNroCasa);
        editCidade = findViewById(R.id.editCidade);
        editEstado = findViewById(R.id.editEstado);
        editPais = findViewById(R.id.editPais);
        editLogradouro = findViewById(R.id.editLogradouro);
        editBairro = findViewById(R.id.editBairro);

        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.botaoCadastrar);

        showProgress(false);

        editEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    presenter.validUsername(editEmail.getText().toString());
                }
            }
        });








        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
            }
        });

    }



    private void cadastrarUsuario() {
        presenter.cadastrarUsuario(editNome.getText().toString(), editEmail.getText().toString(),
                editSenha.getText().toString(), editRua.getText().toString(), editNro.getText().toString(),
                editCidade.getText().toString(), editEstado.getText().toString(),
                editPais.getText().toString(), editLogradouro.getText().toString(), editBairro.getText().toString());
//        Address adresss = new Address();


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
    public void navigateToLogin() {
        Intent intent = new Intent(CadastrarActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void errorUsername(String s) {
        editEmail.setError(s);
    }

    @Override
    public void enableButton(boolean b) {
        button.setEnabled(b);
    }
}
