package org.example.Clases;
import javax.swing.JOptionPane;

import static javax.swing.JOptionPane.*;

public class EntradaSalida {

    public static int leerInt (String msj){

        boolean continuar = false;
        int nro = 0;

        while (!continuar) {
            try {
                String entrada = showInputDialog(msj);
                nro = Integer.parseInt(entrada);
                continuar = true;
            } catch (NumberFormatException e) {
                String error = "Debe introducir un nro entero";
                JOptionPane.showMessageDialog(null, error, "ERROR", ERROR_MESSAGE);
            }
        }
        return  nro;
    }

    public static int leerInt2 (String msj) throws NumberFormatException{
        String entrada = showInputDialog(msj);
        int nro= Integer.parseInt(entrada);
        return  nro;
    }

    public static float leerfloat (String msj) throws NumberFormatException{
        String entrada = showInputDialog(msj);
        float nro= Float.parseFloat(entrada);
        return  nro;
    }

    public static String entradaString (String msj){
        return showInputDialog(msj);
    }

}