package org.example.Clases;

import java.io.Serializable;

public class Remis extends Vehiculo implements Serializable {

    private static final long serialVersionUID = 1234567892222222221L;
    private int tarifaCuadra;

    //region Constructor

    public Remis(String marca, String modelo, String tipoCombustible, String patente, int tarifaCuadra) {
        super(marca, modelo, tipoCombustible, patente);
        this.tarifaCuadra = tarifaCuadra;
    }

    public Remis (){}

    //endregion

    //region Geters y Setters

    public int getTarifaCuadra() {
        return tarifaCuadra;
    }

    public void setTarifaCuadra(int tarifaCuadra) {
        this.tarifaCuadra = tarifaCuadra;
    }

    //endregion
}
