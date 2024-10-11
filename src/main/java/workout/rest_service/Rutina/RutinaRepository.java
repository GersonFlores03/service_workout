package workout.rest_service.Rutina;

import org.springframework.data.jpa.repository.JpaRepository;
import workout.rest_service.Personal.Usuario;


public interface RutinaRepository extends JpaRepository<Workout , Long> {

}