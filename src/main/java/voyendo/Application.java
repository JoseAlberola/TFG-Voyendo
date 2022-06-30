package voyendo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import voyendo.controller.FileUploadController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        File directorioImagenes = new File(FileUploadController.uploadDirectory);
        if (!directorioImagenes.exists()) {
            if (directorioImagenes.mkdirs()) {
                System.out.println("Directorio creado");
                try {
                    Path source = Paths.get(System.getProperty("user.dir")+ "/src/main/resources/static/images/defaultAvatar.jpg");
                    Path target = Paths.get(directorioImagenes.getAbsolutePath() + "/defaultAvatar.jpg");
                    Files.copy(source, target);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Error al crear directorio");
            }
        }

        SpringApplication.run(Application.class, args);
    }
}