package com.example.testeemjava.DetailsPackage;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testeemjava.MainPackage.MainActivity;
import com.example.testeemjava.R;
import com.example.testeemjava.model.Animal;
import com.example.testeemjava.model.UserDTO;
import com.squareup.picasso.Picasso;

public class DetailsPetActivity extends AppCompatActivity {

    TextView NomeContato, emailContato, texto, telefone, nomePet, IdadePet, RacaPet, corPet,
            generoPet, tipoPetDetails, textoCheckBox, tamanhoPetDetails, pelosPetDetails, recomendadoPetDetails;
    ImageView imagemPetDetails;
    ImageView imageVoltar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailspet);

        imagemPetDetails = findViewById(R.id.imageDetailsPet);
        imageVoltar = findViewById(R.id.imageVoltar);
        NomeContato = findViewById(R.id.textNameContato);
        emailContato = findViewById(R.id.textEmailContato);
        telefone = findViewById(R.id.textTelefoneContato);
        nomePet = findViewById(R.id.nomePetDetails);
        IdadePet = findViewById(R.id.idadePetDetails);
        recomendadoPetDetails = findViewById(R.id.recomendadoPetDetails);
        corPet = findViewById(R.id.corPetDetails);
        pelosPetDetails = findViewById(R.id.pelosPetDetails);
        generoPet = findViewById(R.id.generoPetDetails);
        RacaPet = findViewById(R.id.racaPetDetails);
        tipoPetDetails = findViewById(R.id.tipoPetDetails);
        tamanhoPetDetails = findViewById(R.id.tamanhoPetDetails);
        textoCheckBox = findViewById(R.id.textoCheckBox);

        imageVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(DetailsPetActivity.this, MainActivity.class);
            startActivity(intent);
            finish();


        });

        Bundle bundle = getIntent().getExtras();
        if (getIntent().hasExtra("animal")) {
            Animal animal = (Animal) bundle.getSerializable("animal");

            UserDTO userDTO = animal.user;
            String namePet = animal.name;
            String url = animal.urlImage;

            String idade = animal.age;
            String raca = animal.breed;
            String tipoSanguineo = animal.bloodType;
            String vacinado = String.valueOf(animal.vaccinated);
            String possuiDoenca = String.valueOf(animal.disease);
            NomeContato.setText(userDTO.getName());
            emailContato.setText(userDTO.getEmail());
            telefone.setText(userDTO.getPhone());
            String genero = animal.genre;
            String tamanho = animal.petSize;
            String pelos = animal.coatLength;
            String recomendado = animal.petRecommendedTo;
            String tipoPet = animal.petType;
            String cor = animal.color;


            Picasso.get().load(url).noFade().into(imagemPetDetails);

            if (("M").equals(genero)) {
                genero = ("Macho");
            } else {
                genero = ("Femea");
            }


            if (("DOG").equals(tipoPet) ){
                tipoPet = "Cachorro";
            }
            if (("CAT").equals(tipoPet) ){
                tipoPet = "Gato";
            }


            if (("SMALL").equals(tamanho)) {
                tamanho = "Pequeno";
            }
            if (("MEDIUM").equals(tamanho)) {
                tamanho = "Medio";
            }
            if (("LARGE").equals(tamanho)) {
                tamanho = "Grande";
            }
            if (("XL").equals(tamanho)) {
                tamanho = "Gigante";
            }


            if (("HAIRLESS").equals(pelos)) {
                pelos = "Sem pelo";
            }
            if (("SHORT").equals(pelos)) {
                pelos = "Curto";
            }
            if (("MEDIUM").equals(pelos)) {
                pelos = "Medio";
            }
            if (("LONG").equals(pelos)) {
                pelos = "Longo";
            }

            if (("KIDS").equals(recomendado)) {
                recomendado = "Para crianças";
            }
            if (("DEFICIENT").equals(recomendado)) {
                recomendado = "Para deficientes visuais";
            }
            if (("OLD_MAN").equals(recomendado)) {
                recomendado = "Para idosos";
            }
            if (("ALL").equals(recomendado)) {
                recomendado = "Para todos";
            }


            if (("false").equals(possuiDoenca)) {
                possuiDoenca = ("não possui doença");
            } else {
                possuiDoenca = ("Possui doença");
            }

            if (("false").equals(vacinado)) {
                vacinado = ("Não é vacinado");
            } else {
                vacinado = ("É vacinado");
            }
            if (("").equals(raca) || idade.equals("0")) {
                raca = ("-");
                idade = ("-");
            }

            nomePet.setText(namePet);
            IdadePet.setText(idade);
            RacaPet.setText(raca);
            corPet.setText(cor);
            generoPet.setText(genero);
            tipoPetDetails.setText(tipoPet);
            tamanhoPetDetails.setText(tamanho);
            textoCheckBox.setText(vacinado + " e " + possuiDoenca);
            pelosPetDetails.setText(pelos);
            recomendadoPetDetails.setText(recomendado);



        }


        }

    }

