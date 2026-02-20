package com.daw.app;

import com.daw.controller.GestorLibro;
import com.daw.controller.GestorPedidos;
import com.daw.controller.Categoria;
import com.daw.controller.Producto;
import com.daw.controller.Usuario;
import com.daw.controller.Consola;
import com.daw.controller.Pedido;

public class main {
    public static void main(String[]args){
        GestorLibro gestorLibro = new GestorLibro();
        GestorPedidos gestorPedidos = new GestorPedidos();
        Consola consola = new Consola();

        //Libros

        Producto libro1 = new Producto ("1", "El Quijote", "Cervantes", Genero.NOVELA, 3);
        Producto libro2 = new Producto ("2", "Dune", "Herbert", Genero.CIENCIA_FICCION, 2);
        Producto libro3 = new Producto ("3", "La Asistenta", "Freida McFadden", Genero.THRILLER_PSISCOLÓGICO, 1);

        gestorLibro.AgregarLibro(libro1);
        gestorLibro.AgregarLibro(libro2);
        gestorLibro.AgregarLibro(libro3);

        //Usuarios

        Usuario usuario1 = new Usuario("U1", "Juan Antonio");
        Usuario usuario2 = new Usuario("U2", "Aythami Reyes");
        Usuario usuario3 = new Usuario("U3", "Alejandro Acosta");

        // Estado Inicial.

        System.out.println();
        consola.mostrarLibros(gestorLibro.getLibros());

        // Préstamos 

        System.out.println();
        System.out.println("== Préstamos ==");
        gestorPedidos.prestarLibro(usuario1, libro1);
        gestorPedidos.prestarLibro(usuario2, libro2);
        gestorPedidos.prestarLibro(usuario3, libro3);

        // Probar límite de 3 libros.

        System.out.println();
        System.out.println("== Límite de libros ==");
        gestorPedidos.prestarLibro(usuario1, libro3);

        // Ver pedidos.

        System.out.println();
        System.out.println("== Pedidos ==");
        gestorPedidos.mostrarPedidos();

        // Reserva
        System.out.println();
        System.out.println("== Reserva ==");
        gestorPedidos.reservarLibro(usuario2, libro1);

        // Devolución
        System.out.println();
        System.out.println("== Devolución ==");
        gestorPedidos.reservarLibro(usuario1, libro1);

        // Búsqueda por genero y por titulo.

        System.out.println();
        System.out.println("== Busqueda por género ==");
        gestorLibro.buscarPorGenero(Genero.NOVELA);

        System.out.println();
        System.out.println("== Busqueda por título ==");
        gestorLibro.buscarPorTitulo("dune");

        //Estado final.

        System.out.println();
        System.out.println("== Estado Final ==");
        consola.mostrarLibros(gestorLibro.getLibros());

        System.out.println();
        consola.mostrarUsuario(usuario1);
        consola.mostrarUsuario(usuario2);
        consola.mostrarUsuario(usuario3);
    }
}