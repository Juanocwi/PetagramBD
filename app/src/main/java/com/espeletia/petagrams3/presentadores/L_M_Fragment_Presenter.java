package com.espeletia.petagrams3.presentadores;


import android.content.Context;

import com.espeletia.petagrams3.db.ConstructorMascotasdb;
import com.espeletia.petagrams3.fragments.IL_M_Fragment_View;
import com.espeletia.petagrams3.pojo.Mascotas;

import java.util.ArrayList;

public class L_M_Fragment_Presenter implements IL_M_Fragment_Presenter {
    private IL_M_Fragment_View il_m_fragment_view;
    private Context context;
    private ConstructorMascotasdb constructorMascotasdb;
    private ArrayList<Mascotas> mascotas;

    public L_M_Fragment_Presenter(IL_M_Fragment_View il_m_fragment_view, Context context) {
        this.il_m_fragment_view=il_m_fragment_view;
        this.context=context;
        obtenerMascotasBD();

    }

    @Override
    public void obtenerMascotasBD() {
        constructorMascotasdb = new ConstructorMascotasdb(context);
        mascotas =constructorMascotasdb.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        il_m_fragment_view.initAdaptadorRV(il_m_fragment_view.crearAdaptador(mascotas));
        il_m_fragment_view.GenerarLLVertical();
    }
}
