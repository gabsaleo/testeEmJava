package com.example.testeemjava.fragments.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testeemjava.R;
import com.example.testeemjava.model.Animal;
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
        Animal animal = animals.get(position);

        String imageUrl = animal.urlImage;
        String name = animal.name;
        holder.texto.setText(name);

        Picasso.get().load(imageUrl).fit().into(holder.imagem);



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
//                    String nomeCachorro = texto.getText().toString();
//                    Toast.makeText(itemView.getContext(), "Clicou em " + nomeCachorro, Toast.LENGTH_SHORT).show();
//                }
//            });
        }
    }
}
