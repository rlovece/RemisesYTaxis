package org.example.Clases;

import java.util.Objects;

public abstract class Vehiculo {
    protected transient Estados estado = Estados.LIBRE;
    protected String marca;
    protected String modelo;
    protected String tipoCombustible;
    protected String patente;


    //region Constructor
    public Vehiculo(String marca, String modelo, String tipoCombustible, String patente) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = tipoCombustible;
        this.patente = patente;
    }

    public Vehiculo (){};
    //endregion

    //region getrers y setters

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    //endregion

    //region equal y hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return patente.equals(vehiculo.patente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patente);
    }

    //endregion

    public void viajando (){
        this.estado = Estados.OCUPADO;
    }

    abstract void modificar();

}
