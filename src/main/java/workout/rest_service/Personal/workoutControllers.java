package workout.rest_service.Personal;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/login")
public class workoutControllers {


    @Autowired
    private workoutRepository repositoryWorkout;

    @GetMapping
    private ResponseEntity<List<Usuario>> findAllUser(){
        List<Usuario> userPage = repositoryWorkout.findAll();
        return ResponseEntity.ok(userPage);
    }


    //Buscar el usuario
    @GetMapping("/{id}")
    public  ResponseEntity<Usuario> serachUser(@PathVariable Long id){
        Optional<Usuario> usuarioOptional = repositoryWorkout.findById(id);

        if(usuarioOptional.isPresent()){
            return ResponseEntity.ok(usuarioOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }

     @PostMapping
     public ResponseEntity<Void> addRutina(@RequestBody Usuario userBody , UriComponentsBuilder ucb){
         Usuario saveUsuario = repositoryWorkout.save(userBody);
         URI locationOfNewUser = ucb
                 .path("login/{id}")
                 .build(saveUsuario.getId());
         return ResponseEntity.created(locationOfNewUser).build();
     }

}