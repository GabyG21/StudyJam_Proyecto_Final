package com.example.gaby.adondevoy;

import java.io.Serializable;

/**
 * Created by GABY on 21/5/2017.
 */

public class Lugar implements Serializable {
    private String Titulo;
    private String Contenido;
    private int imagen;

    public Lugar() {
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getContenido() {
        return Contenido;
    }

    public int getImagen() {
        return imagen;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public void setContenido(String contenido) {
        Contenido = contenido;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
