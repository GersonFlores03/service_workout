package workout.rest_service.Notificaciones;


import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/notificacion")
public class NotificacionControllers {


     @Autowired
     private  NotificacionServices serviceNotificacion;

     @GetMapping
     public List<Notificacion> getNotificacion(Notificacion notificacion){
         return serviceNotificacion.getNotificacion(notificacion);
     }

     @PostMapping
     public Notificacion addNotificacion(@RequestBody Notificacion notificacion){
         return serviceNotificacion.addRepository(notificacion);
     }

}
