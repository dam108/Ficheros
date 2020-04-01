package dam108t2_ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class dam108t2e705 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in, "ISO-8859-1"); 
        String fin = "fin", cadena = "";
        BufferedWriter bfw=null;
                
        File f = new File("archivos\\fich04.txt");
        try {
            if (f.exists()){
                File b = new File("archivos\\fich04.bak");
                if (b.exists()) b.delete();
                Files.copy(f.toPath(), b.toPath());
            }
        } 
        catch (IOException ex){
            System.err.printf("Error: %s ",ex.getMessage());
        }
        

        try {
            FileWriter fw = new FileWriter(f, true);
            bfw = new BufferedWriter(fw);
            while (!cadena.equals(fin)){
                    System.out.println("Introduce una palabra");
                    cadena = teclado.nextLine();
                    if (!cadena.equals(fin)){
                        bfw.newLine();
                        bfw.write(cadena);
                    }
                }
        }catch (IOException ex){
            System.out.println("Error: "+ex.getMessage());
        } finally {
            try {
                if (bfw !=null) bfw.close();
            } catch (IOException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
     } // fin main
} // fin class

