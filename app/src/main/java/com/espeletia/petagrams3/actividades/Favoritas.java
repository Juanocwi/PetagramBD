package com.espeletia.petagrams3.actividades;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.espeletia.petagrams3.adaptadores.MascotasAdaptador;
import com.espeletia.petagrams3.db.BaseDatos;
import com.espeletia.petagrams3.fragments.IL_M_Fragment_View;
import com.espeletia.petagrams3.pojo.Mascotas;
import com.espeletia.petagrams3.R;
import com.espeletia.petagrams3.adaptadores.FavoritasAdaptador;
import com.espeletia.petagrams3.menuopciones.acerca_de;
import com.espeletia.petagrams3.menuopciones.contacto;
import com.espeletia.petagrams3.presentadores.IL_M_Fragment_Presenter;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity {
    ArrayList<Mascotas> favoritas;

    private RecyclerView listaFavoritas;
    private IL_M_Fragment_Presenter presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        androidx.appcompat.widget.Toolbar  acvf= (androidx.appcompat.widget.Toolbar) findViewById(R.id.acvf);
        setSupportActionBar(acvf);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaFavoritas = (RecyclerView) findViewById(R.id.rvFav);
//        presentador = new L_M_Fragment_Presenter(this,this);

        LinearLayoutManager llmf = new LinearLayoutManager(this);
        llmf.setOrientation(LinearLayoutManager.VERTICAL);

        listaFavoritas.setLayoutManager(llmf);
        inicializarListaFavoritas();
        inicializarAdaptador();

    }
    // menu opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.acercade:
                Intent intent = new Intent(Favoritas.this, acerca_de.class);
                startActivity(intent);
                break;
            case R.id.contacto:
                Intent intent1 = new Intent(Favoritas.this, contacto.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);

    }


    public void inicializarAdaptador(){
        FavoritasAdaptador adaptador =new FavoritasAdaptador(favoritas);
        listaFavoritas.setAdapter(adaptador);

    }

    public void inicializarListaFavoritas(){
        favoritas = new ArrayList<Mascotas>();


        favoritas.add(new Mascotas(1,"Gigante","1",R.drawable.ic_m3,R.drawable.ic_bone1,R.drawable.ic_bone1));
        favoritas.add(new Mascotas(1,"Albo","2",R.drawable.ic_m4,R.drawable.ic_bone1,R.drawable.ic_bone1));
        favoritas.add(new Mascotas(1,"Galleta","8",R.drawable.ic_m5,R.drawable.ic_bone1,R.drawable.ic_bone1));
        favoritas.add(new Mascotas(1,"Max","4",R.drawable.ic_m6,R.drawable.ic_bone1,R.drawable.ic_bone1));
        favoritas.add(new Mascotas(1,"Runner","5",R.drawable.ic_m7,R.drawable.ic_bone1,R.drawable.ic_bone1));

    }

//    @Override
//    public void GenerarLLVertical() {
//        LinearLayoutManager llmf = new LinearLayoutManager(this);
//        llmf.setOrientation(LinearLayoutManager.VERTICAL);
//        listaFavoritas.setLayoutManager(llmf);
//    }
//
//    @Override
//    public FavoritasAdaptador crearAdaptadorF(ArrayList<Mascotas> mascotas) {
//        favoritas= new ArrayList<Mascotas>();
//
////        favoritas.add(mascotas.get(0));
////        Toast.makeText(this,)
//
////        favoritas.add(new Mascotas(1,"Gigante","1",R.drawable.ic_m3,R.drawable.ic_bone1,R.drawable.ic_bone1));
////        favoritas.add(new Mascotas(1,"Albo","2",R.drawable.ic_m4,R.drawable.ic_bone1,R.drawable.ic_bone1));
////        favoritas.add(new Mascotas(1,"Galleta","8",R.drawable.ic_m5,R.drawable.ic_bone1,R.drawable.ic_bone1));
////        favoritas.add(new Mascotas(1,"Max","4",R.drawable.ic_m6,R.drawable.ic_bone1,R.drawable.ic_bone1));
////        favoritas.add(new Mascotas(1,"Runner","5",R.drawable.ic_m7,R.drawable.ic_bone1,R.drawable.ic_bone1));
//        System.out.println(mascotas.size());
//        for (int i=0;i<mascotas.size();i++) {
//            System.out.println(mascotas.get(i).getLike());
//            if (mascotas.get(i).getLike()== 1) {
//               favoritas.add(mascotas.get(i));
//               favoritas.get(i).setIvLike(R.drawable.ic_bone1);
////               favoritas.get(i).setTvLikes(String.valueOf(Integer.parseInt(favoritas.get(i).getTvLikes())+1));
////               favoritas.get(i).setLike(1);
////                mascotasViewHolder.tvLikes.setText(mascota.getTvLikes());
////                mascotasViewHolder.ivLike.setImageResource(mascota.getIvLike());
//            }
//        }
//        /*
//            if (mascotas.get(i).getLike()== 1) {
//                favoritas.add(new Mascotas(mascotas.get(i).getLike(),
//                                           mascotas.get(i).getTvNombre(),
//                                           mascotas.get(i).getTvLikes(),
//                                           mascotas.get(i).getIvFoto(),
//                                           mascotas.get(i).getIvLike(),
//                                           mascotas.get(i).getIvTLikes()
//                                           ));
//            }
//        }*/
//
//        MascotasAdaptador adaptador = new MascotasAdaptador(favoritas,this);
//        if (mascotas.getLike()==0){
//            mascota.setIvLike(R.drawable.ic_bone1);
//            mascota.setTvLikes(String.valueOf(Integer.parseInt(mascota.getTvLikes())+1));
//            mascota.setLike(1);
//            mascotasViewHolder.tvLikes.setText(mascota.getTvLikes());
//            mascotasViewHolder.ivLike.setImageResource(mascota.getIvLike());
//        }else if (mascota.getLike()==1){
//            mascota.setIvLike(R.drawable.ic_bone);
//            mascota.setTvLikes(String.valueOf(Integer.parseInt(mascota.getTvLikes())-1));
//            mascota.setLike(0);
//            mascotasViewHolder.tvLikes.setText(mascota.getTvLikes());
//            mascotasViewHolder.ivLike.setImageResource(mascota.getIvLike());
//
//        }
//
//        return adaptador;
//    }

//    @Override
//    public void initAdaptadorRV(MascotasAdaptador adaptador) {
//        listaFavoritas.setAdapter(adaptador);
//    }
}