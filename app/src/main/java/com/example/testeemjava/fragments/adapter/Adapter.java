package com.example.testeemjava.fragments.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testeemjava.R;
import com.example.testeemjava.View.DetailsPetActivity;
import com.example.testeemjava.View.LoginActivity;
import com.example.testeemjava.View.MainActivity;
import com.example.testeemjava.model.Animal;
import com.example.testeemjava.model.UserDTO;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private Context context;
    private List<Animal> animals;

    public Adapter(Context context, List<Animal> animals) {
        this.context = context;
        this.animals = animals;
    }



    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        try {
            final Animal animal = animals.get(position);

            final String imageUrl = animal.urlImage;
            final String name = animal.name;
            holder.texto.setText(name);
            Log.d("url", imageUrl);

            holder.imagem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UserDTO userDTO = animal.user;

                    Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, DetailsPetActivity.class);
                    Bundle extras = new Bundle();
                    extras.putString("Nome", animal.name);
                    extras.putString("URL", imageUrl);
                    extras.putString("Idade", animal.age);
                    extras.putString("Raca", animal.breed);
                    extras.putString("TipoSanguineo", animal.bloodType);
                    extras.putString("Vacinado", String.valueOf(animal.vaccinated));
                    extras.putString("PossuiDoenca", String.valueOf(animal.disease));
                    extras.putString("NomeContato", userDTO.getName());
                    extras.putString("EmailContato", userDTO.getEmail());
                    extras.putString("Genero", animal.genre);
                    extras.putString("Tamanho", animal.petSize);
                    extras.putString("TipoPet", animal.petType);
                    extras.putString("Pelos", animal.coatLength);
                    extras.putString("Cor", animal.color);
                    extras.putString("Recomendado", animal.petRecommendedTo);
                    intent.putExtras(extras);
                    context.startActivity(intent);

                }
            });


            Picasso.get().load(imageUrl).noFade().into(holder.imagem);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        if(animals != null)
            return animals.size();
        else return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView texto;
        ImageView imagem;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            texto = itemView.findViewById(R.id.title);
            imagem = itemView.findViewById(R.id.image);


//            imagem.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(context, Details.class)
//
//                    String nomeCachorro = texto.getText().toString();
//                    Toast.makeText(itemView.getContext(), "Clicou em " + nomeCachorro, Toast.LENGTH_SHORT).show();
//                }
//            });
        }
    }
}
