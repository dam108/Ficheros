package dam108t2_ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class dam108t2e701 {

    public static void main(String[] args) {
        BufferedWriter bfw=null;
        try {
            File f = new File("archivos\\fich01.txt"); 
            FileWriter fw = new FileWriter(f);
            bfw = new BufferedWriter(fw);
            bfw.write("ACVSDGERT");
            bfw.newLine();
            bfw.write("ásadásdfaádfrefó");
            bfw.newLine();
            bfw.write("Fin del fichero");
        }catch (IOException ex){
            System.out.println("Error: "+ex.getMessage());
        } finally {
            try {
                if (bfw !=null) bfw.close();
            } catch (IOException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
}
