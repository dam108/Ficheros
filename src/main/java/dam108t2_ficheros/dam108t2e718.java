package dam108t2_ficheros;

import java.io.*;
import java.util.ArrayList;

public class dam108t2e718 {
    public static ArrayList <Trabajador> trabajadores;
    public static void main(String[] args) {
        boolean eof = false;
        trabajadores = new ArrayList<>();
        try( FileInputStream fis = new FileInputStream("archivos\\fich17.dat");
             BufferedInputStream bfis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bfis)) {
            
            while(!eof){
                Object obj = ois.readObject();
                System.out.println(obj.getClass());
                
                if (obj instanceof ConsultorExterno){
                    System.out.println((ConsultorExterno) obj);
                    trabajadores.add((ConsultorExterno)obj);
                }
                if (obj instanceof Asalariado){
                    System.out.println((Asalariado) obj);
                    trabajadores.add((Asalariado) obj);
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