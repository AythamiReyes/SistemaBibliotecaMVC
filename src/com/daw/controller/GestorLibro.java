package com.daw.controller;

import com.daw.model.Genero;
import com.daw.model.Producto;
import java.util.ArrayList;

public class GestorLibro {

    private ArrayList<Producto> libros;

    public GestorLibro() {
        libros = new ArrayList<>();
    }

    public void AgregarLibro(Producto libro) {
        libros.add(libro);
        System.out.println("Libro añadido: " + libro.getTitulo());
    }

    public Producto buscarPorIsbn(String isbn) {
        for (Producto libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public void buscarPorTitulo(String titulo) {
        for (Producto libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                System.out.println(libro);
            }
        }
    }

    public void buscarPorGenero(Genero genero) {
        for (Producto libro : libros) {
            if (libro.getGenero() == genero) {
                System.out.println(libro);
            }
        }
    }

    public void mostrarLibros() {
        System.out.println("=== Los Libros ===");
        for (Producto libro : libros) {
            System.out.println(libro);
        }
    }

    public ArrayList<Producto> getLibros() {
        return libros;
    }
}