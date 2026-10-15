package com.example.villanosdb.clases;

public class Villano {
    private int imagen, poder;
    private String nombre, raza, saga, descripcion, derrotadoPor, color, ki;
    private boolean derrotado;

    public Villano(int imagen, String nombre, String raza, String saga,
                   boolean derrotado, String derrotadoPor,
                   String ki, int poder,
                   String descripcion, String color) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.raza = raza;
        this.saga = saga;
        this.derrotado = derrotado;
        this.derrotadoPor = derrotadoPor;
        this.ki = ki;
        this.poder = poder;
        this.descripcion = descripcion;
        this.color = color;
    }

    public int getImagen() { return imagen; }
    public String getNombre() { return nombre; }
    public String getRaza() { return raza; }
    public String getSaga() { return saga; }
    public boolean isDerrotado() { return derrotado; }
    public String getDerrotadoPor() { return derrotadoPor; }
    public String getKi() { return ki; }
    public int getPoder() { return poder; }
    public String getDescripcion() { return descripcion; }
    public String getColor() { return color; }
}