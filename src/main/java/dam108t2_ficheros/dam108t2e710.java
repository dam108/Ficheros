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
        String cadena;
        String nota1 ="",nota2="",nota3="", nombre="",fecha="";
        try (FileReader fr = new FileReader(f);
                BufferedReader bfr = new BufferedReader(fr)) {
                
            while((cadena=bfr.readLine()) != null){
                System.out.printf("%s\n", cadena);
                for (int i = 0; i < 100; i++) {
                    if( cadena.charAt(i)!= ' ' ){
                        nombre = nombre+cadena.charAt(i);
                    }
                }
                for (int i = 100; i < 108; i++) {
                    fecha = fecha+cadena.charAt(i);
                }
                for (int i = 108; i < 113; i++) {
                    if( cadena.charAt(i) == ',' ){
                        nota1 = nota1 + '.';
                    } else nota1 = nota1+cadena.charAt(i);
                }
                for (int i = 113; i < 118; i++) {
                    if( cadena.charAt(i) == ',' ){
                        nota2 = nota2 + '.';
                    } else nota2 = nota2+cadena.charAt(i);
                }
                for (int i = 118; i < 123; i++) {
                    if( cadena.charAt(i) == ',' ){
                        nota3 = nota3 + '.';
                    } else nota3 = nota3+cadena.charAt(i);
                }
                double sNota1 = Double.parseDouble(nota1);
                double sNota2 = Double.parseDouble(nota2);
                double sNota3 = Double.parseDouble(nota3);
                
                al.add(new Alumnos(nombre, fecha, sNota1, sNota2, sNota3));
                nota1 = "";nota2 = ""; nota3="";nombre="";fecha="";
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
 
//            for (int i = 0; i < al.size(); i++) {
//                System.out.println(al.get(i).nombre);
//                System.out.println(al.get(i).fecha);
//            }
        }
        catch (IOException ex){
            System.out.printf(" Error:%s\n", ex.getMessage() );
        }
    }
}
