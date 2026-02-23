package com.daw.controller;

import com.daw.model.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class GestorPedidos {

    private ArrayList<Pedido> pedidos;

    public GestorPedidos() {
        pedidos = new ArrayList<>();
    }

    public void prestarLibro(Usuario usuario, Producto libro) throws LimitePrestamosExcedidoException, LibroNoDisponibleException {
        if (usuario.getLibrosPrestados().size() >= 3) {
            throw new LimitePrestamosExcedidoException("Error: " + usuario.getNombre() + " ya tiene 3 libros.");
        }

        if (libro.getEstado() != EstadoLibro.DISPONIBLE || libro.getCopias() <= 0) {
            throw new LibroNoDisponibleException("Error: El libro '" + libro.getTitulo() + "' no está disponible.");
        }

        for (Pedido p : usuario.getHistorialPrestados()) {
            if (p.getLibro().getIsbn().equals(libro.getIsbn()) && p.getFechaDevolucion() != null) {
                long diasPrestado = ChronoUnit.DAYS.between(p.getFechaPrestamo(), p.getFechaDevolucion());
                long diasDesdeDevolucion = ChronoUnit.DAYS.between(p.getFechaDevolucion(), LocalDate.now());
                
                if (diasPrestado >= 30 && diasDesdeDevolucion < 7) {
                    throw new LibroNoDisponibleException("Bloqueo: Deben pasar 7 días desde la devolución para volver a pedir este libro.");
                }
            }
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

        for (Pedido p : pedidos) {
            if (p.getLibro().equals(libro) && p.getFechaDevolucion() == null) {
                p.setFechaDevolucion(LocalDate.now());
                usuario.agregarAlHistorial(p);
                break;
            }
        }

        usuario.quitarLibro(libro);
        libro.setCopias(libro.getCopias() + 1);
        libro.setEstado(EstadoLibro.DISPONIBLE);
        System.out.println("Devolución Realizada: " + libro.getTitulo());
    }

    public void reservarLibro(Usuario usuario, Producto libro) {
        if (libro.getEstado() == EstadoLibro.DISPONIBLE) {
            System.out.println("El libro está disponible, no se puede reservar.");
            return;
        }
        libro.setEstado(EstadoLibro.RESERVADO);
        System.out.println("Reserva Realizada: " + usuario.getNombre() + " reservó " + libro.getTitulo());
    }

    public ArrayList<Usuario> quienTieneElLibro(Producto libro) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getLibro().getIsbn().equals(libro.getIsbn()) && p.getFechaDevolucion() == null) {
                usuarios.add(p.getUsuario());
            }
        }
        return usuarios;
    }

    public ArrayList<Pedido> getPedidosActivos() {
        ArrayList<Pedido> activos = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getFechaDevolucion() == null) {
                activos.add(p);
            }
        }
        return activos;
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