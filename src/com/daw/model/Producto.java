package com.daw.model;

public class Producto {
    private String isbn;
    private String titulo;
    private String autor;
    private int anoPublicacion;
    private String editorial;
    private Genero genero;
    private int copiasTotales;
    private int copiasDisponibles;
    private EstadoLibro estado;

    public Producto(String isbn, String titulo, String autor, int anioPublicacion, String editorial, Genero genero, int copiasTotales) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.editorial = editorial;
        this.genero = genero;
        this.copiasTotales = copiasTotales;
        this.copiasDisponibles = copiasTotales;
        this.estado = EstadoLibro.DISPONIBLE;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public Genero getGenero() { return genero; }
    public EstadoLibro getEstado() { return estado; }
    public void setEstado(EstadoLibro estado) { this.estado = estado; }
    public int getCopiasDisponibles() { return copiasDisponibles; }
    public void setCopiasDisponibles(int copias) { this.copiasDisponibles = copias; }
    public int getCopiasTotales() { return copiasTotales; }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%d, %s) [%s] | Disp: %d/%d | Estado: %s", 
            isbn, titulo, autor, anoPublicacion, editorial, genero, copiasDisponibles, copiasTotales, estado);
    }
}