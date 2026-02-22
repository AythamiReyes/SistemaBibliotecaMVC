package com.daw.view;

import com.daw.model.Producto;
import com.daw.model.Usuario;
import java.util.ArrayList;

public class Consola {
    public void mostrarLibros(ArrayList<Producto> libros) {
        System.out.println("\n--- CATÁLOGO DE LIBROS ---");
        for (Producto libro : libros) {
            System.out.println(libro);
        }
    }

    public void mostrarUsuario(Usuario usuario) {
        System.out.println("\nUSUARIO: " + usuario.getNombre());
        System.out.println("Libros en posesión: " + usuario.getLibrosPrestados().size());
    }

    public void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}