package com.daw.model;

import java.util.ArrayList;

public class Usuario {
    private String id;
    private String nombre;
    private ArrayList<Producto> librosPrestados;
    private ArrayList<Pedido> historialPrestados;

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<>();
        this.historialPrestados = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public ArrayList<Producto> getLibrosPrestados() { return librosPrestados; }
    public ArrayList<Pedido> getHistorialPrestados() { return historialPrestados; }

    public void agregarLibro(Producto libro) { this.librosPrestados.add(libro); }
    public void quitarLibro(Producto libro) { this.librosPrestados.remove(libro); }
}