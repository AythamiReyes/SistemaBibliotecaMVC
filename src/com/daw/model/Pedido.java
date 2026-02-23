package com.daw.model;

import java.time.LocalDate;

public class Pedido {
    private Usuario usuario;
    private Producto libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaVencimiento;
    private LocalDate fechaDevolucion;

    public Pedido(Usuario usuario, Producto libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaVencimiento = fechaPrestamo.plusDays(30); // Límite de 30 días
        this.fechaDevolucion = null;
    }

    public Usuario getUsuario() { return usuario; }
    public Producto getLibro() { return libro; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate fecha) { this.fechaDevolucion = fecha; }

    public boolean estaActivo() { return fechaDevolucion == null; }

    @Override
    public String toString() {
        String estado = estaActivo() ? "ACTIVO (Vence: " + fechaVencimiento + ")" : "DEVUELTO (" + fechaDevolucion + ")";
        return "Préstamo: " + libro.getTitulo() + " | Usuario: " + usuario.getNombre() + " | Estado: " + estado;
    }
}