/*
Realizar un programa que guarde un fichero similar al de las temperaturas del ejercicio 7.12 con las
temperaturas de todo un año (generar valores al azar para la temperatura, una temperatura por día, con
valores entre 0 y 40 y la fecha en formato YYYYMMDD). El año puede ser una constante con valor 2020. A
continuación, se solicitará un día y mes del año al usuario y se obtendrá con acceso aleatorio (no
secuencial) la temperatura de ese día. Pista: Recordar que las cadenas guardan su longitud en 2 Bytes antes
de los caracteres
*/

package dam108t2_ficheros;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class dam108t2e716 {
    public static final int year = 2020;
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int dia, mes, opcion = 0;
        
        guardarTemperaturas(); //generamos las temperaturas al azar
        
            
        System.out.println("Introduce un dia");
        dia = teclado.nextInt();
        System.out.println("Introduce un mes");
        mes = teclado.nextInt();

        recuperarTemperatura(dia, mes);
       
        
    }
    
    public static void guardarTemperaturas(){
        LocalDate fec = LocalDate.parse("2020-01-01");
        
        try(RandomAccessFile raf = new RandomAccessFile("archivos\\fich16.dat", "rw")){
            
            do {
                if(fec.getYear() == year){
                    int temp = (int)(Math.random()*41);
                    raf.seek(raf.length());
                    String sFec = fec.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                    raf.write(String.format("%8s",sFec).substring(0, 8).getBytes());
                    raf.writeInt(temp);
                    fec = fec.plusDays(1);
                }
                
            }while(fec.getYear()== year);
            
        }catch(IOException ex){
            System.err.printf("%nError:%s\n", ex.getMessage());
             
        }
        
    }
    public static void recuperarTemperatura(int dia, int mes){
        LocalDate fec = LocalDate.of(year,mes,dia);
        int TAMR = 12; // dos bytes + 8 bytes de la fecha + 4 bytes del int
        int pos = Math.abs( (int) ChronoUnit.DAYS.between(fec, LocalDate.parse("2020-01-01")));
        System.out.println(pos);
        try(RandomAccessFile raf = new RandomAccessFile("archivos\\fich16.dat", "r")){
            raf.seek(pos * TAMR);
            byte[] modeloArray = new byte[8];
            raf.read(modeloArray);
//            String fecha = new String (modeloArray);
//            System.out.println(modeloArray);
//            System.out.println(fecha);
            System.out.printf("La temperatura de la fecha %s fue %d\n",fec.toString(),raf.readInt());
            
        }catch(IOException ex){System.err.printf("%nError:%s\n", ex.getMessage());}

    }
}
 
/*
 Realizar un programa que guarde un fichero similar al de las temperaturas del ejercicio 7.12 con las
temperaturas de todo un año (generar valores al azar para la temperatura, una temperatura por día, con
valores entre 0 y 40 y la fecha en formato YYYYMMDD). El año puede ser una constante con valor 2020. A
continuación, se solicitará un día y mes del año al usuario y se obtendrá con acceso aleatorio (no
secuencial) la temperatura de ese día. Pista: Recordar que las cadenas guardan su longitud en 2 Bytes antes
de los caracteres
 */
/*
package dam108t2_ficheros;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import java.util.Scanner;

public class dam108t2e716 {

    static String separador = System.getProperty("file.separator");
    static String ruta = "." + separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "temps.dat";
    static final int anio = 2020;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        LocalDate fecha = LocalDate.of(anio, 1, 1);
        escribirTemp(fecha);
        
        
        System.out.println("Dime mes: ");
        int mes = teclado.nextInt();
        
        System.out.println("Dime dia: ");
        int dia = teclado.nextInt();
       
        teclado.nextLine();
        leerTemp(LocalDate.of(anio, mes, dia));
    }

    public static void escribirTemp(LocalDate fecha) {
        try (RandomAccessFile raf = new RandomAccessFile("archivos\\fich16.dat", "rw");) {
            do {
                if (fecha.getYear() == anio) {
                    raf.seek(raf.length());
                    String fechaS = fecha.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                    raf.write(String.format("%8s",fechaS).substring(0,8).getBytes()); 
                    //raf.writeUTF(fechaS);
                    raf.writeInt((int) (Math.random() * 41));
                    fecha = fecha.plusDays(1);
                }
            } while (fecha.getYear() == anio);
        } catch (IOException ex) {
            System.err.printf("%nError:%s", ex.getMessage());
        }
    }

    public static void leerTemp(LocalDate fecha) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        int pos = (int)ChronoUnit.DAYS.between(LocalDate.of(anio, 1, 1), fecha);
        int TAM_REGISTRO = 12;
        try (RandomAccessFile raf = new RandomAccessFile("archivos\\fich16.dat", "r");) {
            raf.seek(pos * TAM_REGISTRO);
            byte[] modeloArray = new byte[8];
            raf.read(modeloArray);
            String nombre = new String(modeloArray);
            System.out.println("Dia: " +  LocalDate.parse(nombre.trim(), DateTimeFormatter.ofPattern("yyyyMMdd")));
            System.out.println("Temperatura: " + raf.readInt() + " ºC");
        } catch (IOException ex) {
            System.err.printf("%nError:%s", ex.getMessage());
        }
    }

}
*/