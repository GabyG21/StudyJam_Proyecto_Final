package com.example.gaby.adondevoy;

import android.database.Cursor;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaby.adondevoy.db.LugarDatabaseAdapter;

public class DetalleActivity extends AppCompatActivity {

    private ImageView ivImagen;
    private TextView tvNombre;
    private TextView tvContenido;


    private long id;
    private LugarDatabaseAdapter db;
    private Typeface tf_thing;
    private Typeface tf_bold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        ivImagen = (ImageView) findViewById(R.id.ivDetalleImagen);
        tvNombre = (TextView) findViewById(R.id.tvDetalleNombre);
        tvContenido = (TextView) findViewById(R.id.tvDetalleHabilidades);

        tf_thing = Typeface.createFromAsset(
                getAssets(), "fonts/roboto_thin.ttf");
        tf_bold = Typeface.createFromAsset(
                getAssets(), "fonts/roboto_black.ttf");

        tvNombre.setTypeface(tf_bold);
        tvContenido.setTypeface(tf_thing);

        db = new LugarDatabaseAdapter(this);
        db.abrir();

        id = getIntent().getLongExtra("id", 0);

        String nImagen = db.obtenerImagen(id);

        Cursor cursor = db.obtenerLugar(id);

        if (cursor.moveToFirst()) {
            String titulo = cursor.getString(1);
            String contenido = cursor.getString(2);
            tvNombre.setText(titulo);
            tvContenido.setText(contenido);
            if (ivImagen.equals(nImagen))
            ivImagen.setImageDrawable(getDrawable(Integer.parseInt(nImagen)));
    }

    }

}
