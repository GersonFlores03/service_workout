package workout.rest_service.Ejercicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import workout.rest_service.Rutina.Workout;

import java.util.List;

@RestController
@RequestMapping(path = "/ejercicio")
public class EjercicioControllers {

    @Autowired
    private EjercicioServices servicesEjercicio;


    @GetMapping
    public List<Movimiento> getMovimiento(Movimiento movimiento){
         return  servicesEjercicio.getMovimiento(movimiento);
    }

    @PostMapping
    public Movimiento AddEjercicio(@RequestBody Movimiento movimiento){
        return  servicesEjercicio.AddEjercicio(movimiento);
    }


}