package dam108t2_ficheros;

import java.io.FileWriter;
import java.io.IOException;

public class pruebas {

    public static void main(String[] args) {
        try{
            FileWriter fw = new FileWriter("archivos\\fich04.txt", false);
            fw.write("prueba"+"\n");
            fw.write("prueba"+"\n");
            fw.write("prueba"+"\n");
            fw.write("prueba"+"\n");
            fw.write("prueba"+"\n");
            
        }    
        catch (IOException ex){
            System.err.printf("Error: %s ",ex.getMessage());
        }        
    }
}
