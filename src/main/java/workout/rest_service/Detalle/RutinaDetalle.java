package workout.rest_service.Detalle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import workout.rest_service.Ejercicio.Movimiento;
import workout.rest_service.Rutina.Workout;

import java.util.List;

@Entity
@Table(name = "detalle_rutinas")
@EntityListeners(AuditingEntityListener.class)
public class RutinaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "rutina_id")
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "movimiento_id")
    private Movimiento movimiento;




    public RutinaDetalle(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }
}
