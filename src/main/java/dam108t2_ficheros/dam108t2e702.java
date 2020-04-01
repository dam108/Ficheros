package dam108t2_ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class dam108t2e702 {

    public static void main(String[] args) {
        File f = new File("archivos\\fich02.txt");
        try(FileWriter fw = new FileWriter(f);
            BufferedWriter bfw = new BufferedWriter(fw)){
            bfw.write("ACVSDGERT");
            bfw.newLine();
            bfw.write("ásadásdfaádfrefó");
            bfw.newLine();
            bfw.write("Fin del fichero");
        } catch (IOException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
}
