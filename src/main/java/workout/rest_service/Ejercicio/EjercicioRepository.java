package workout.rest_service.Ejercicio;

import org.springframework.data.jpa.repository.JpaRepository;

public  interface EjercicioRepository  extends JpaRepository<Movimiento, Long> {
}