package org.example.Repositorio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.Clases.Cliente;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepo implements IRepositorio<Cliente>{

    private final File archivo =
            new File("src\\main\\java\\org\\example\\Archivos\\clientes.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Cliente> listaClientes;

    /**
     * La función se encargará de cargar a un ArrayList los clientes guardados en el archivo Clientes.Json
     */
    @Override
    public void cargar() {
        try {
            CollectionType collectionType =
                    mapper.getTypeFactory().constructCollectionType(ArrayList.class, Cliente.class);
            this.listaClientes = mapper.readValue(archivo, collectionType);
        } catch (IOException e) {
            this.listaClientes = new ArrayList<>();
        }

    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, this.listaClientes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Cliente> listar() {
        cargar();
        return this.listaClientes;
    }

    @Override
    public void agregar(Cliente... objeto) {
        cargar();
        this.listaClientes.addAll(List.of(objeto));
        guardar();
    }

    @Override
    public void eliminar(String id) {
        cargar();

        for(Cliente cliente: this.listaClientes){
            if(String.valueOf(cliente.getId()).equals(id)){
                this.listaClientes.remove(cliente);
                break;
            }

        }

        guardar();
    }

    @Override
    public void modificar(String id) {
        cargar();

        for(Cliente cliente: this.listaClientes){

            if(String.valueOf(cliente.getId()).equals(id)){
                cliente.modificarCliente();
                break;
            }
        }

        guardar();

    }
}
