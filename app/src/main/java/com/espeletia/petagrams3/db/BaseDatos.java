package com.espeletia.petagrams3.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.espeletia.petagrams3.R;
import com.espeletia.petagrams3.pojo.Mascotas;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTC = " CREATE TABLE " + ConstantesBaseDatos.TABLE_PETS+ " ( " +
                ConstantesBaseDatos.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_PETS_LIKE+ " INTEGER, " +
                ConstantesBaseDatos.TABLE_PETS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_PETS_LIKES + " TEXT, " +
                ConstantesBaseDatos.TABLE_PETS_FOTO + " INTEGER, "+
                ConstantesBaseDatos.TABLE_PETS_IVLIKE + " INTEGER, "+
                ConstantesBaseDatos.TABLE_PETS_IVTLIKES + " INTEGER "  +
                " ) ";

        String queryCrearTPERFIL = "CREATE TABLE "+ConstantesBaseDatos.TABLE_PROFILE+" ( "+
                ConstantesBaseDatos.TABLE_PROFILE_ID        +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ConstantesBaseDatos.TABLE_PROFILE_ID_PET    +" INTEGER, "+
                ConstantesBaseDatos.TABLE_PROFILE_FOTO      +" INTEGER, "+
                ConstantesBaseDatos.TABLE_PROFILE_LIKES     +" TEXT, "   +
                ConstantesBaseDatos.TABLE_PROFILE_IVTLIKES  +" INTEGER, "  +
                "FOREIGN KEY ("+ ConstantesBaseDatos.TABLE_PROFILE_ID_PET+") "+
                "REFERENCES "+ ConstantesBaseDatos.TABLE_PETS
                +" ( "+ConstantesBaseDatos.TABLE_PETS_ID+" ) "+
                " ) ";
        db.execSQL(queryCrearTC);
        db.execSQL(queryCrearTPERFIL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ConstantesBaseDatos.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXISTS " +ConstantesBaseDatos.TABLE_PROFILE);
        onCreate(db);
        
    }

    public ArrayList<Mascotas> listaMascotas(){
        ArrayList<Mascotas> mascotas =new ArrayList<>();

        String query = "SELECT * FROM "+ConstantesBaseDatos.TABLE_PETS;
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascotas mascotaActual=new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setLike(registros.getInt(1));
            mascotaActual.setTvNombre(registros.getString(2));
            mascotaActual.setTvLikes(registros.getString(3));
            mascotaActual.setIvFoto(registros.getInt(4));
            mascotaActual.setIvLike(registros.getInt(5));
            mascotaActual.setIvTLikes(registros.getInt(6));

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db =this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETS,null,contentValues);
        db.close();
    }

    public void likeMascota(int id){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("UPDATE mascotas SET like='1' WHERE id="+ id);
//        db.execSQL("UPDATE mascotas SET tvLikes=Integer.toString((Integer.valueOf(tvLikes)+1)) WHERE id="+ id);
        db.close();
    }

    public void dislikeMascota(int id){
        SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL("UPDATE mascotas SET like='0' WHERE id="+ id);
        db.close();
    }


    public int obtenerLikesMascotas (Mascotas mascota){
        int likes=0;
        String query = " SELECT COUNT (" + ConstantesBaseDatos.TABLE_PETS_LIKES +" ) "+
                " FROM "    + ConstantesBaseDatos.TABLE_PETS +
                " WHERE "   + ConstantesBaseDatos.TABLE_PETS_ID +
                "="         + mascota.getId();
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }
}
