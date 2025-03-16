package repositorios;

import excepciones.IdentificadorDuplicadoException;

import java.util.List;

public interface IRepositorio <T>{
    void agregar(T item) throws IdentificadorDuplicadoException;
    void eliminar(String id);
    T buscarPorId(String id);
    List<T> obtenerTodosOrdenador();
    List<T> filtrarPorGenero(String genero);
}
