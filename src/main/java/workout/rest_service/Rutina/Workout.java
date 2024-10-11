package workout.rest_service.Rutina;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import workout.rest_service.Detalle.RutinaDetalle;
import workout.rest_service.Ejercicio.Movimiento;
import workout.rest_service.Personal.Usuario;
import workout.rest_service.Reporte.Reporte;
import workout.rest_service.categoria.Categoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "rutina")
@EntityListeners(AuditingEntityListener.class)
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre" , nullable = false )
    private String nombre;

    @Column(name = "descripcion" , nullable = false )
    private String descripcion;

    @Column(name = "duracion" , nullable = false )
    private int duracion;

    @Column(name = "imagen" , nullable = false )
    private String imgUrl;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate dateInicio;


    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate dateFinal;


    @ManyToMany
    @JoinTable(
            name = "detalle_rutinas",
            joinColumns = @JoinColumn(name = "rutina_id" ),
            inverseJoinColumns = @JoinColumn(name = "movimiento_id")
    )

    private List<Movimiento> movimientos = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Reporte> reporte;




    public Workout() {

    }

    public Workout(Long id, String nombre, String descripcion, LocalDate dateFinal , LocalDate dateInicio , int duracion , String imgUrl) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dateFinal = dateFinal;
        this.dateInicio = dateInicio;
        this.duracion = duracion;
        this.imgUrl = imgUrl;
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


    public LocalDate getDateInicio() {
        return dateInicio;
    }

    public void setDateInicio(LocalDate dateInicio) {
        this.dateInicio = dateInicio;
    }

    public LocalDate getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(LocalDate dateFinal) {
        this.dateFinal = dateFinal;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<Reporte> getReporte() {
        return reporte;
    }



    public void setReporte(Set<Reporte> reporte) {
        this.reporte = reporte;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", duracion=" + duracion +
                ", dateInicio=" + dateInicio +
                ", dateFinal=" + dateFinal +
                ", movimientos=" + movimientos +
                ", usuario=" + usuario +
                '}';
    }
}