package workout.rest_service.Ejercicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workout.rest_service.Rutina.Workout;

import java.util.List;

@Service
public class EjercicioServices {


    @Autowired
    private EjercicioRepository repositoryEjercicio;

    public List<Movimiento> getMovimiento(Movimiento workout){
        return  repositoryEjercicio.findAll();
    }
    public Movimiento AddEjercicio(Movimiento movimiento){
       return  repositoryEjercicio.save(movimiento);
    }
}



