package tienda.dominios;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tienda.dominios.Cliente;
import tienda.dominios.TipoTrabajador;
import tienda.dominios.Usuario;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-02-21T22:12:20")
@StaticMetamodel(Trabajador.class)
public class Trabajador_ { 

    public static volatile SingularAttribute<Trabajador, String> apellido2;
    public static volatile ListAttribute<Trabajador, Usuario> usuarioList;
    public static volatile SingularAttribute<Trabajador, Date> fechaIncorporacion;
    public static volatile ListAttribute<Trabajador, Cliente> clientesList;
    public static volatile SingularAttribute<Trabajador, Date> fechaNacimiento;
    public static volatile SingularAttribute<Trabajador, String> apellido1;
    public static volatile SingularAttribute<Trabajador, Integer> id;
    public static volatile SingularAttribute<Trabajador, String> nombre;
    public static volatile SingularAttribute<Trabajador, TipoTrabajador> tipoTrabajador;

}