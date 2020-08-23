package com.espeletia.petagrams3.fragments;

import com.espeletia.petagrams3.adaptadores.MascotasAdaptador;
import com.espeletia.petagrams3.pojo.Mascotas;

import java.util.ArrayList;

public interface IL_M_Fragment_View {

    public void GenerarLLVertical();

    public MascotasAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);

    public void initAdaptadorRV(MascotasAdaptador adaptador);
}
