package workout.rest_service.Reporte;


import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import workout.rest_service.Rutina.Workout;
import workout.rest_service.categoria.Categoria;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "reporte")
@EntityListeners(AuditingEntityListener.class)
public class Reporte {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate dateReporte;

    @Column(name = "descripcion")
    private  String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_Rutina")
    private Workout workout;


    public Reporte(){

    }

    public Reporte(Long id, LocalDate dateReporte, String descripcion) {
        this.id = id;
        this.dateReporte = dateReporte;
        this.descripcion = descripcion;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateReporte() {
        return dateReporte;
    }

    public void setDateReporte(LocalDate dateReporte) {
        this.dateReporte = dateReporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                "id=" + id +
                ", dateReporte=" + dateReporte +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
