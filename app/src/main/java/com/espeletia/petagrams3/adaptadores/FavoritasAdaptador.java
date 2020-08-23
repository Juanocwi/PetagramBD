package com.espeletia.petagrams3.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.espeletia.petagrams3.pojo.Mascotas;
import com.espeletia.petagrams3.R;

import java.util.ArrayList;

public class FavoritasAdaptador extends RecyclerView.Adapter<FavoritasAdaptador.FavoritasViewHolder>{
    ArrayList<Mascotas> favoritas;

    public FavoritasAdaptador(ArrayList<Mascotas> favoritas){
        this.favoritas=favoritas;
    }



    @NonNull
    @Override
    public FavoritasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new FavoritasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritasViewHolder FavoritasViewHolder, int position) {
        Mascotas favorita = favoritas.get(position);
        FavoritasViewHolder.ivFoto.setImageResource(favorita.getIvFoto());
        FavoritasViewHolder.ivLike.setImageResource(favorita.getIvLike());
        FavoritasViewHolder.ivTLike.setImageResource(favorita.getIvTLikes());
        FavoritasViewHolder.tvNombre.setText(favorita.getTvNombre());
        FavoritasViewHolder.tvLikes.setText(favorita.getTvLikes());
    }

    @Override
    public int getItemCount() {
        return favoritas.size();
    }

    public static class FavoritasViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivFoto, ivLike, ivTLike;
        private TextView tvNombre,tvLikes;

        public FavoritasViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto      = (ImageView) itemView.findViewById(R.id.ivFoto);
            ivLike      = (ImageView) itemView.findViewById(R.id.ivLike);
            ivTLike     = (ImageView) itemView.findViewById(R.id.ivTLike);
            tvNombre    = (TextView)  itemView.findViewById(R.id.tvNombre);
            tvLikes     = (TextView)  itemView.findViewById(R.id.tvLikes);
        }
    }
}
