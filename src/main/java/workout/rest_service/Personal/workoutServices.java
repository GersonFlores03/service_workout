package workout.rest_service.Personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  workoutServices {

     @Autowired
     private workoutRepository RepositoryW;


     public List<Usuario> getUsuarios(Usuario user) {
          return RepositoryW.findAll();
     }


     public Usuario addRutina(Usuario user){
          return  RepositoryW.save(user);
     }




}