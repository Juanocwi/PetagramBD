package com.espeletia.petagrams3.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.espeletia.petagrams3.R;
import com.espeletia.petagrams3.adaptadores.MascotasAdaptador;
import com.espeletia.petagrams3.adaptadores.PerfilAdaptador;
import com.espeletia.petagrams3.pojo.Mascotas;

import java.util.ArrayList;

public class Perfil_Fragment extends Fragment {

    private RecyclerView fotosPerfil;
    public ArrayList<Mascotas> fotos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil,container,false);
        fotosPerfil= (RecyclerView) v.findViewById(R.id.rvPerfil);
        GridLayoutManager llm1 = new GridLayoutManager(getActivity(),2);
        llm1.setOrientation(GridLayoutManager.VERTICAL);
        fotosPerfil.setLayoutManager(llm1);
        inicializarListaFotos();
        inicializaAdaptador();
        return v;
    }
    public void inicializaAdaptador(){
        PerfilAdaptador adaptador = new PerfilAdaptador(fotos);
        fotosPerfil.setAdapter(adaptador);
    }

    public void inicializarListaFotos(){
        fotos = new ArrayList<Mascotas>();
        fotos.add(new Mascotas(0,"","7",R.drawable.ic_1g,R.drawable.ic_bone,R.drawable.ic_bone1));
        fotos.add(new Mascotas(0,"","3",R.drawable.ic_2g,R.drawable.ic_bone,R.drawable.ic_bone1));
        fotos.add(new Mascotas(0,"","1",R.drawable.ic_3g,R.drawable.ic_bone,R.drawable.ic_bone1));
        fotos.add(new Mascotas(0,"","2",R.drawable.ic_4g,R.drawable.ic_bone,R.drawable.ic_bone1));
        fotos.add(new Mascotas(0,"","8",R.drawable.ic_5g,R.drawable.ic_bone,R.drawable.ic_bone1));
        fotos.add(new Mascotas(0,"","4",R.drawable.ic_6g,R.drawable.ic_bone,R.drawable.ic_bone1));
        fotos.add(new Mascotas(0,"","7",R.drawable.ic_3g,R.drawable.ic_bone,R.drawable.ic_bone1));
        fotos.add(new Mascotas(0,"","3",R.drawable.ic_5g,R.drawable.ic_bone,R.drawable.ic_bone1));
        fotos.add(new Mascotas(0,"","1",R.drawable.ic_2g,R.drawable.ic_bone,R.drawable.ic_bone1));
        fotos.add(new Mascotas(0,"","2",R.drawable.ic_6g,R.drawable.ic_bone,R.drawable.ic_bone1));
        fotos.add(new Mascotas(0,"","8",R.drawable.ic_1g,R.drawable.ic_bone,R.drawable.ic_bone1));
        fotos.add(new Mascotas(0,"","4",R.drawable.ic_4g,R.drawable.ic_bone,R.drawable.ic_bone1));
    }
}