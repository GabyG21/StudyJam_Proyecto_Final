package com.example.gaby.adondevoy;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gaby.adondevoy.R;
import com.example.gaby.adondevoy.db.LugarDatabaseAdapter;

import java.util.Random;


public class Inicio extends Fragment {

    private EditText etBuscar;
    private Button btBuscar;
    private TextView tvNombre;
    private TextView tvContenido;
    private int id;
    private LugarDatabaseAdapter db;
    private Typeface tf_thing;
    private Typeface tf_bold;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_inicio, container, false);

        etBuscar = (EditText) v.findViewById(R.id.search_view);
        tvNombre = (TextView) v.findViewById(R.id.tvDetalleNombre);
        tvContenido = (TextView) v.findViewById(R.id.tvDetalleHabilidades);
        tvNombre.setTypeface(tf_bold);
        tvContenido.setTypeface(tf_thing);


        db = new LugarDatabaseAdapter(getActivity());
        db.abrir();

        id = (int)Math.random()*10;
        Cursor cursor = db.obtenerLugar(id);

        if (cursor.moveToFirst()) {
            String titulo = cursor.getString(1);
            String contenido = cursor.getString(2);
            tvNombre.setText(titulo);
            tvContenido.setText(contenido);
        }
        return v;
    }
}
