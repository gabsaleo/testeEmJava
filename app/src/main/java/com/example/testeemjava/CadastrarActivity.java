package com.example.testeemjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testeemjava.model.Address;
import com.example.testeemjava.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastrarActivity extends AppCompatActivity {

    EditText editNome, editEmail, editSenha;
    EditText editCidade, editPais, editRua, editNro, editEstado, editLogradouro, editBairro;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

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


        button= findViewById(R.id.botaoCadastrar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });



    }

    private void cadastrar() {
//        Address adresss = new Address();

        User user = new User(editNome.getText().toString(),
                editEmail.getText().toString(), editSenha.getText().toString(),

                new Address(editRua.getText().toString(), editNro.getText().toString(),
                        editCidade.getText().toString(), editEstado.getText().toString(),
                        editPais.getText().toString(), editLogradouro.getText().toString(), editBairro.getText().toString()));
        Log.d("pegou", user.toString());
        Log.d("id", String.valueOf(user.getId()));

        LoginServices services = new RetrofitClient().getRetrofit();
        Call<Void> cadastrar = services.cadastrarUser(user);
        cadastrar.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code() == 200) {
                    Log.i("deu certo", "200");
                    Toast.makeText(CadastrarActivity.this, "usuario cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CadastrarActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });


    }
}
