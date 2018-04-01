package tienda.dominios;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tienda.dominios.Factura;
import tienda.dominios.Trabajador;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-02-27T19:55:12")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Trabajador> trabajador;
    public static volatile SingularAttribute<Cliente, String> cif;
    public static volatile ListAttribute<Cliente, Factura> listadoFacturas;
    public static volatile SingularAttribute<Cliente, Short> comision;
    public static volatile SingularAttribute<Cliente, Integer> id;
    public static volatile SingularAttribute<Cliente, String> nombre;

}