package com.espeletia.petagrams3.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.espeletia.petagrams3.R;
import com.espeletia.petagrams3.adaptadores.MascotasAdaptador;
import com.espeletia.petagrams3.pojo.Mascotas;
import com.espeletia.petagrams3.presentadores.IL_M_Fragment_Presenter;
import com.espeletia.petagrams3.presentadores.L_M_Fragment_Presenter;

import java.util.ArrayList;

public class L_M_Fragment extends Fragment implements IL_M_Fragment_View{
    private RecyclerView listaMascotas;
    private ArrayList<Mascotas> mascotas;
    private IL_M_Fragment_Presenter presentador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_l_m,container,false);
        //introducir el linear RecyclerView con las mascotas
        listaMascotas=(RecyclerView) v.findViewById(R.id.rvPantalla);
        presentador = new L_M_Fragment_Presenter(this,getContext());
        return v;
    }



    @Override
    public void GenerarLLVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotasAdaptador crearAdaptador(ArrayList<Mascotas> mascotas) {
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void initAdaptadorRV(MascotasAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
