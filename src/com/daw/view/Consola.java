package com.daw.view;

import com.daw.model.Producto;
import com.daw.model.Usuario;
import java.util.ArrayList;

public class Consola {
    public void mostrarLibros(ArrayList<Producto> libros) {
        System.out.println("\n--- LISTADO DE LIBROS ---");
        for (Producto l : libros) System.out.println(l);
    }

    public void mostrarUsuario(Usuario u) {
        System.out.println("\n--- ESTADO DEL USUARIO ---");
        System.out.println(u);
        System.out.println("Libros actuales: " + u.getLibrosPrestados());
    }
}