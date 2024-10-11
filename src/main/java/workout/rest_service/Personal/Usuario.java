package workout.rest_service.Personal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import workout.rest_service.Notificaciones.Notificacion;
import workout.rest_service.Reporte.Reporte;
import workout.rest_service.Rutina.Workout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Usuario")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "email" , nullable = false , unique = true)
    private String email;

    @Column(name = "password" , nullable = false , unique = true)
    private String password;


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Workout> workout;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Notificacion> notificacion;



    public Usuario() {

    }

    public Long getId() {
        return id;
    }


    public Usuario(Long id , String email , String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }



    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Workout> getWorkout() {
        return workout;
    }

    public void setWorkout(Set<Workout> workout) {
        this.workout = workout;
    }

    public Set<Notificacion> getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(Set<Notificacion> notificacion) {
        this.notificacion = notificacion;
    }
}



