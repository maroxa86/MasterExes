/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.timer;

import java.util.Date;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import tienda.dominios.Mensajes;
import tienda.dominios.Producto;
import tienda.service.MensajesService;
import tienda.service.ProductoService;

/**
 *
 * @author Xavi
 */
@Singleton
@LocalBean
public class Temporizador {

    private final Logger log = Logger.getLogger(getClass().getName());

    @EJB
    private ProductoService productoService;
    
    @EJB
    private MensajesService mensanjesService;

    @Schedule(second = "0", minute = "50", hour = "19", dayOfWeek = "*")
    public void performTask() {
        try {
            List<Producto> listadoProductos = productoService.cantidadStockProductos();
            StringBuilder texto = new StringBuilder();
            if(listadoProductos.size() > 0){
                String asunto = "Stock Insuficiente en almacen";
                texto.append("Los siguientes productos tienen falta de stock:\n");
                for(Producto producto : listadoProductos){
                    texto.append("\tNombre: ");
                    texto.append(producto.getNombre());
                    texto.append(", Cantidad: ");
                    texto.append(producto.getStock());
                    texto.append("\n");
                }
                texto.append("\nSaludos");
                Mensajes mensaje = new Mensajes(asunto, texto.toString(), new Date());
                mensanjesService.insertarMensajes(mensaje);
            }
        } catch (Exception e) {
            log.severe("Error en la tarea programada");
            log.info((Supplier<String>) e);
        }
    }
}
