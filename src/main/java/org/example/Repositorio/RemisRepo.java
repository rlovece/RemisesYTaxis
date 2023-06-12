package org.example.Repositorio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.Clases.Remis;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RemisRepo implements IRepositorio<Remis>{

    private final File archivo = new File("src\\main\\java\\org\\example\\Archivos\\remises.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Remis> listaRemises = new ArrayList<Remis>();

    @Override
    public void cargar() {
        try {
            CollectionType collectionType =
                    mapper.getTypeFactory().constructCollectionType(ArrayList.class, Remis.class);
            this.listaRemises = mapper.readValue(archivo, collectionType);
        } catch (IOException e) {
            this.listaRemises = null;
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, listaRemises);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Remis> listar() {
        cargar();
        return this.listaRemises;
    }

    @Override
    public void agregar(Remis... objeto) {
        cargar();
        this.listaRemises.addAll(List.of(objeto));
        guardar();
    }

    @Override
    public void eliminar(String patente) {
        cargar();
        for (Remis remis: this.listaRemises) {
            if (remis.getPatente().equals(patente)){
                this.listaRemises.remove(remis);
                break;
            }
        }
        guardar();
    }

    @Override
    public void modificar(String patente) {
        cargar();
        for (Remis remis: this.listaRemises) {
            if (remis.getPatente().equals(patente)){
                remis.modificar();
                break;
            }
        }
        guardar();
    }
}
