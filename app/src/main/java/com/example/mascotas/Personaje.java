package com.example.mascotas;

public class Personaje {
    private String nombre;
    private String genero;

    public Personaje(String name, String gender) {
        this.nombre = name;
        this.genero = gender;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }
}