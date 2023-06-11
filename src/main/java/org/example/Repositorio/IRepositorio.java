package org.example.Repositorio;

import java.util.List;

public interface IRepositorio <T>{
    void cargar();
    void guardar();
    List<T> listar();
    void agregar(T... objeto);
    void eliminar(int id);
    void modificar(int id);
}
