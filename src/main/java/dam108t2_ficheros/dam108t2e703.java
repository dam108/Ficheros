package dam108t2_ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class dam108t2e703 {

    public static void main(String[] args) {
        File f = new File("archivos\\fich03.txt");
        try(FileOutputStream fos = new FileOutputStream(f, true);
            OutputStreamWriter osw = new OutputStreamWriter (fos, "ISO-8859-1");
            BufferedWriter bfw = new BufferedWriter(osw)){
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
