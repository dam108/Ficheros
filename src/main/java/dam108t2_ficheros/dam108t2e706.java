package dam108t2_ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class dam108t2e706 {

    public static void main(String[] args) {

        File f = new File("archivos\\fich04.txt");
        String cadena;
        try ( FileReader fr = new FileReader(f);  BufferedReader bfr = new BufferedReader(fr)) {
            while ((cadena = bfr.readLine()) != null) {
                System.out.printf("%s\n", cadena.toUpperCase());
            }
        } catch (IOException ex) {
            System.err.printf("Error:%s\n", ex.getMessage());
        }

    }

}
