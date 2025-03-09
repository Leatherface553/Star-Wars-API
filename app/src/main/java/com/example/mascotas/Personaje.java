package com.example.mascotas;

public class Personaje {
    private String nombre;
    private String genero;

    public Personaje(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }
}