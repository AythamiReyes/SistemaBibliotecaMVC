package com.daw.controller;

import com.daw.model.Genero;
import com.daw.model.Producto;
import java.util.ArrayList;

public class GestorLibro {
    private ArrayList<Producto> libros;

    public GestorLibro() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Producto libro) {
        if (libro == null) throw new IllegalArgumentException("El libro no puede ser nulo.");
        libros.add(libro);
    }

    public Producto buscarPorIsbn(String isbn) {
        for (Producto libro : libros) {
            if (libro.getIsbn().equals(isbn)) return libro;
        }
        return null;
    }

    public ArrayList<Producto> buscarPorTitulo(String titulo) {
        ArrayList<Producto> resultados = new ArrayList<>();
        for (Producto libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public ArrayList<Producto> buscarPorGenero(Genero genero) {
        ArrayList<Producto> resultados = new ArrayList<>();
        for (Producto libro : libros) {
            if (libro.getGenero() == genero) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public ArrayList<Producto> getLibros() { 
        return libros; 
    }
}