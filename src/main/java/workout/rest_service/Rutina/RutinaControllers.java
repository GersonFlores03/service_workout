package workout.rest_service.Rutina;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.auth.FirebaseAuthException;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;
import workout.rest_service.Personal.Usuario;
import workout.rest_service.Personal.workoutRepository;
import workout.rest_service.categoria.Categoria;
import workout.rest_service.categoria.CategoriaRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/rutina" )
class RutinaControllers {

    @Autowired
    private RutinaServices servicesRutina;

    @Autowired
    private  RutinaRepository repositoryRutina;

    @Autowired
    private workoutRepository repositoryWorkout;

    @Autowired
    public CategoriaRepository repositoryCategoria;


    //Upload

    private String uploadFile(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("imagesproyect.appspot.com", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        InputStream inputStream = RutinaServices.class.getClassLoader().getResourceAsStream("imagesproyect-firebase-adminsdk.json");
        Credentials credentials = GoogleCredentials.fromStream(inputStream);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));

        String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/imagesproyect.appspot.com/o/%s?alt=media";
        return String.format(DOWNLOAD_URL, URLEncoder.encode(fileName, StandardCharsets.UTF_8));
    }


    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);

        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
            fos.close();
        }
        return tempFile;
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }


    public String upload(MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();
            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));

            File file = this.convertToFile(multipartFile, fileName);
            String URL = this.uploadFile(file, fileName);
            file.delete();
            return URL;
        } catch (Exception e) {
            e.printStackTrace();
            return "Image couldn't upload, Something went wrong";
        }
    }



    @GetMapping
    public ResponseEntity<List<Workout>> getRutina(Workout workout){
            List<Workout> findAllWorkout = repositoryRutina.findAll();
            return  ResponseEntity.ok(findAllWorkout);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Workout> getRutinafind(@PathVariable Long id){
            Optional<Workout> findWorkout = repositoryRutina.findById(id);
            if(findWorkout.isPresent()){
                return ResponseEntity.ok(findWorkout.get());
            }else{
                return ResponseEntity.notFound().build();
            }
    }

    //Post para crear una rutina con multipart
    @PostMapping(consumes = "multipart/form-data")
    public Workout AgregarRutina(
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("duracion") int duracion,
            @RequestParam("imagen") MultipartFile file,
            @RequestParam("categoria") Long categoriaId,
            @RequestParam("dateInicio") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDate dateInicio,
            @RequestParam("dateFinal") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDate dateFinal,
            @RequestParam("usuario") Long usuarioId )

    {

        //Objeto para agregar los requestParam a los datos almacenados de la bd
        Workout rutina = new Workout();
        rutina.setNombre(nombre);
        rutina.setDescripcion(descripcion);
        rutina.setDuracion(duracion);
        rutina.setDateInicio(dateInicio);
        rutina.setDateFinal(dateFinal);

        Optional<Categoria> categoria =repositoryCategoria.findById(categoriaId);

        Categoria idCategoria = categoria.get();
        rutina.setCategoria(idCategoria);

        //Busquedad de un usuario id con optional
        Optional<Usuario> user = repositoryWorkout.findById(usuarioId);

        Usuario userId = user.get();
        rutina.setUsuario(userId);

        //Funcion para el guardado de la imagen
        String url = upload(file);

        rutina.setImgUrl(url);

        // Guardar en la base de datos
        return repositoryRutina.save(rutina);
    }




    @PatchMapping()
    private  ResponseEntity<Workout> updateRutina(@RequestParam Long workoutId){
            Optional<Workout> workoutUpdate = repositoryRutina.findById(workoutId);
            Workout workoutResponse =  workoutUpdate.get();
            workoutResponse.setImgUrl(workoutResponse.getImgUrl());

            return  ResponseEntity.ok(workoutResponse);

    }






}