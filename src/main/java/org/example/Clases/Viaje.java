package org.example.Clases;

import java.io.Serializable;

public class Viaje implements Serializable{

    private static final long serialVersionUID = 1234567894444444441L;
    private int id;
    private String patente;
    private Cliente cliente;
    private int cantKm;
    private int costo;

    //region Constructor

    public Viaje(int id, String patente, Cliente cliente, int cantKm, int costo) {
        this.id = id;
        this.patente = patente;
        this.cliente = cliente;
        this.cantKm = cantKm;
        this.costo = costo;
    }

    //endregion

    //region Getters y Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCantKm() {
        return cantKm;
    }

    public void setCantKm(int cantKm) {
        this.cantKm = cantKm;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    //endregion


}
