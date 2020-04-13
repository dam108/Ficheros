package dam108t2_ficheros;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class dam108t2e712 {
    public static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        float temp = 0;
        try(FileOutputStream fis = new FileOutputStream("archivos\\fich12.dat",true);
            BufferedOutputStream bfos = new BufferedOutputStream(fis);
            DataOutputStream dos = new DataOutputStream(bfos); ){
            
            while(temp != -999){
                System.out.println("Introduce una temperatura");
                temp = teclado.nextFloat();
                
                if (temp != -999){
                    String fec = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss"));
                    dos.writeFloat(temp);
                    dos.writeUTF(fec);
                   }
            }
        }
        catch (IOException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
}