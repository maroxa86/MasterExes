package tienda.service.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import tienda.dao.TipoTrabajadorDAO;
import tienda.dominios.TipoTrabajador;
import tienda.service.TipoTrabajadorService;

@Stateless
public class TipoTrabajadorServiceImpl implements TipoTrabajadorService {

    @EJB
    private TipoTrabajadorDAO tipoTrabajadorDAO;

    public TipoTrabajadorDAO getTipoTrabajadorDAO() {
        return tipoTrabajadorDAO;
    }

    public void setTipoTrabajadorDAO(TipoTrabajadorDAO tipoTrabajadorDAO) {
        this.tipoTrabajadorDAO = tipoTrabajadorDAO;
    }

    @Override
    public List<TipoTrabajador> getListadoTipoTrabajador() {
        return tipoTrabajadorDAO.buscarTodos();
    }

}
