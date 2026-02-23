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
        if (usuario == null || libro == null) throw new IllegalArgumentException("Usuario o libro no válidos.");

        if (usuario.getLibrosPrestados().size() >= 3) {
            throw new LimitePrestamosExcedidoException("El usuario " + usuario.getNombre() + " ya tiene 3 libros prestados.");
        }

        if (libro.getEstado() != EstadoLibro.DISPONIBLE || libro.getCopiasDisponibles() == 0) {
            throw new LibroNoDisponibleException("El libro '" + libro.getTitulo() + "' no está disponible actualmente.");
        }

        for (Pedido p : usuario.getHistorialPrestados()) {
            if (p.getLibro().getIsbn().equals(libro.getIsbn()) && !p.estaActivo()) {
                long diasPrestado = ChronoUnit.DAYS.between(p.getFechaPrestamo(), p.getFechaDevolucion());
                long diasDesdeDevolucion = ChronoUnit.DAYS.between(p.getFechaDevolucion(), LocalDate.now());
                
                if (diasPrestado >= 30 && diasDesdeDevolucion < 7) {
                    throw new LibroNoDisponibleException("Deben pasar 7 días desde la última devolución para volver a pedir este libro.");
                }
            }
        }

        libro.setCopiasDisponibles(libro.getCopiasDisponibles() - 1);
        if (libro.getCopiasDisponibles() == 0) {
            libro.setEstado(EstadoLibro.PRESTADO);
        }
        
        Pedido nuevoPedido = new Pedido(usuario, libro);
        usuario.agregarLibro(libro);
        pedidos.add(nuevoPedido);
    }

    public void devolverLibro(Usuario usuario, Producto libro) {
        if (!usuario.getLibrosPrestados().contains(libro)) {
            throw new IllegalArgumentException("El usuario no tiene este libro prestado.");
        }

        Pedido pedidoActivo = null;
        for (Pedido p : pedidos) {
            if (p.getUsuario().getId().equals(usuario.getId()) && p.getLibro().getIsbn().equals(libro.getIsbn()) && p.estaActivo()) {
                pedidoActivo = p;
                break;
            }
        }

        if (pedidoActivo != null) {
            pedidoActivo.setFechaDevolucion(LocalDate.now());
            usuario.agregarAlHistorial(pedidoActivo);
        }

        usuario.quitarLibro(libro);
        libro.setCopiasDisponibles(libro.getCopiasDisponibles() + 1);
        if (libro.getCopiasDisponibles() > 0 && libro.getEstado() != EstadoLibro.RESERVADO) {
            libro.setEstado(EstadoLibro.DISPONIBLE);
        }
    }

    public void reservarLibro(Usuario usuario, Producto libro) {
        if (libro.getEstado() == EstadoLibro.DISPONIBLE) {
            throw new IllegalArgumentException("El libro está Disponible, puedes pedirlo prestado directamente.");
        }
        libro.setEstado(EstadoLibro.RESERVADO);
    }

    public ArrayList<Usuario> quienTieneElLibro(Producto libro) {
        ArrayList<Usuario> usuariosConLibro = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getLibro().getIsbn().equals(libro.getIsbn()) && p.estaActivo()) {
                usuariosConLibro.add(p.getUsuario());
            }
        }
        return usuariosConLibro;
    }

    public ArrayList<Pedido> getPedidosActivos() {
        ArrayList<Pedido> activos = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.estaActivo()) activos.add(p);
        }
        return activos;
    }
}