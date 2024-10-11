package workout.rest_service.Reporte;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import workout.rest_service.Personal.Usuario;
import workout.rest_service.Rutina.Workout;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/reporte")
public class ControllersReporte {

    @Autowired
    private ReporteRepository repositoryReporte;




    @GetMapping
    public ResponseEntity<List<Reporte>> getReporte(Reporte reporte){
        List<Reporte> findAllReporte = repositoryReporte.findAll();
        return  ResponseEntity.ok(findAllReporte);
    }

    @PostMapping
    public ResponseEntity<Void> addReporte(@RequestBody Reporte reporte , UriComponentsBuilder ucb){
        Reporte reporteBody = repositoryReporte.save(reporte);
        URI locationOfNewUser = ucb
                .path("reporte/{id}")
                .build(reporteBody.getId());
        return ResponseEntity.created(locationOfNewUser).build();
    }



}
