package com.espeletia.petagrams3.actividades;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;

import com.espeletia.petagrams3.adaptadores.PageAdapter;
import com.espeletia.petagrams3.fragments.L_M_Fragment;
import com.espeletia.petagrams3.fragments.Perfil_Fragment;
import com.espeletia.petagrams3.R;
import com.espeletia.petagrams3.menuopciones.acerca_de;
import com.espeletia.petagrams3.menuopciones.contacto;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageButton bottonF;
    private Toolbar tool;
    private TabLayout tablay;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //activar el actionbar
        androidx.appcompat.widget.Toolbar  acv= (androidx.appcompat.widget.Toolbar) findViewById(R.id.acv);
        setSupportActionBar(acv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        //Ir a favoritas al hacer clic en el icono del perro
        findViewById(R.id.bottonF).setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Favoritas.class);
                startActivity(intent);
            }
        });
//        tool=(androidx.appcompat.widget.Toolbar) findViewById(R.id.tool);
        tablay=(TabLayout) findViewById(R.id.tablay);
        viewPager=(ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if(acv!=null){
            setSupportActionBar(acv);
        }

        /*

        */

        //activar FAB para entrar en la camara cuando se haga clic
        findViewById(R.id.floatingActionButton).setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(intent);
            }
        });


    }
    // creacion de menu opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones,menu);
        return true;
    }
    //definicion de las opciones del menu de opciones y salto a los layouts
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.acercade:
                Intent intent = new Intent(MainActivity.this, acerca_de.class);
                startActivity(intent);
                break;
            case R.id.contacto:
                Intent intent1 = new Intent(MainActivity.this, contacto.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //Definicion de las opciones del ViewPager con los Fragments
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new L_M_Fragment());
        fragments.add(new Perfil_Fragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tablay.setupWithViewPager(viewPager);
        //definicion Iconos de las paginas de la app
        tablay.getTabAt(0).setIcon(R.drawable.ic_play1);
        tablay.getTabAt(1).setIcon(R.drawable.ic_play2);
    }

    //creacion del adaptador con la lista de mascotas

}