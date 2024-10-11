package workout.rest_service.Notificaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionServices{

    @Autowired
    private NotificacionRepository repositoryNotificacion;


    public List<Notificacion> getNotificacion(Notificacion notificacion){
         return repositoryNotificacion.findAll();
    }

    public Notificacion addRepository(Notificacion notificacion){
        return repositoryNotificacion.save(notificacion);
    }

}
