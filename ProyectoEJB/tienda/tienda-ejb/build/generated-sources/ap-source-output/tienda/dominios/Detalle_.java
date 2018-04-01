package tienda.dominios;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tienda.dominios.Factura;
import tienda.dominios.Producto;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-02-21T22:12:20")
@StaticMetamodel(Detalle.class)
public class Detalle_ { 

    public static volatile SingularAttribute<Detalle, Double> precio;
    public static volatile SingularAttribute<Detalle, Factura> factura;
    public static volatile SingularAttribute<Detalle, Integer> numDetalle;
    public static volatile SingularAttribute<Detalle, Integer> id;
    public static volatile SingularAttribute<Detalle, Producto> producto;
    public static volatile SingularAttribute<Detalle, Integer> cantidad;

}