package org.example;

import org.example.Clases.Cliente;
import org.example.Clases.EntradaSalida;
import org.example.Clases.Remis;
import org.example.Clases.Taxi;
import org.example.ClasesGestion.ClienteGestion;
import org.example.Repositorio.ClienteRepo;
import org.example.Repositorio.RemisRepo;
import org.example.Repositorio.TaxiRepo;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
/*
        ClienteRepo clientes = new ClienteRepo();
        JOptionPane.showMessageDialog(null, clientes.listar().toString(), "lISTA Clientes",
                JOptionPane.INFORMATION_MESSAGE);

        RemisRepo remises = new RemisRepo();
        JOptionPane.showMessageDialog(null, remises.listar().toString(), "LISTA Remises",
                JOptionPane.INFORMATION_MESSAGE);
*/


        ClienteGestion gestionCliente = new ClienteGestion();

        gestionCliente.menuCliente();

    }
}