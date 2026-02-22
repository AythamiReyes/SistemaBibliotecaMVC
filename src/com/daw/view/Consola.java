package com.daw.view;

import com.daw.model.*;
import java.util.ArrayList;

public class Consola {
    public void mostrarLibros(ArrayList<Producto> libros) {
        System.out.println("\n--- LISTADO DE LIBROS ---");
        libros.forEach(System.out::println);
    }

    public void mostrarUsuario(Usuario u) {
        System.out.println("\nUsuario: " + u.getNombre() + " | Libros: " + u.getLibrosPrestados().size());
    }
}