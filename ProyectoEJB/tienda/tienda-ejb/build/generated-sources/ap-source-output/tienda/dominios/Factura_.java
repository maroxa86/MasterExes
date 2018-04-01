package tienda.dominios;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tienda.dominios.Cliente;
import tienda.dominios.Detalle;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-02-27T20:01:11")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Cliente> IdCliente;
    public static volatile ListAttribute<Factura, Detalle> listadoDetalles;
    public static volatile SingularAttribute<Factura, Date> fechaFactura;
    public static volatile SingularAttribute<Factura, Integer> procesado;
    public static volatile SingularAttribute<Factura, Long> numFactura;
    public static volatile SingularAttribute<Factura, Date> fechaProcesado;

}