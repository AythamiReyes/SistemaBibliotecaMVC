package com.daw.controller;

import com.daw.model.EstadoLibro;
import com.daw.model.Pedido;
import com.daw.model.Producto;
import com.daw.model.Usuario;
import java.util.ArrayList;

public class GestorPedidos {

    private ArrayList<Pedido> pedidos;

    public GestorPedidos() {
        pedidos = new ArrayList<>();
    }

    public void prestarLibro(Usuario usuario, Producto libro) {
        if (usuario.getLibrosPrestados().size() >= 3) {
            System.out.println("Error: " + usuario.getNombre() + " ya tiene 3 libros.");
            return;
        }

        if (libro.getEstado() != EstadoLibro.DISPONIBLE) {
            System.out.println("Error: El libro no está disponible.");
            return;
        }

        libro.setCopias(libro.getCopias() - 1);
        if (libro.getCopias() == 0) {
            libro.setEstado(EstadoLibro.PRESTADO);
        }
        usuario.agregarLibro(libro);
        pedidos.add(new Pedido(usuario, libro));
        System.out.println("Préstamo Realizado: " + usuario.getNombre() + " - " + libro.getTitulo());
    }

    public void devolverLibro(Usuario usuario, Producto libro) {
        if (!usuario.getLibrosPrestados().contains(libro)) {
            System.out.println("El usuario no tiene ese libro prestado.");
            return;
        }
        usuario.quitarLibro(libro);
        libro.setCopias(libro.getCopias() + 1);
        libro.setEstado(EstadoLibro.DISPONIBLE);
        System.out.println("Devolución Realizada: " + libro.getTitulo());
    }

    public void reservarLibro(Usuario usuario, Producto libro) {
        if (libro.getEstado() == EstadoLibro.DISPONIBLE) {
            System.out.println("El Estado del Libro está Disponible, no se puede reservar.");
            return;
        }

        if (libro.getEstado() == EstadoLibro.RESERVADO) {
            System.out.println("El Estado del Libro ya está Reservado.");
            return;
        }

        libro.setEstado(EstadoLibro.RESERVADO);
        System.out.println("Reserva Realizada: " + usuario.getNombre() + " reservó " + libro.getTitulo());
    }

    public void mostrarPedidos() {
        System.out.println("===== Pedidos =====");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}