package tekstieditori;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Tekstieditori {

    Tekstieditori() {

    }

    public void kirjoita() throws IOException {

        Path polku = Paths.get("D:\\", "tässäontekstiä.txt");
        String text = "\n testikirjoitus";
        Files.createDirectories(polku.getParent());
        
        
        //Kirjoitetaan tiedostoon temp.txt
   try (
          final BufferedWriter writer = Files.newBufferedWriter(polku, 
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {
            
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
