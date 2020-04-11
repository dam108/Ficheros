//Realizar un programa que muestre las parejas de temperatura-fecha/hora del ejercicio anterior.
package dam108t2_ficheros;

import java.io.*;
import java.util.Scanner;

public class dam108t2e713 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean eof = false;
        try (FileInputStream fis = new FileInputStream("archivos\\fich12.dat");
                BufferedInputStream bfis = new BufferedInputStream(fis);
                DataInputStream dis = new DataInputStream(bfis)) {
            while (!eof){
                float temp = dis.readFloat();
                String fec = dis.readUTF();
                System.out.printf("La temperatura fue %.2f en la fecha %s\n", temp, fec);
            }
        }
        catch (EOFException e){eof = true;}
        catch (IOException ex) {System.err.printf("%nError:%s", ex.getMessage());}
        catch (Exception ex) {System.err.printf("%nError:%s", ex.getMessage());}
    }
}