package org.example.Repositorio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.Clases.Viaje;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ViajesRepo implements IRepositorio<Viaje>{
    private final File archivo = new File("src\\main\\java\\org\\example\\Archivos\\viajes.json");
    private final ObjectMapper mapper = new ObjectMapper();

    private ArrayList<Viaje> listaViajes;

    @Override
   /* public void cargar() {
        try {
            CollectionType collectionType =
                    mapper.getTypeFactory().constructCollectionType(ArrayList.class, Viaje.class);
            this.listaViajes = mapper.readValue(archivo, collectionType);
        } catch (IOException e){
            this.listaViajes = new ArrayList<Viaje>();
        }
    }*/

    public void cargar() {
        try {
            CollectionType collectionType =
                    mapper.getTypeFactory().constructCollectionType(ArrayList.class, Viaje.class);
            this.listaViajes = mapper.readValue(archivo, collectionType);
            System.out.println("Cantidad de viajes cargados: " + listaViajes.size());
        } catch (IOException e){
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            this.listaViajes = new ArrayList<>(); // Opcional: Crear una lista vacía en caso de error
        }
    }
    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, listaViajes);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Viaje> listar() {
        cargar();
        return this.listaViajes;
    }

    @Override
    public void agregar(Viaje... objeto) {
        cargar();
        this.listaViajes.addAll(List.of(objeto));
        guardar();
    }

    @Override
    public void eliminar(String id) {
        for (Viaje viaje: this.listaViajes) {
            if(String.valueOf(viaje.getId()).equals(id)){
                listaViajes.remove(viaje);
                break;
            }
        }
    }

    @Override
    public void modificar(String id) {
        for (Viaje viaje: this.listaViajes) {
            if(String.valueOf(viaje.getId()).equals(id)){
                viaje.modificar();
                break;
            }
        }
    }

    @Override
    public Viaje buscar(String id) throws InexistenteException {
        for (Viaje viaje: this.listaViajes) {
            if(String.valueOf(viaje.getId()).equals(id)){
                return viaje;
            }
        }
        throw new InexistenteException("Cliente inexistente");
    }
}
