package tienda.dominios;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-02-28T22:01:20")
@StaticMetamodel(Mensajes.class)
public class Mensajes_ { 

    public static volatile SingularAttribute<Mensajes, Date> fechaRecibido;
    public static volatile SingularAttribute<Mensajes, String> asunto;
    public static volatile SingularAttribute<Mensajes, Short> leido;
    public static volatile SingularAttribute<Mensajes, Integer> id;
    public static volatile SingularAttribute<Mensajes, String> mensaje;

}