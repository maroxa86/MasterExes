package tienda.dominios;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tienda.dominios.Trabajador;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-02-21T22:12:20")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> clave;
    public static volatile SingularAttribute<Usuario, String> usuario;
    public static volatile SingularAttribute<Usuario, Trabajador> idTrabajador;
    public static volatile SingularAttribute<Usuario, Short> activo;

}