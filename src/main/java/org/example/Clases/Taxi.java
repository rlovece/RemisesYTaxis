package org.example.Clases;

import java.io.Serializable;

public class Taxi extends Vehiculo implements Serializable {

    private static final long serialVersionUID = 1234567891111111111L;
    private transient float km =0;

    private int bajadaBandera;

    private int precioKilometro;

    //region Constructores
    public Taxi(String marca, String modelo, String tipoCombustible, String patente, int bajadaBandera, int precioKilometro) {
        super(marca, modelo, tipoCombustible, patente);
        this.bajadaBandera = bajadaBandera;
        this.precioKilometro = precioKilometro;
    }

    public Taxi (){}
    //endregion

    //region getters y setters

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public int getBajadaBandera() {
        return bajadaBandera;
    }

    public void setBajadaBandera(int bajadaBandera) {
        this.bajadaBandera = bajadaBandera;
    }

    public int getPrecioKilometro() {
        return precioKilometro;
    }

    public void setPrecioKilometro(int precioKilometro) {
        this.precioKilometro = precioKilometro;
    }

    //endregion

}
