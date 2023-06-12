package org.example.Repositorio;

public class InexistenteException extends Exception {
    public InexistenteException(String mensaje) {
        super(mensaje);
    }
}