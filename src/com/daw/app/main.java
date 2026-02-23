package com.daw.app;

import com.daw.controller.*;
import com.daw.model.*;
import com.daw.view.Consola;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        GestorLibro gestorLibro = new GestorLibro();
        GestorPedidos gestorPedidos = new GestorPedidos();
        Consola consola = new Consola();

        Producto libro1 = new Producto("1", "El Quijote", "Cervantes", 1605, "Alfaguara", Genero.NOVELA, 3);
        Producto libro2 = new Producto("2", "Dune", "Herbert", 1965, "Chilton", Genero.CIENCIA_FICCION, 2);
        Producto libro3 = new Producto("3", "La Asistenta", "Freida McFadden", 2022, "Suma", Genero.THRILLER_PSICOLOGICO, 1);

        gestorLibro.agregarLibro(libro1);
        gestorLibro.agregarLibro(libro2);
        gestorLibro.agregarLibro(libro3);

        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario u1 = new Usuario("U1", "Juan Antonio");
        Usuario u2 = new Usuario("U2", "Aythami Reyes");
        Usuario u3 = new Usuario("U3", "Alejandro Acosta");
        usuarios.add(u1); usuarios.add(u2); usuarios.add(u3);

        consola.mostrarResumenBiblioteca(gestorLibro.getLibros());

        consola.mostrarMensaje("\n== Ejecutando Préstamos ==");
        try {
            gestorPedidos.prestarLibro(u1, libro1);
            gestorPedidos.prestarLibro(u2, libro2);
            gestorPedidos.prestarLibro(u3, libro3);
            consola.mostrarMensaje("Préstamos iniciales correctos.");
        } catch (Exception e) {
            consola.mostrarError(e.getMessage());
        }

        try {
            consola.mostrarMensaje("\n== Intentando pedir libro agotado ==");
            gestorPedidos.prestarLibro(u1, libro3);
        } catch (LibroNoDisponibleException | LimitePrestamosExcedidoException e) {
            consola.mostrarError(e.getMessage());
        }

        try {
            consola.mostrarMensaje("\n== Forzando Límite de Libros ==");
            gestorPedidos.prestarLibro(u1, libro2);
            gestorPedidos.prestarLibro(u1, gestorLibro.getLibros().get(0));
            gestorPedidos.prestarLibro(u1, gestorLibro.getLibros().get(0));
        } catch (Exception e) {
            consola.mostrarError(e.getMessage());
        }

        ArrayList<Usuario> tienenQuijote = gestorPedidos.quienTieneElLibro(libro1);
        consola.mostrarQuienTieneLibro(libro1, tienenQuijote);

        consola.mostrarMensaje("\n== Ejecutando Devoluciones ==");
        gestorPedidos.devolverLibro(u1, libro1);
        consola.mostrarMensaje("El Quijote devuelto por Juan Antonio.");

        consola.mostrarPedidos(gestorPedidos.getPedidosActivos());
        consola.mostrarResumenUsuarios(usuarios);
        consola.mostrarResumenBiblioteca(gestorLibro.getLibros());
    }
}