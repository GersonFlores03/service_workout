package workout.rest_service.Notificaciones;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import workout.rest_service.Personal.Usuario;
import workout.rest_service.Rutina.Workout;

import java.util.Date;

@Entity
@Table(name = "Notificacion")
@EntityListeners(AuditingEntityListener.class)
public class Notificacion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mensaje")
    private String mensaje;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "estado")
    private int estado;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Notificacion(){

    }

    public Notificacion(Long id , String mensaje , Date fecha , int estado ){
        this.id = id;
        this.mensaje = mensaje;
        this.fecha= fecha;
        this.estado = estado;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
