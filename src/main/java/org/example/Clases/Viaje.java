package org.example.Clases;

import javax.swing.*;
import java.io.Serializable;

public class Viaje implements Serializable{
    private static final long serialVersionUID = 1234567894444444441L;
    private int id;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private String fecha;
    private int cantKm;
    private double costo;

    //region Constructor

    public Viaje(int id, Vehiculo vehiculo, Cliente cliente, String fecha, int cantKm) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.fecha = fecha;
        this.cantKm = cantKm;
        this.costo = vehiculo.costoViaje(cantKm);
    }

    public Viaje (){}

    //endregion

    //region Getters y Setter

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    //endregion

    @Override
    public String toString() {
        return "\n\nViaje " + id +
                ", Vehiculo: '" + vehiculo.patente + '\'' +
                "\n Cliente: " + cliente.getNombre() + " " + cliente.getApellido() +
                "\n " + cantKm + "km" +
                " $" + costo ;
    }
    public void calcularCosto (){
        if (vehiculo.getClass() == Taxi.class){
            this.costo = ((Taxi) vehiculo).costoViaje(this.cantKm);
        } else {
            this.costo = ((Remis) vehiculo).costoViaje(this.cantKm);
        }

    }
    public void modificar (){
        String msj = "\n\n Sólo es posible modificar cant de km";
        JOptionPane.showMessageDialog(null, msj,"Modificar Viaje", JOptionPane.INFORMATION_MESSAGE);
        this.cantKm = EntradaSalida.leerInt("Ingrese cant km: ");
        calcularCosto();
    }
}
