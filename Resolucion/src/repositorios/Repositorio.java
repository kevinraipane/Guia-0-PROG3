package repositorios;

import excepciones.IdentificadorDuplicadoException;
import models.JuegoBase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Repositorio <T extends JuegoBase> implements IRepositorio<T> {
    //INICIALIZO LA COLECCION A UTILIZAR, en mi caso un treeset para utilizar IComparable, si usara hashset
    // para asegurar que sean unicos, deberia utilizar IComparator
    private Set<T> coleccion = new HashSet<>();

    //AGREGAR UN ITEM A LA COLECCION ------------------------------------
    @Override
    public void agregar(T item)
            throws IdentificadorDuplicadoException{
        if(buscarPorId(item.getId()) != null){
            throw new IdentificadorDuplicadoException("El ID ´" +item.getId()+ "´ya existe.");
        }
        coleccion.add(item);
    }

    //ELIMINAR UN ITEM POR ´ID´ DE LA COLECCION -------------------------
    @Override
    public void eliminar(String id) {
        coleccion.removeIf(item -> item.getId().equals(id));
    }

    //BUSCAR POR ´ID´ ---------------------------------------------------
    @Override
    public T buscarPorId(String id){
        for(T item : coleccion){
            if(item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }

    @Override
    //METODO PARA OBTENER TODOS ORDENADOR ------------------------------
    public List<T> obtenerTodosOrdenador(){
        List<T> listaOrdenada = new ArrayList<>(coleccion);//copio coleccion en lista ordenada, para no modificar la original
        listaOrdenada.sort((o1, o2) -> o1.getTitulo().compareTo(o2.getTitulo()));
        return listaOrdenada;
    }

    @Override
    //METODO PARA FILTRAR POR GENERO
    public List<T> filtrarPorGenero(String genero){
        return coleccion.stream().filter(item -> item.getGenero()
                .equalsIgnoreCase(genero)).collect(Collectors.toList());
    }
}
