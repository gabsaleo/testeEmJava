package com.example.testeemjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private List<Animal> animals;
    public Adapter(List<Animal> animals) {
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
        Animal animal = animals.get(position);
        holder.texto.setText(animal.getNome());
        holder.imagem.setImageResource(animal.getIdAnimal());

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

            imagem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String nomeCachorro = texto.getText().toString();
                    Toast.makeText(itemView.getContext(), "Clicou em " + nomeCachorro, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
