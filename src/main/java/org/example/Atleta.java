package org.example;

public class Atleta {
    private int numero;
    private String nombre;
    private float tiempoDeCarrera;

    public Atleta(int numero, String nombre, float tiempoCarrera) {
        this.numero = numero;
        this.nombre = nombre;
        this.tiempoDeCarrera = tiempoCarrera;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public float getTiempoDeCarrera() {
        return tiempoDeCarrera;
    }
}
