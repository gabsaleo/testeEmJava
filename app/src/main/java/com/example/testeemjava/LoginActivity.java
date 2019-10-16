package com.example.testeemjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testeemjava.model.User;
import com.example.testeemjava.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText editName, editSenha;
    Button button;
    RetrofitClient retrofitClient;
    TextView botaoCadastrar;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();

        if (editName == null) {
            Toast.makeText(this, "Email nao pode ser nulo", Toast.LENGTH_SHORT).show();
        }
        if (editSenha == null) {
            Toast.makeText(this, "Senha nao pode ser nula", Toast.LENGTH_SHORT).show();
        }

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
        botaoCadastrar = findViewById(R.id.botaoCadastrar);
        editName = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        button = findViewById(R.id.button);
    }

    public void loginUsuario(){
        final User user = new User(editName.getText().toString(), editSenha.getText().toString());
        LoginServices services = new RetrofitClient().getRetrofit();
        Call<UserDTO> login = services.loginUser(user);
        login.enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                if(response.code() == 200){
                    Log.i("deu bom", "200");
                    Toast.makeText(LoginActivity.this, "uhuuuu", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    UserDTO body = response.body();
                    AppPet.setUserDTO(body);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Algo deu errado", Toast.LENGTH_SHORT).show();
                t.getMessage();
            }
        });

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
