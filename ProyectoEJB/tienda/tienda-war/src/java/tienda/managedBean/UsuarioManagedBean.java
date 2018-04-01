package tienda.managedBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import tienda.dominios.TipoTrabajador;
import tienda.dominios.Trabajador;
import tienda.dominios.Usuario;
import tienda.service.TipoTrabajadorService;
import tienda.service.UsuarioService;

@ManagedBean(name = "usuario")
@RequestScoped
public class UsuarioManagedBean {

    private String user;
    private String pwd;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechaNacimiento;
    private List<SelectItem> tipoTrabajadorSelectItem;
    private Integer tipoTrabajadorId;

    @EJB
    private TipoTrabajadorService tipoTrabajadorService;

    @EJB
    private UsuarioService usuarioService;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<SelectItem> getTipoTrabajadorSelectItem() {
        List<TipoTrabajador> tipoTrabajadorList = tipoTrabajadorService.getListadoTipoTrabajador();
        tipoTrabajadorSelectItem = new ArrayList<>();
        for (TipoTrabajador tipoTrabajadorInfo : tipoTrabajadorList) {
            tipoTrabajadorSelectItem.add(new SelectItem(tipoTrabajadorInfo.getId(), tipoTrabajadorInfo.getNombre()));
        }
        return tipoTrabajadorSelectItem;
    }

    public void setTipoTrabajadorSelectItem(List<SelectItem> tipoTrabajadorSelectItem) {
        this.tipoTrabajadorSelectItem = tipoTrabajadorSelectItem;
    }

    public TipoTrabajadorService getTipoTrabajadorService() {
        return tipoTrabajadorService;
    }

    public void setTipoTrabajadorService(TipoTrabajadorService tipoTrabajadorService) {
        this.tipoTrabajadorService = tipoTrabajadorService;
    }

    public Integer getTipoTrabajadorId() {
        return tipoTrabajadorId;
    }

    public void setTipoTrabajadorId(Integer tipoTrabajadorId) {
        this.tipoTrabajadorId = tipoTrabajadorId;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public String crearUsuario() {
        user = "";
        pwd = "";
        nombre = "";
        apellido1 = "";
        apellido2 = "";
        tipoTrabajadorSelectItem = null;
        tipoTrabajadorId = null;
        fechaNacimiento = null;
        return "crearUsuario";
    }

    public void newUsuario(ActionEvent e) {
        Trabajador trabajador = new Trabajador();
        trabajador.setNombre(nombre);
        trabajador.setApellido1(apellido1);
        trabajador.setApellido2(apellido2);
        trabajador.setFechaNacimiento(fechaNacimiento);
        trabajador.setFechaIncorporacion(new Date());
        trabajador.setTipoTrabajador(new TipoTrabajador(tipoTrabajadorId));

        Usuario usuario = new Usuario();
        usuario.setUsuario(user);
        usuario.setClave(pwd);
        usuario.setIdTrabajador(trabajador);
        usuario.setActivo((short) 1);

        usuarioService.newUsuario(usuario);

    }

}
