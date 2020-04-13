/*
Realizar un programa que lea un archivo como el del ejercicio anterior y muestre por pantalla su
contenido. Además, introducirá los objetos leídos en un ArrayList de tipo Trabajadores
*/

package dam108t2_ficheros;

import java.io.*;
import java.util.ArrayList;

public class dam108t2e718 {
    public static ArrayList <Trabajador> trabajadores;
    public static void main(String[] args) {
        boolean eof = false;
        
        try( FileInputStream fis = new FileInputStream("archivos\\fich17.dat");
             BufferedInputStream bfis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bfis)) {
            
            while(!eof){
                Object obj = ois.readObject();
                System.out.println(obj.getClass());
                
                if (obj instanceof ConsultorExterno){
                    System.out.println((ConsultorExterno) ois.readObject());
                    trabajadores.add((ConsultorExterno) ois.readObject());
                }
                if (obj instanceof Asalariado){
                    System.out.println((ConsultorExterno) ois.readObject());
                    trabajadores.add((ConsultorExterno) ois.readObject());
                }
                if (obj instanceof Trabajador){
                    System.out.println((Trabajador) ois.readObject());
                    trabajadores.add((Trabajador) ois.readObject());
                }
            }
            
        }
        catch (EOFException e) {
            eof = true;
            System.out.println(trabajadores);
        } 
        catch (ClassNotFoundException ex) {
            System.err.printf("%nError: ",ex.getMessage());
        } 
        catch (IOException ex){
            System.err.printf("%nError: ",ex.getMessage());
        }
    }
    
}
