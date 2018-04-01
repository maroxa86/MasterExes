package tienda.dominios;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tienda.dominios.Trabajador;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-02-21T22:12:20")
@StaticMetamodel(TipoTrabajador.class)
public class TipoTrabajador_ { 

    public static volatile SingularAttribute<TipoTrabajador, Integer> id;
    public static volatile SingularAttribute<TipoTrabajador, String> nombre;
    public static volatile ListAttribute<TipoTrabajador, Trabajador> trabajadorList;

}