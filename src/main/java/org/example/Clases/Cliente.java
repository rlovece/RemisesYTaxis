package org.example.Clases;

import java.io.Serializable;

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1234567893333333331L;
    private String nombre;
    private String apellido;
    private long telefono;
    private String direccion;


    //region Constructor

    public Cliente(String nombre, String apellido, long telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente (){}

    //endregion

    //region Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //endregion
}
