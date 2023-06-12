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
    @Override
    public void modificar() {
        this.tarifaCuadra = EntradaSalida.leerInt("El único atributo a modificar es tarifa por cuadra" +
                "\n Si desea hacer otro cambio, deberá elimiar el remis, y volver a cargarlo." +
                "\n Ingrese tarifa por cuadra: ");
    }

    @Override
    double costoViaje(double km) {
        return (this.tarifaCuadra*0.1*km);
    }

    @Override
    public String toString() {
        return "\nRemis: " +patente +
                ", Estado: " + estado +
                ", TarifaCuadra: " + tarifaCuadra +
                ", Marca:'" + marca +
                ", Modelo:'" + modelo +
                ", Combustible: " + tipoCombustible;
    }
}
