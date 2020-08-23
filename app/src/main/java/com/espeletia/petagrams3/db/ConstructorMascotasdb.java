package com.espeletia.petagrams3.db;

import android.content.ContentValues;
import android.content.Context;

import com.espeletia.petagrams3.R;
import com.espeletia.petagrams3.pojo.Mascotas;

import java.util.ArrayList;

public class ConstructorMascotasdb {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotasdb(Context context) {
        this.context =context;
    }

    public ArrayList<Mascotas> obtenerDatos(){
        //Base de datos de las mascotas a mostrar en el recyclerview
        /*ArrayList<Mascotas> mascotas = new ArrayList<Mascotas>();
        mascotas.add(new Mascotas(0,"Kaiser","7",R.drawable.ic_m1,R.drawable.ic_bone,R.drawable.ic_bone1));
        mascotas.add(new Mascotas(0,"Perla","3",R.drawable.ic_m2,R.drawable.ic_bone,R.drawable.ic_bone1));
        mascotas.add(new Mascotas(0,"Gigante","1",R.drawable.ic_m3,R.drawable.ic_bone,R.drawable.ic_bone1));
        mascotas.add(new Mascotas(0,"Albo","2",R.drawable.ic_m4,R.drawable.ic_bone,R.drawable.ic_bone1));
        mascotas.add(new Mascotas(0,"Galleta","8",R.drawable.ic_m5,R.drawable.ic_bone,R.drawable.ic_bone1));
        mascotas.add(new Mascotas(0,"Max","4",R.drawable.ic_m6,R.drawable.ic_bone,R.drawable.ic_bone1));
        mascotas.add(new Mascotas(0,"Runner","5",R.drawable.ic_m7,R.drawable.ic_bone,R.drawable.ic_bone1));
        mascotas.add(new Mascotas(0,"Sasha","6",R.drawable.ic_m8,R.drawable.ic_bone,R.drawable.ic_bone1));
        mascotas.add(new Mascotas(0,"Maximus","8",R.drawable.ic_m9,R.drawable.ic_bone,R.drawable.ic_bone1));
        return mascotas;*/
        BaseDatos db =new BaseDatos(context);
        InsertarMascotas(db);
        return db.listaMascotas();

    }

    public void InsertarMascotas(BaseDatos db){
        ContentValues contentValues =new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKE,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,"Kaiser");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKES,"7");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO,R.drawable.ic_m1);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVLIKE,R.drawable.ic_bone);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVTLIKES,R.drawable.ic_bone1);
        db.insertarMascota(contentValues);

//        public static final String TABLE_PETS           ="mascotas";
//        public static final String TABLE_PETS_ID        ="id";
//        public static final String TABLE_PETS_LIKE      ="like";
//        public static final String TABLE_PETS_IVLIKE    ="im_like";
//        public static final String TABLE_PETS_NOMBRE    ="nombre";
//        public static final String TABLE_PETS_FOTO      ="foto";
//        public static final String TABLE_PETS_LIKES     ="likes";
//        public static final String TABLE_PETS_IVTLIKES  ="im_likes";

        contentValues =new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKE,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,"Perla");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKES,"3");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO,R.drawable.ic_m2);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVLIKE,R.drawable.ic_bone);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVTLIKES,R.drawable.ic_bone1);
        db.insertarMascota(contentValues);
//
        contentValues =new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKE,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,"Gigante");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKES,"1");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO,R.drawable.ic_m3);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVLIKE,R.drawable.ic_bone);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVTLIKES,R.drawable.ic_bone1);
        db.insertarMascota(contentValues);

        contentValues =new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKE,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,"Albo");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKES,"2");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO,R.drawable.ic_m4);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVLIKE,R.drawable.ic_bone);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVTLIKES,R.drawable.ic_bone1);
        db.insertarMascota(contentValues);

        contentValues =new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKE,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,"Galleta");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKES,"8");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO,R.drawable.ic_m5);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVLIKE,R.drawable.ic_bone);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVTLIKES,R.drawable.ic_bone1);
        db.insertarMascota(contentValues);

        contentValues =new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKE,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,"Max");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKES,"4");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO,R.drawable.ic_m6);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVLIKE,R.drawable.ic_bone);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVTLIKES,R.drawable.ic_bone1);
        db.insertarMascota(contentValues);

        contentValues =new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKE,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,"Runner");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKES,"5");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO,R.drawable.ic_m7);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVLIKE,R.drawable.ic_bone);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVTLIKES,R.drawable.ic_bone1);
        db.insertarMascota(contentValues);

        contentValues =new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKE,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,"Sasha");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKES,"6");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO,R.drawable.ic_m8);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVLIKE,R.drawable.ic_bone);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVTLIKES,R.drawable.ic_bone1);
        db.insertarMascota(contentValues);

        contentValues =new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKE,"0");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE,"Maximus");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKES,"8");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO,R.drawable.ic_m9);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVLIKE,R.drawable.ic_bone);
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_IVTLIKES,R.drawable.ic_bone1);
        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascotas mascota){
        int id;
        BaseDatos db = new BaseDatos(context);
        id=mascota.getId();
        db.likeMascota(id);
    }
    public void disLikeMascota(Mascotas mascota){
        int id;
        BaseDatos db = new BaseDatos(context);
        id=mascota.getId();
        db.dislikeMascota(id);
    }
}
