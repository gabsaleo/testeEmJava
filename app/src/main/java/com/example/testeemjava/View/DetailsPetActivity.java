package com.example.testeemjava.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testeemjava.R;
import com.squareup.picasso.Picasso;

public class DetailsPetActivity extends AppCompatActivity {

    TextView namePet, idade, raca, tipoSanguineo, vacinado, possuiDoenca,
            NomeContato, emailContato, genre, texto;
    ImageView imagemPetDetails;
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


        namePet = findViewById(R.id.textNameDetails);
        idade = findViewById(R.id.textIdadeDetails);
        imagemPetDetails = findViewById(R.id.imageDetailsPet);
        imageVoltar = findViewById(R.id.imageVoltar);
        raca = findViewById(R.id.textRacaDetails);
        tipoSanguineo = findViewById(R.id.textTipoSanguineoDetails);
        vacinado = findViewById(R.id.textVacinado);
        possuiDoenca = findViewById(R.id.textPossuiDoencaDetails);
        NomeContato = findViewById(R.id.textNameContato);
        emailContato = findViewById(R.id.textEmailContato);
        genre = findViewById(R.id.textGenre);
        texto = findViewById(R.id.textTexto);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            namePet.setText(bundle.getString("Nome"));
            String url = bundle.getString("URL");
            idade.setText(bundle.getString("Idade"));
            raca.setText(bundle.getString("Raca"));
            tipoSanguineo.setText(bundle.getString("TipoSanguineo"));
            vacinado.setText(bundle.getString("Vacinado"));
            possuiDoenca.setText(bundle.getString("PossuiDoenca"));
            NomeContato.setText(bundle.getString("NomeContato"));
            emailContato.setText(bundle.getString("EmailContato"));
            genre.setText(bundle.getString("Genero"));
            String tamanho = bundle.getString("Tamanho");
            String pelos = bundle.getString("Pelos");
            String recomendado = bundle.getString("Recomendado");
            String tipoPet = bundle.getString("TipoPet");
            String cor = bundle.getString("Cor");


            Picasso.get().load(url).noFade().into(imagemPetDetails);

            if (("M").equals(genre.getText())) {
                genre.setText(" macho");
            } else {
                genre.setText(" femea");
            }


            if (("DOG").equals(tipoPet) && (" macho").equals(genre.getText())) {
                tipoPet = " cachorro";
            }
            if (("CAT").equals(tipoPet) && (" macho").equals(genre.getText())) {
                tipoPet = " gato";
            }
            if (("DOG").equals(tipoPet) && (" femea").equals(genre.getText())) {
                tipoPet = " cadela";
            }
            if (("CAT").equals(tipoPet) && (" femea").equals(genre.getText())) {
                tipoPet = " gata";
            }

//            if(("DOG").equals(tipoPet)){
//                tipoPet = " cachorro";
//            }if(("CAT").equals(tipoPet)){
//                tipoPet = " gato";
//            }

            if (("SMALL").equals(tamanho) && (" macho").equals(genre.getText())) {
                tamanho = "pequeno";
            }
            if (("MEDIUM").equals(tamanho) && (" macho").equals(genre.getText())) {
                tamanho = "medio";
            }
            if (("SMALL").equals(tamanho) && (" femea").equals(genre.getText())) {
                tamanho = "pequena";
            }
            if (("MEDIUM").equals(tamanho) && (" femea").equals(genre.getText())) {
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


                if (("false").equals(possuiDoenca.getText().toString())) {
                    possuiDoenca.setText(" nao possui doença");
                } else {
                    possuiDoenca.setText(" possui doença");
                }

                if (("false").equals(vacinado.getText().toString())) {
                    vacinado.setText(" nao é vacinado");
                } else {
                    vacinado.setText(" é vacinado");
                }
                if (("").equals(raca.getText().toString()) || ("0").equals(idade.getText().toString())) {
                    raca.setText("A raça nao foi informada");
                    idade.setText("A idade nao foi informada");
                }
                if ((" macho").equals(genre.getText())) {
                    substantivo = "O ";
                    pronome = "Ele ";
                    Este = "Este ";
                    substantivoMin = "o ";
                    pronomeMin = "ele ";
                    um = " um ";

                }
                if ((" femea").equals(genre.getText())) {
                    substantivo = "A ";
                    pronome = "Ela ";
                    Este = "Esta ";
                    substantivoMin = "a ";
                    pronomeMin = "ela ";
                    um = " uma ";

                }
                

                texto.setText(Este + " é " + substantivoMin + namePet.getText() + ". " +
                        pronome + " tem " + idade.getText() + " anos" + " é" + um + tipoPet + genre.getText() +
                        " e é da raça " + raca.getText() + ". " + pronome + vacinado.getText()
                        + " e" + possuiDoenca.getText() + ", " + pronomeMin + "é " + tamanho + ", "
                        + "tem a pelagem " + pelos + ", possui a cor " + cor + ", e é recomendado " + recomendado + ".");


            }


            imageVoltar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DetailsPetActivity.this, MainActivity.class);
                    startActivity(intent);

                }
            });
            //String url = idade.getText().toString();


        }
    }

