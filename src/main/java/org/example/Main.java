package org.example;

import org.example.Clases.Cliente;
import org.example.Clases.EntradaSalida;
import org.example.Clases.Remis;
import org.example.Clases.Taxi;
import org.example.ClasesGestion.AdmGestion;
import org.example.ClasesGestion.ClienteGestion;
import org.example.Repositorio.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        ViajesRepo viajes = new ViajesRepo();

        JOptionPane.showConfirmDialog(null, viajes.listar().toString(), "", JOptionPane.ERROR_MESSAGE);

        AdmGestion gestionAdmin = new AdmGestion();
        ClienteGestion gestionCliente = new ClienteGestion();

        String menu = "\n     Bienvenido" +
                "\n 1. Cliente " +
                "\n 2. Admin" +
                "\n 0. Salir \n\n";

        int opcion = 0;

        do {
            opcion= EntradaSalida.leerInt(menu);
            switch (opcion){
                case 1:
                    gestionCliente.menuCliente();
                    break;
                case 2:
                    try {
                        gestionAdmin.menuAdm1();
                    } catch (ERRORContraseña e) {
                        String error = "Contraseña inválida";
                        JOptionPane.showConfirmDialog(null, error, "ERROR", JOptionPane.ERROR_MESSAGE );
                    }
                    break;
            }
        } while (opcion != 0);



    }
}