package org.example.ClasesGestion;
import org.example.Clases.*;
import org.example.Repositorio.*;

import javax.swing.*;
import java.util.ArrayList;

public class ClienteGestion {

    ClienteRepo clientes = new ClienteRepo();
    TaxiRepo taxis = new TaxiRepo();
    RemisRepo remises = new RemisRepo();
    ViajesRepo viajes = new ViajesRepo();

    private Cliente cliente = new Cliente();
    private Viaje viaje = new Viaje();

    //region Getters y Setter
    public Cliente getCliente() {
        return cliente;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    //endregion

    public void menuCliente(){
        String menu = "\n     Bienvenido" +
                "\n\n Elija la opcion: " +
                "\n 1. Loguearse" +
                "\n 2. Registrarse";
        int opcion = EntradaSalida.leerInt(menu);

        switch (opcion){

            case 1:
                login();
                break;
            case 2:
                registroCliente();
                clientes.agregar(this.cliente);
                break;
        }
        menu2();
    }


    public void login (){
        try {
            int dni = EntradaSalida.leerInt("Ingrese su DNI");
            this.cliente = this.clientes.buscar(String.valueOf(dni));
        } catch (InexistenteException e) {
            String error = "El DNI ingresado no se encuentra en la base. Verifique o registrese.";
            JOptionPane.showConfirmDialog(null, error, "Cliente inexistente", JOptionPane.ERROR_MESSAGE);
            menuCliente();
        }
    }

    public void registroCliente (){
        try {
            int dni = EntradaSalida.leerInt("Ingrese su DNI");
            this.cliente.setId(dni);
            this.cliente = this.clientes.buscar(String.valueOf(dni));
            String error = "Usuario ya existente!";
            JOptionPane.showConfirmDialog(null, error, "Cliente existente", JOptionPane.ERROR_MESSAGE);
            menuCliente();
        } catch (InexistenteException e) {
            this.cliente.setNombre(EntradaSalida.entradaString("Ingrese su nombre"));
            this.cliente.setApellido(EntradaSalida.entradaString("Ingrese su apellido"));
            this.cliente.setDireccion(EntradaSalida.entradaString("Ingrese su dirección"));
            this.cliente.setTelefono(EntradaSalida.leerInt("Ingrese su telefono"));
        }
    }

    public void menu2(){
        String menu = "\n     Gracias por elegirnos" +
                "\n\n Elija la opcion: " +
                "\n 1. Pedir Viaje" +
                "\n 2. En Viaje" +
                "\n 3. Finalizar viaje";
        int opcion = EntradaSalida.leerInt(menu);

        switch (opcion){

            case 1:
                pedirViaje();
                break;

            case 2:
                finalizarViaje();
                break;
        }
        menu2();
    }

    public void pedirViaje (){
        this.viaje.setCliente(this.cliente);
        this.viaje.setFecha(EntradaSalida.entradaString("Que día es hoy?"));
        this.viaje.setCantKm(EntradaSalida.leerInt("Qué distancia desea recorrer?"));
        int opcion = EntradaSalida.leerInt("Desea un taxi o un remis? 1. taxi, 2.remis");

        switch (opcion){
            case 1:
                for (Taxi taxi: taxis.listar()) {
                    if (taxi.getEstado().equals(Estados.LIBRE)){
                        this.viaje.setVehiculo(taxi);
                        taxi.setEstado(Estados.OCUPADO);
                        break;
                    }
                }
                viaje.setCosto(viaje.getCantKm());
                break;

            case 2:
                for (Remis remis: remises.listar()) {
                    if (remis.getEstado().equals(Estados.LIBRE)){
                        this.viaje.setVehiculo(remis);
                        remis.setEstado(Estados.OCUPADO);
                        break;
                    }
                }
                viaje.setCosto(viaje.getCantKm());
                break;
        }
        viajes.agregar(this.viaje);
    }

    public void finalizarViaje(){
        this.viaje.getVehiculo().setEstado(Estados.LIBRE);
        JOptionPane.showConfirmDialog(null, this.viaje.toString(), "Hasta la prox", JOptionPane.INFORMATION_MESSAGE);
    }



}
