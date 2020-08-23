package com.espeletia.petagrams3.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.espeletia.petagrams3.R;
import com.espeletia.petagrams3.pojo.Mascotas;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder>{
    private ArrayList<Mascotas> fotos;

    public PerfilAdaptador(ArrayList<Mascotas> fotos){
        this.fotos=fotos;
    }

    @NonNull
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil,parent,false);
        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PerfilViewHolder perfilViewHolder, int position) {
        Mascotas foto = fotos.get(position);
        perfilViewHolder.ivFotoP.setImageResource(foto.getIvFoto());
        perfilViewHolder.tvPLikes.setText(foto.getTvLikes());
        perfilViewHolder.ivTLikeP.setImageResource(foto.getIvTLikes());

    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivFotoP;
        private TextView tvPLikes;
        private ImageView ivTLikeP;

        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFotoP =(ImageView) itemView.findViewById(R.id.ivFotoP);
            tvPLikes =(TextView) itemView.findViewById(R.id.tvPLikes);
            ivTLikeP =(ImageView) itemView.findViewById(R.id.ivTLikeP);

        }
    }

}
