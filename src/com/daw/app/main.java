package com.daw.app;

import com.daw.controller.GestorLibro;
import com.daw.controller.GestorPedidos;
import com.daw.model.Genero;
import com.daw.model.Producto;
import com.daw.model.Usuario;
import com.daw.view.Consola;

public class Main {
    public static void main(String[] args) {
        GestorLibro gestorLibro = new GestorLibro();
        GestorPedidos gestorPedidos = new GestorPedidos();
        Consola consola = new Consola();

        Producto libro1 = new Producto("1", "El Quijote", "Cervantes", Genero.NOVELA, 3);
        Producto libro2 = new Producto("2", "Dune", "Herbert", Genero.CIENCIA_FICCION, 2);
        Producto libro3 = new Producto("3", "La Asistenta", "Freida McFadden", Genero.THRILLER_PSICOLOGICO, 1);

        gestorLibro.AgregarLibro(libro1);
        gestorLibro.AgregarLibro(libro2);
        gestorLibro.AgregarLibro(libro3);

        Usuario usuario1 = new Usuario("U1", "Juan Antonio");
        Usuario usuario2 = new Usuario("U2", "Aythami Reyes");
        Usuario usuario3 = new Usuario("U3", "Alejandro Acosta");

        System.out.println();
        consola.mostrarLibros(gestorLibro.getLibros());

        System.out.println();
        System.out.println("== Préstamos ==");
        gestorPedidos.prestarLibro(usuario1, libro1);
        gestorPedidos.prestarLibro(usuario2, libro2);
        gestorPedidos.prestarLibro(usuario3, libro3);

        System.out.println();
        System.out.println("== Límite de libros ==");
        gestorPedidos.prestarLibro(usuario1, libro3);

        System.out.println();
        System.out.println("== Pedidos ==");
        gestorPedidos.mostrarPedidos();

        System.out.println();
        System.out.println("== Reserva ==");
        gestorPedidos.reservarLibro(usuario2, libro1);

        System.out.println();
        System.out.println("== Devolución ==");
        gestorPedidos.devolverLibro(usuario1, libro1);

        System.out.println();
        System.out.println("== Busqueda por género ==");
        gestorLibro.buscarPorGenero(Genero.NOVELA);

        System.out.println();
        System.out.println("== Busqueda por título ==");
        gestorLibro.buscarPorTitulo("dune");

        System.out.println();
        System.out.println("== Estado Final ==");
        consola.mostrarLibros(gestorLibro.getLibros());

        System.out.println();
        consola.mostrarUsuario(usuario1);
        consola.mostrarUsuario(usuario2);
        consola.mostrarUsuario(usuario3);
    }
}