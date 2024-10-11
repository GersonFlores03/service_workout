package workout.rest_service.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "categoria")
public class CategoriaControllers {


    @Autowired
    public CategoriaRepository repositoryCategoria;



    @PostMapping
    private ResponseEntity<Void> createCategoria(@RequestBody Categoria categoria , UriComponentsBuilder ucb ){

            Categoria categorias = repositoryCategoria.save(categoria);
            URI locationOfNewCategoria = ucb
                .path("categoria/{id}")
                .build(categorias.getId());
            return ResponseEntity.created(locationOfNewCategoria).build();

    }




}
