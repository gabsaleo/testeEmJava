package com.example.testeemjava.DetailsPackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testeemjava.MainPackage.MainActivity;
import com.example.testeemjava.R;
import com.example.testeemjava.Model.Animal;
import com.example.testeemjava.Model.UserDTO;
import com.squareup.picasso.Picasso;

public class DetailsPetActivity extends AppCompatActivity {

    TextView NomeContato, emailContato, texto, telefone, nomePet, IdadePet, RacaPet;
    ImageView imagemPetDetails, imageEditar;
    ImageView imageVoltar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailspet);

        String substantivo = "";
        String pronome = "";
        String Este = "";
        String substantivoMin = "";
        String pronomeMin = "";
        String um = "";



        imagemPetDetails = findViewById(R.id.imageDetailsPet);
        imageVoltar = findViewById(R.id.imageVoltar);
        NomeContato = findViewById(R.id.textNameContato);
        emailContato = findViewById(R.id.textEmailContato);
        telefone = findViewById(R.id.textTelefoneContato);
        nomePet = findViewById(R.id.nomePetDetails);
        IdadePet = findViewById(R.id.idadePetDetails);
        RacaPet = findViewById(R.id.racaPetDetails);
        texto = findViewById(R.id.textTexto);

        

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
                genero = (" macho");
            } else {
                genero = (" femea");
            }


            if (("DOG").equals(tipoPet) && (" macho").equals(genero)) {
                tipoPet = " cachorro";
            }
            if (("CAT").equals(tipoPet) && (" macho").equals(genero)) {
                tipoPet = " gato";
            }
            if (("DOG").equals(tipoPet) && (" femea").equals(genero)) {
                tipoPet = " cadela";
            }
            if (("CAT").equals(tipoPet) && (" femea").equals(genero)) {
                tipoPet = " gata";
            }

            if (("SMALL").equals(tamanho) && (" macho").equals(genero)) {
                tamanho = "pequeno";
            }
            if (("MEDIUM").equals(tamanho) && (" macho").equals(genero)) {
                tamanho = "medio";
            }
            if (("SMALL").equals(tamanho) && (" femea").equals(genero)) {
                tamanho = "pequena";
            }
            if (("MEDIUM").equals(tamanho) && (" femea").equals(genero)) {
                tamanho = "media";
            }
            if (("LARGE").equals(tamanho)) {
                tamanho = "grande";
            }
            if (("XL").equals(tamanho)) {
                tamanho = "gigante";
            }


            if (("HAIRLESS").equals(pelos)) {
                pelos = "sem pelo";
            }
            if (("SHORT").equals(pelos)) {
                pelos = "curto";
            }
            if (("MEDIUM").equals(pelos)) {
                pelos = "medio";
            }
            if (("LONG").equals(pelos)) {
                pelos = "longo";
            }

            if (("KIDS").equals(recomendado)) {
                recomendado = "para crianças";
            }
            if (("DEFICIENT").equals(recomendado)) {
                recomendado = "para deficientes visuais";
            }
            if (("OLD_MAN").equals(recomendado)) {
                recomendado = "para idosos";
            }
            if (("ALL").equals(recomendado)) {
                recomendado = "para todos";
            }


            if (("false").equals(possuiDoenca)) {
                possuiDoenca = (" nao possui doença");
            } else {
                possuiDoenca = (" possui doença");
            }

            if (("false").equals(vacinado)) {
                vacinado = (" nao é vacinado");
            } else {
                vacinado = (" é vacinado");
            }
            if (("").equals(raca) || idade.equals("0")) {
                raca = ("A raça nao foi informada");
                idade = ("A idade nao foi informada");
            }
            if ((" macho").equals(genero)) {
                substantivo = "O ";
                pronome = "Ele ";
                Este = "Este ";
                substantivoMin = "o ";
                pronomeMin = "ele ";
                um = " um ";

            }
            if ((" femea").equals(genero)) {
                substantivo = "A ";
                pronome = "Ela ";
                Este = "Esta ";
                substantivoMin = "a ";
                pronomeMin = "ela ";
                um = " uma ";

            }

            nomePet.setText(namePet);
            IdadePet.setText(idade);
            RacaPet.setText(raca);
            texto.setText(Este + " é " + substantivoMin + namePet + ". " +
                    pronome + " tem " + idade + " anos" + " é" + um + tipoPet + genero +
                    " e é da raça " + raca + ". " + pronome + vacinado
                    + " e" + possuiDoenca + ", " + pronomeMin + "é " + tamanho + ", "
                    + "tem a pelagem " + pelos + ", possui a cor " + cor + ", e é recomendado " + recomendado + ".");


        } //String url = idade.getText().toString();


        }

    }

