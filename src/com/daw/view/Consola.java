package com.daw.view;

import com.daw.model.*;
import java.util.ArrayList;

public class Consola {
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String error) {
        System.err.println("ERROR: " + error);
    }

    public void mostrarResumenBiblioteca(ArrayList<Producto> libros) {
        System.out.println("\n===== RESUMEN DE BIBLIOTECA =====");
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }
        for (Producto libro : libros) {
            System.out.println(libro);
        }
    }

    public void mostrarResumenUsuarios(ArrayList<Usuario> usuarios) {
        System.out.println("\n===== RESUMEN DE USUARIOS =====");
        for (Usuario u : usuarios) {
            System.out.println("User: " + u.getNombre() + " (ID: " + u.getId() + ") | Libros actuales: " + u.getLibrosPrestados().size());
            if (!u.getLibrosPrestados().isEmpty()) {
                for (Producto p : u.getLibrosPrestados()) {
                    System.out.println("   - " + p.getTitulo());
                }
            }
        }
    }

    public void mostrarPedidos(ArrayList<Pedido> pedidos) {
        System.out.println("\n===== PRÉSTAMOS ACTIVOS =====");
        if (pedidos.isEmpty()) {
            System.out.println("No hay préstamos activos.");
            return;
        }
        pedidos.forEach(System.out::println);
    }

    public void mostrarQuienTieneLibro(Producto libro, ArrayList<Usuario> usuarios) {
        System.out.println("\nUsuarios que tienen el libro '" + libro.getTitulo() + "':");
        if (usuarios.isEmpty()) {
            System.out.println("- Nadie tiene este libro prestado actualmente.");
        } else {
            for (Usuario u : usuarios) {
                System.out.println("- " + u.getNombre());
            }
        }
    }
}