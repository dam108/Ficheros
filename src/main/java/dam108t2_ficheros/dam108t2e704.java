package dam108t2_ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class dam108t2e704 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in, "ISO-8859-1");
        String fin = "fin", cadena = "";
        
        File f = new File("archivos\\fich04.txt");
        try(FileWriter fw = new FileWriter(f);
            BufferedWriter bfw = new BufferedWriter(fw)){
            
            while (!cadena.equals(fin)){
                System.out.println("Introduce una palabra");
                cadena = teclado.nextLine();
                if (!cadena.equals(fin)){
                    bfw.write(cadena);bfw.newLine();
                }
            }
        } catch (IOException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
}
