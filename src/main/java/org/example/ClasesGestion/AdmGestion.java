package org.example.ClasesGestion;

import org.example.Clases.Cliente;
import org.example.Clases.EntradaSalida;
import org.example.Clases.Estados;
import org.example.Clases.Viaje;
import org.example.Repositorio.*;

import javax.swing.*;
import java.util.ArrayList;

public class AdmGestion {

    ClienteRepo repoClietes = new ClienteRepo();
    TaxiRepo repoTaxis = new TaxiRepo();
    RemisRepo repoRemises = new RemisRepo();
    ViajesRepo repoViaje = new ViajesRepo();

    public void menuAdm1 () throws ERRORContraseña{
        String clave = "\n     Bienvenido" +
                "\n Ingrese la clave de admin: \n\n";

        verificarContraseña(EntradaSalida.leerInt(clave));
        String menu =
                "\n\n Elija la opcion: " +
                        "\n 1. Ver Tickets" +
                        "\n 2. Ver viajes";
        int opcion = EntradaSalida.leerInt(menu);

        switch (opcion){
            case 1:
                JOptionPane.showConfirmDialog(null,repoViaje.listar().toString(), "VIAJES", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showConfirmDialog(null, mostrarViajesMomento().toString(), "Viajes momento",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    public void verificarContraseña (int ingresada) throws ERRORContraseña {
        if (ingresada != 123456){
            throw new ERRORContraseña("Contraseña inválida");
        }
    }

    public ArrayList<Viaje> mostrarViajesMomento (){
        ArrayList<Viaje> listaViajesMomento = new ArrayList<Viaje>();

        for (Viaje viaje: repoViaje.listar()){
            if (viaje.getVehiculo().getEstado().equals(Estados.OCUPADO)){
                listaViajesMomento.add(viaje);
            }
        }

        return listaViajesMomento;
    }



}
