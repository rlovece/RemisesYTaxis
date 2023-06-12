package org.example.Repositorio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.Clases.Remis;
import org.example.Clases.Taxi;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TaxiRepo implements IRepositorio<Taxi>{

    private final File archivo = new File("src\\main\\java\\org\\example\\Archivos\\taxis.json");

    private final ObjectMapper mapper = new ObjectMapper();

    ArrayList<Taxi> listaTaxis = new ArrayList<>();

    @Override
    public void cargar() {
        try {
            CollectionType collectionType =
                    mapper.getTypeFactory().constructCollectionType(ArrayList.class, Taxi.class);
            this.listaTaxis = mapper.readValue(archivo, collectionType);
        } catch (IOException e) {
            this.listaTaxis = null;
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, listaTaxis);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Taxi> listar() {
        cargar();
        return this.listaTaxis;
    }

    @Override
    public void agregar(Taxi... objeto) {
        cargar();
        listaTaxis.addAll(List.of(objeto));
        guardar();
    }

    @Override
    public void eliminar(String patente) {
        cargar();
        for (Taxi taxi: this.listaTaxis) {
            if (taxi.getPatente().equals(patente)){
                listaTaxis.remove(taxi);
                break;
            }
        }
        guardar();
    }

    @Override
    public void modificar(String patente) {
        cargar();
        for (Taxi taxi: this.listaTaxis) {
            if (taxi.getPatente().equals(patente)){
                taxi.modificar();
                break;
            }
        }
        guardar();
    }

    @Override
    public Taxi buscar(String patente) throws InexistenteException {
        for (Taxi taxi: this.listaTaxis) {
            if (taxi.getPatente().equals(patente)){
                return taxi;
            }
        }
        throw new InexistenteException("Cliente inexistente");
    }
}
