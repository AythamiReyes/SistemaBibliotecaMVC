package com.daw.controller;

public class LibroNoDisponibleException extends Exception {
    public LibroNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}