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
        this.fechaVencimiento = fechaPrestamo.plusDays(30);
    }

    public Producto getLibro() { return libro; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate fecha) { this.fechaDevolucion = fecha; }

    @Override
    public String toString() {
        return "Préstamo: " + libro.getTitulo() + " | Usuario: " + usuario.getNombre() + 
               " | Vence: " + fechaVencimiento;
    }
}