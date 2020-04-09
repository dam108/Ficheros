package dam108t2_ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class dam108t2e708 {
    public static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        
        guardarDatosEnCSV();
        
    }
    
    public static void guardarDatosEnCSV(){
        String nombre = " ";
        String fecha;
        double nota1,nota2,nota3;
    
        try ( BufferedWriter btw = new BufferedWriter(new FileWriter("archivos\\alumnos.csv"))){
            
            while(!nombre.equals("z")){
            
                System.out.println("introduce un nombre");nombre = teclado.nextLine();
                if ( !nombre.equals("z")){
                    System.out.println("Introduce una fecha"); fecha = teclado.nextLine();
                    System.out.println("Introduce la nota de la primera evaluacion"); nota1 = teclado.nextDouble();
                    System.out.println("Introduce la nota de la segunda evaluacion"); nota2 = teclado.nextDouble();
                    System.out.println("Introduce la nota de la tercera evaluacion"); nota3 = teclado.nextDouble();teclado.nextLine();
                    btw.write(nombre);btw.write(";");
                    btw.write(fecha);btw.write(";");
                    btw.write(String.valueOf(nota1));btw.write(";");
                    btw.write(String.valueOf(nota2));btw.write(";");
                    btw.write(String.valueOf(nota3));
                    btw.newLine();

                }
            }
        }catch(IOException ex){
            System.out.println("Error: "+ex.getMessage());
        }

    }
}
