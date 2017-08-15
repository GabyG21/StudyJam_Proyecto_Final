package com.example.gaby.adondevoy.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by GABY on 21/5/2017.
 */

public class LugarDatabaseAdapter {
    private LugaresDatabaseHelper databaseHelper;
    private SQLiteDatabase db;

    public LugarDatabaseAdapter(Context context) {
        databaseHelper = new LugaresDatabaseHelper(context);
    }

    public void abrir() {
        db = databaseHelper.getWritableDatabase();
    }

    public void cerrar() {
        databaseHelper.close();
    }

    public long adicionarLugar(String titulo, String contenido,String fecha,String hora,String lugar,
                                String imagen) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("titulo",titulo);
        contentValues.put("contenido",contenido);
        contentValues.put("fecha",fecha);
        contentValues.put("hora", hora);
        contentValues.put("lugar",lugar);
        contentValues.put("imagen",imagen);

        return db.insert("lugar",null,contentValues);

    }

    public int actualizarLugar(long id, String titulo,String contenido,String fecha,String hora,String lugar,
                               String imagen) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo",titulo);
        contentValues.put("contenido",contenido);
        contentValues.put("fecha",fecha);
        contentValues.put("hora", hora);
        contentValues.put("lugar",lugar);
        contentValues.put("imagen",imagen);


        return db.update("lugar",contentValues,"_id=?", new String[] {id+""});
    }

    public boolean eliminarLugar(long id) {
        return db.delete("lugar","_id= "+id,null) > 0;

    }

    public Cursor obtenerLugar(long id) {

        return db.query("lugar",new String[]{ "_id", "titulo","contenido","fecha","hora","lugar", "imagen"},"_id =? ",new String[]{ id+""}, null, null,null);
    }

    public Cursor obtenerTodosLugares() {
        String ordenSalida = "fecha" + "DESC";
        return db.query("lugar",new String[]{ "_id", "titulo","contenido","fecha","hora","lugar", "imagen"},null,null, null, null,ordenSalida);
    }

    public Cursor BuscarLugar(String word){

        String bLugar = "titulo" + " LIKE '" +word + "'"+ "OR"+ "contenido" + "LIKE '" + word + "'";

        return null;
    }

    public String obtenerImagen(long id){

        return String.valueOf(db.query("lugar",new String[]{"imagen"},"_id = ?",new String[]{ "id+"},null,null,null));

    }
    private static class LugaresDatabaseHelper extends SQLiteOpenHelper {

        public LugaresDatabaseHelper(Context context) {
            super(context, "lugares.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE lugar (_id INTEGER PRIMARY KEY,titulo TEXT NOT NULL,contenido TEXT,fecha DATE,hora TEXT,lugar TEXT,imagen TEXT)");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS lugar");
            onCreate(db);
        }
    }

}