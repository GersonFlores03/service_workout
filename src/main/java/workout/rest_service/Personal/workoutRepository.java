package workout.rest_service.Personal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public  interface workoutRepository extends JpaRepository<Usuario, Long> {

}