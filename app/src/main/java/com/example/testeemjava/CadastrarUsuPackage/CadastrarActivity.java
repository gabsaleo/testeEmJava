package com.example.testeemjava.CadastrarUsuPackage;

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
import android.widget.Toast;

import com.example.testeemjava.LoginPackage.LoginActivity;
import com.example.testeemjava.Others.MaskEditUtil;
import com.example.testeemjava.R;
import com.example.testeemjava.model.UserDTO;

public class CadastrarActivity extends AppCompatActivity implements CadastrarContract.View {

    public static final String USER = "user";
    CadastrarContract.Presenter presenter;
    EditText editNome, editEmail, editSenha;
    EditText editCidade, editPais, editRua, editNro, editEstado, editLogradouro, editBairro, editTelefone;
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
        editTelefone = findViewById(R.id.editTelefone);

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
        //atualizar();



        editTelefone.addTextChangedListener(MaskEditUtil.mask(editTelefone, MaskEditUtil.FORMAT_CEL));

        editEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    presenter.validUsername(editEmail.getText().toString());
                }
            }
        });
        editNome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    presenter.validName(editNome.getText().toString());
                }
            }
        });
        editSenha.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    presenter.validPassword(editSenha.getText().toString());
                }
            }
        });
        editRua.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    presenter.validRua(editRua.getText().toString());
                }
            }
        });
        editNro.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    presenter.validNroCasa(editNro.getText().toString());
                }
            }
        });
        editEstado.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    presenter.validEstado(editEstado.getText().toString());
                }
            }
        });
        editCidade.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    presenter.validCidade(editCidade.getText().toString());
                }
            }
        });

        editTelefone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    presenter.validTelefone(editTelefone.getText().toString());
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
                editSenha.getText().toString(),editTelefone.getText().toString(), editRua.getText().toString(),
                editNro.getText().toString(), editCidade.getText().toString(), editEstado.getText().toString(),
                editPais.getText().toString(), editLogradouro.getText().toString(), editBairro.getText().toString());


    }
    private void atualizar(){

            editSenha.setVisibility(View.INVISIBLE);
            UserDTO userDTO = (UserDTO) getIntent().getSerializableExtra("user");
            userDTO.setId(userDTO.getId());
            editNome.setText(userDTO.getName());
            editEmail.setText(userDTO.getEmail());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(CadastrarActivity.this, "foi", Toast.LENGTH_SHORT).show();
                }
            });
//            editTelefone.setText(AppPet.getUserDTO().getPhone());
//            editRua.setText(AppPet.getUserDTO().getAddress().getStreet());
//            editNro.setText(AppPet.getUserDTO().getAddress().getNumber());
//            editCidade.setText(AppPet.getUserDTO().getAddress().getCity());
//            editEstado.setText(AppPet.getUserDTO().getAddress().getState());
//            editPais.setText(AppPet.getUserDTO().getAddress().getCountry());
//            editLogradouro.setText(AppPet.getUserDTO().getAddress().getComplements());
//            editBairro.setText(AppPet.getUserDTO().getAddress().getDistrict());


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

    @Override
    public void errorName(String nome) {
        editNome.setError(nome);
    }

    @Override
    public void errorSenha(String senha) {
        editSenha.setError(senha);
    }

    @Override
    public void errorRua(String rua) {
        editRua.setError(rua);
    }

    @Override
    public void errorNroCasa(String nroCasa) {
        editNro.setError(nroCasa);
    }
    @Override
    public void errorEstado(String estado) {
        editEstado.setError(estado);
    }

    @Override
    public void errorCidade(String cidade) {
        editCidade.setError(cidade);
    }

    @Override
    public void errorTelefone(String s) {
        editTelefone.setError(s);
    }

}
