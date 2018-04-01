package tienda.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, E extends Serializable> {
    T buscarPorClave(E id);
    List<T> buscarTodos();
    void insertar(T objeto);
    void salvar(T objeto);
    void borrar(T objeto);
}
