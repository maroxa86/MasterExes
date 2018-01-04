package tienda.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tienda.dao.GenericDAO;

@Repository
public abstract class AbstractGenericDAOImpl <T, E extends Serializable> implements GenericDAO<T, E>{

    private Class<T> claseDePersistencia;

    @PersistenceContext
    private EntityManager manager;
       
    @SuppressWarnings("unchecked")
    public AbstractGenericDAOImpl() {
        this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    @Transactional(readOnly=true)
    public T buscarPorClave(E id) {
        return manager.find(claseDePersistencia, id);
    }

    @Override
    @Transactional(readOnly=true)
    public List<T> buscarTodos() {
        TypedQuery<T> consulta = (TypedQuery<T>) manager.createQuery("select o from " + 
                                                    claseDePersistencia.getSimpleName() + " o", claseDePersistencia);
        return consulta.getResultList();
    }
    
    @Override
    @Transactional
    public void borrar(T objeto) {
        manager.remove(manager.merge(objeto));
    }

    @Override
    @Transactional
    public void salvar(T objeto) {
        manager.merge(objeto);
    }

    @Override
    @Transactional
    public void insertar(T objeto) {
        manager.persist(objeto);
    }
}
