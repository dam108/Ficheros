package dam108t2_ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class dam108t2e707 {

    public static void main(String[] args) {

        String f = new String("archivos\\fich04.txt");

        System.out.println(contar(f));
        System.out.println("Caracteres: " + contar(f).get(0));
        System.out.println("Palabras: " + contar(f).get(1));
        System.out.println("Lineas: " + contar(f).get(2));

    }

    public static ArrayList<Integer> contar(String fichero) {
        ArrayList<Integer> arr = new ArrayList<>();

        int caracteres = contarCaracteres(fichero);
        int palabras = contarPalabras(fichero);
        int lineas = contarLineas(fichero);

        arr.add(caracteres);
        arr.add(palabras);
        arr.add(lineas);

        return arr;
    }

    public static int contarCaracteres(String fichero) {
        try ( BufferedReader leer = new BufferedReader(new FileReader(fichero))) {
            int n = 0;
            String linea;

            while ((linea = leer.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    if(linea.charAt(i) != ' ') n++;
                }
            }

            return n;
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return 0;
    }

    public static int contarPalabras(String fichero) {

        try {

            int n;
            try (BufferedReader leer = new BufferedReader(new FileReader(fichero))) {
                n = 0;
                String linea;
                while ((linea = leer.readLine()) != null) {
                    for (int j = 0; j < linea.length(); j++) {
                        if (j == 0) {
                            if (linea.charAt(j) != ' ') {
                                n++;
                            }
                        } else {
                            if (linea.charAt(j - 1) == ' ') {
                                if (linea.charAt(j) != ' ') {
                                    n++;
                                }
                            }
                        }
                    }
                }
            }

            return n;

        } catch (IOException ex) {
            System.out.println("error: " + ex.getMessage());
        }
        return 0;
    }

    public static int contarLineas(String fichero) {

        try ( BufferedReader leer = new BufferedReader(new FileReader(fichero))) {
            int n = 0;
            String linea;

            while ((linea = leer.readLine()) != null) {
                n++;
            }

            return n;
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return 0;

    }

}
