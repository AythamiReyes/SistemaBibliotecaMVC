package com.daw.model;

public class Producto {
    private String isbn;
    private String titulo;
    private String autor;
    private Genero genero;
    private int copiasTotales;
    private int copiasDisponibles;
    private EstadoLibro estado;

    public Producto(String isbn, String titulo, String autor, Genero genero, int copiasTotales) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.copiasTotales = copiasTotales;
        this.copiasDisponibles = copiasTotales;
        this.estado = EstadoLibro.DISPONIBLE;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public Genero getGenero() { return genero; }
    public EstadoLibro getEstado() { return estado; }
    public void setEstado(EstadoLibro estado) { this.estado = estado; }
    public int getCopias() { return copiasDisponibles; }
    public void setCopias(int copias) { this.copiasDisponibles = copias; }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%s) | Disp: %d/%d | Estado: %s", 
            isbn, titulo, autor, genero, copiasDisponibles, copiasTotales, estado);
    }
}