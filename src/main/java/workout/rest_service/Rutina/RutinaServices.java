package workout.rest_service.Rutina;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.multipart.MultipartFile;
import workout.rest_service.Personal.Usuario;
import workout.rest_service.Personal.workoutRepository;
import workout.rest_service.Personal.workoutServices;
import workout.rest_service.Rutina.Workout;
import workout.rest_service.Rutina.RutinaRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.PublicKey;
import java.util.List;
import java.util.UUID;

@Service
public class RutinaServices {

    @Autowired
     private RutinaRepository repositoryRutina;

    @Autowired
    private workoutServices serviceUser;







}