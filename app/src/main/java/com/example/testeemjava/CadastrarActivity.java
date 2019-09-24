package com.example.testeemjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastrarActivity extends AppCompatActivity {

    EditText editNome, editEmail, editSenha;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        button= findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });



    }

    private void cadastrar() {
        
        User user = new User(editNome.getText().toString(),
                editEmail.getText().toString(), editSenha.getText().toString());
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
