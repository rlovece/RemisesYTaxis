package org.example.Clases;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1234567893333333331L;

    private int id;
    private String nombre;
    private String apellido;
    private long telefono;
    private String direccion;


    //region Constructor

    public Cliente(int id, String nombre, String apellido, long telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente (){}

    //endregion

    //region Getters y Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    //region equal y hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    //endregion

    @Override
    public String toString() {
        return "\n Cliente: " + id +
                ", Nombre y Apellido: '" + nombre +
                " " + apellido +
                ", Tel: " + telefono +
                ", Direccion: " + direccion;
    }

    public void modificarCliente () {
        this.nombre = EntradaSalida.entradaString("Ingrese nombre del Cliente");
        this.apellido = EntradaSalida.entradaString("Ingrese apellido del Cliente");
        this.telefono = EntradaSalida.leerInt("Ingrese telefono del Cliente");
        this.direccion = EntradaSalida.entradaString("Ingrese dirección del Cliente");
    }
}
