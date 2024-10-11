package workout.rest_service.Ejercicio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import workout.rest_service.Detalle.RutinaDetalle;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movimiento")
@EntityListeners(AuditingEntityListener.class)
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre" , nullable = false )
    private String nombre;

    @Column(name = "tipo" , nullable = false )
    private String tipo;

    @Column(name = "duracion" , nullable = false )
    private int duracion;

    @Column(name = "serie" , nullable = false )
    private int serie;

    @Column(name = "repeticion" , nullable = false )
    private int repeticion;

    @Column(name = "descripcion" , nullable = false )
    private String descripcion;


    @Column(name = "dificultad" , nullable = false)
    private String dificultad;


    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate dateCreacion;


    public Movimiento() {

    }

    public Movimiento(Long id , String nombre , String descripcion , int repeticion , String tipo , int duracion , int serie, String dificultad, LocalDate dateCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.repeticion = repeticion;
        this.tipo = tipo;
        this.duracion = duracion;
        this.serie = serie;
        this.dificultad = dificultad;
        this.dateCreacion = dateCreacion;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(int repeticion) {
        this.repeticion = repeticion;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }


    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }


    public LocalDate getDateCreacion() {
        return dateCreacion;
    }

    public void setDateCreacion(LocalDate dateCreacion) {
        this.dateCreacion = dateCreacion;
    }


    @Override
    public String toString() {
        return "Movimiento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", duracion=" + duracion +
                ", serie=" + serie +
                ", repeticion=" + repeticion +
                ", descripcion='" + descripcion + '\'' +
                ", dificultad='" + dificultad + '\'' +
                ", dateCreacion=" + dateCreacion +
                '}';
    }
}





