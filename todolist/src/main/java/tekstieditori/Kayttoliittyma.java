package tekstieditori;

import java.io.IOException;
import java.util.Scanner;

public class Kayttoliittyma {

    private static Scanner lukija = new Scanner(System.in);
    private static Tekstieditori editori = new Tekstieditori();

    public static void main(String[] args) throws IOException {

        tiedostoSijaintiJaNimi();
        kirjoitaTiedostoon();

        System.out.println(editori.lueTiedosto("D:\\", "kissa.txt"));
        editori.tyhjennaTiedosto("D:\\", "kissa.txt");
        System.out.println(editori.lueTiedosto(editori.getSijainti(), editori.getNimi()));
        editori.poistaTiedosto();
    }

    public static void tiedostoSijaintiJaNimi() throws IOException {

        String sijainti, nimi;

        while (true) {
            //Kysytään tiedoston sijainti, ja tekstitiedosto
            System.out.println("Anna sijainti, esim D:\\ ");
            sijainti = lukija.nextLine();
            System.out.println("Anna tekstitiedoston nimi ");
            nimi = lukija.nextLine();

            if (sijainti.equals("") || nimi.equals("")) {
                System.out.println("Et antanut sijaintia tai nimeä ");
                break;
            } else {
                editori.setNimi(nimi);
                editori.setSijainti(sijainti);
            }
            break;
        }
    }

    public static void kirjoitaTiedostoon() throws IOException {
        String teksti;

        //Kysytään mitä tiedostoon kirjoitetaan    
        System.out.println("Kirjoita tiedostoon: ");
        teksti = lukija.nextLine();

        editori.kirjoitaTiedosto(teksti);

    }

}
