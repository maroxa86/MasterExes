package tienda.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import tienda.dao.TrabajadorDAO;
import tienda.dao.UsuarioDAO;
import tienda.dominios.Usuario;
import tienda.service.UsuarioService;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

    @EJB
    private UsuarioDAO usuarioDAO;
    
    @EJB
    private TrabajadorDAO trabajadorDAO;

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public TrabajadorDAO getTrabajadorDAO() {
        return trabajadorDAO;
    }

    public void setTrabajadorDAO(TrabajadorDAO trabajadorDAO) {
        this.trabajadorDAO = trabajadorDAO;
    }

    @Override
    @Transactional
    public void newUsuario(Usuario usuario) {
        trabajadorDAO.insertar(usuario.getIdTrabajador());
        usuarioDAO.insertar(usuario);
    }

}
