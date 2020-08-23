package com.espeletia.petagrams3.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.espeletia.petagrams3.db.ConstructorMascotasdb;
import com.espeletia.petagrams3.pojo.Mascotas;
import com.espeletia.petagrams3.R;

import java.util.ArrayList;

public class MascotasAdaptador extends RecyclerView.Adapter <MascotasAdaptador.MascotasViewHolder> {

    private ArrayList<Mascotas> mascotas;//private MascotasViewHolder.ViewHolderClick mlistener;
    private int like;
    Context context;
    public MascotasAdaptador(ArrayList<Mascotas> mascotas, Context context){
        this.mascotas=mascotas;
        this.context=context;
    }

    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Darle vida al CardView
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent,false);
        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotasViewHolder mascotasViewHolder, final int position) { //Asociar cada Elemento de la lista con los views
        final Mascotas mascota = mascotas.get(position);
        mascotasViewHolder.ivFoto.setImageResource(mascota.getIvFoto());
        mascotasViewHolder.ivTLike.setImageResource(mascota.getIvTLikes());
        mascotasViewHolder.tvNombre.setText(mascota.getTvNombre());
        mascotasViewHolder.tvLikes.setText(mascota.getTvLikes());
        //acciones al hacer clic en el elemento del cardview cambio de imagen al darle like y suma del total de likes
        mascotasViewHolder.ivLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstructorMascotasdb constructorMascotasdb = new ConstructorMascotasdb(context);

//                mascotasViewHolder.tvLikes.setText(constructorMascotasdb.obtenerlikesMascota(mascota));
                if (mascota.getLike()==0){
                    Toast.makeText(context,"Diste Like a " +mascota.getTvNombre(),Toast.LENGTH_SHORT).show();
                    constructorMascotasdb.darLikeMascota(mascota);
                    mascota.setIvLike(R.drawable.ic_bone1);
                    mascotasViewHolder.ivLike.setImageResource(mascota.getIvLike());
                    mascotasViewHolder.tvLikes.setText(mascota.getTvLikes());
                    mascota.setTvLikes(String.valueOf(Integer.parseInt(mascota.getTvLikes())+1));
                    mascota.setLike(1);
                    mascotasViewHolder.tvLikes.setText(mascota.getTvLikes());
                }else if (mascota.getLike()==1){
                    constructorMascotasdb.disLikeMascota(mascota);
                    mascota.setIvLike(R.drawable.ic_bone);
                    Toast.makeText(context,"Ya no te gusta " +mascota.getTvNombre(),Toast.LENGTH_SHORT).show();
                    mascota.setTvLikes(String.valueOf(Integer.parseInt(mascota.getTvLikes())-1));
                    mascota.setLike(0);
                    mascotasViewHolder.tvLikes.setText(mascota.getTvLikes());
                    mascotasViewHolder.ivLike.setImageResource(mascota.getIvLike());

                }
            }
        });

    }

    @Override
    public int getItemCount() {     //Cantidad de Mascotas
        return mascotas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{//implements View.OnClickListener
        private ImageView ivFoto, ivLike, ivTLike;
        private TextView  tvNombre,tvLikes;

        public MascotasViewHolder(@NonNull View itemView) {//,ViewHolderClick listener
            super(itemView);
            ivFoto      = (ImageView) itemView.findViewById(R.id.ivFoto);
            ivLike      = (ImageView) itemView.findViewById(R.id.ivLike);
            ivTLike     = (ImageView) itemView.findViewById(R.id.ivTLike);
            tvNombre    = (TextView)  itemView.findViewById(R.id.tvNombre);
            tvLikes     = (TextView)  itemView.findViewById(R.id.tvLikes);
        }
    }
}
