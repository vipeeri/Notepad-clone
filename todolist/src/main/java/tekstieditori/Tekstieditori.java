package tekstieditori;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Tekstieditori {

    private String sijainti;
    private String nimi;
    private String teksti;

    Tekstieditori() {
        this.sijainti = "";
        this.nimi = "";
        this.teksti = "";

    }

    public String getSijainti() {
        return this.sijainti;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public void aloita() throws IOException {
        Scanner lukija = new Scanner(System.in);

        while (true) {
            //Kysytään tiedoston sijainti, ja tekstitiedosto
            System.out.println("Anna sijainti, esim D:\\: ");
            this.sijainti = lukija.nextLine();
            System.out.println("Anna tekstitiedoston nimi: ");
            this.nimi = lukija.nextLine();
            //Kysytään mitä tiedostoon kirjoitetaan    
            System.out.println("Kirjoita tiedostoon: ");
            this.teksti = lukija.nextLine();

            if (this.sijainti.equals("") || this.nimi.equals("")) {
                System.out.println("Et antanut sijaintia tai nimeä.");
                break;
            } else {
                kirjoitaTiedosto();
            }
            break;
        }
    }

    public void kirjoitaTiedosto() throws IOException {
        //Path polku = Paths.get("D:\\", "tässäontekstiä.txt");
        //String teksti = "\n testikirjoitus";
        Path polku = Paths.get(this.sijainti, this.nimi);
        //Tarkistetaan että hakemisto on olemassa
        Files.createDirectories(polku.getParent());
        //Kirjoitetaan tiedostoon temp.txt
        try (
                final BufferedWriter kirjoittaja = Files.newBufferedWriter(polku,
                        StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND)) {
            kirjoittaja.write(teksti);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    //Metodilla voidaan tyhjentää olemassaoleva tekstitiedosto
    public void tyhjennaTiedosto(String sijainti, String nimi) throws FileNotFoundException {
        Path polku = Paths.get(sijainti, nimi);
        try (
                final BufferedWriter kirjoittaja = Files.newBufferedWriter(polku,
                        StandardCharsets.UTF_8)) {
            kirjoittaja.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Metodilla voidaan poistaa koko tekstitiedosto
    public void poistaTiedosto() {
        try {
            File file = new File("D:\\kissa.txt");

            if (file.delete()) {
                System.out.println(file.getName() + " poistettu.");
            } else {
                System.out.println("poisto ei onnistunut.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String lueTiedosto() {

        String filePath = new File("D:\\").getAbsolutePath();

        StringBuilder tiedostonSisalto = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath + "kissa.txt"));

            String kokoteksti;
            while ((kokoteksti = reader.readLine()) != null) {
                
            
               tiedostonSisalto.append(kokoteksti);
//                tiedostonSisalto.append("\n");
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return tiedostonSisalto.toString();
    }
}
