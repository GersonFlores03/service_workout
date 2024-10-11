package workout.rest_service.Detalle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rutinaDetalle")
public class RutinaDetalleControllers {

     @Autowired
     private  RutinaDetalleServices servicesDetalle;


     @GetMapping
     public List<RutinaDetalle> getRutinaDetalle(RutinaDetalle rutinaDetalle){
          return  servicesDetalle.getRutinaDetalle(rutinaDetalle);
     }

     @PostMapping
     public RutinaDetalle addRutinaDetalle(@RequestBody RutinaDetalle rutinaDetalle){
         return servicesDetalle.addRutinaDetalle(rutinaDetalle);
     }


}
