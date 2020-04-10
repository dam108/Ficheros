/*
Realizar un programa que lea el fichero del ejercicio anterior línea a línea y finalmente muestre la
cantidad de alumnos que tienen una nota final >=5 y el nombre del alumno con mejor nota. (La notaProgramación (2019/2020) - Libro de Ejercicios Bloque 2B - Ficheros
Fernando Rodríguez Diéguez - IES Fernando Wirtz Pág. 15
final no tiene decimales y se calcula redondeando un 20% de la primera evaluación más un 30% de la
segunda más 50% de la tercera).
*/

package dam108t2_ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class dam108t2e710 {
    public static void main(String[] args) {
        File f = new File("archivos\\alumnos.txt");
        ArrayList<Alumnos> al = new ArrayList<>();
        String cadena, nombre,fecha, sNota1,sNota2,sNota3;
        double nota1,nota2,nota3;
        try (FileReader fr = new FileReader(f);
                BufferedReader bfr = new BufferedReader(fr)) {
                
            while((cadena=bfr.readLine()) != null){
                System.out.printf("%s\n", cadena);

                nombre = cadena.trim(); // sacamos lo que hay escrito sin espacios
                fecha = cadena.substring(100, 108); // sacamos lo que hay desde el caracter 100 al 108
                sNota1= cadena.substring(108, 113).replace(",", "."); // sacamos lo que hay desde 108 al 113 cambiamod las comas por puntos
                sNota2= cadena.substring(113, 118).replace(",", ".");
                sNota3= cadena.substring(118, 123).replace(",", ".");

                nota1 = Double.parseDouble(sNota1);
                nota2 = Double.parseDouble(sNota2);
                nota3 = Double.parseDouble(sNota3);
                
                al.add(new Alumnos(nombre, fecha, nota1, nota2, nota3));
            }
            
            // apartir de aqui trabajamos con los objetos
            int cont=0; int n=0;
            double mayor=0;
            for (int i = 0; i < al.size(); i++) {
                if(al.get(i).calcularNotaFinal() >= 5) cont++;
                if(al.get(i).calcularNotaFinal() > mayor) {
                    mayor = al.get(i).calcularNotaFinal();
                    n = i;
                }
            }
            System.out.printf("Hay %d alumnos que tienen una nota mayor que 5\n",cont);
            System.out.printf("El alumno con la mejor nota es %s\n", al.get(n).nombre);

        }
        catch (IOException ex){
            System.out.printf(" Error:%s\n", ex.getMessage() );
        }
    }
}
