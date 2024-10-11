package workout.rest_service.Detalle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaDetalleServices {


    @Autowired
    private  RutinaDetalleRepository repositoryDetalle;


    public List<RutinaDetalle>  getRutinaDetalle(RutinaDetalle rutinaDetalle){
        return repositoryDetalle.findAll();

    }

    public RutinaDetalle addRutinaDetalle(RutinaDetalle rutinaDetalle){
        return repositoryDetalle.save(rutinaDetalle);
    }



}
