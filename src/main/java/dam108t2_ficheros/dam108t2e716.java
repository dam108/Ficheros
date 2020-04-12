/*
Realizar un programa que guarde un fichero similar al de las temperaturas del ejercicio 7.12 con las
temperaturas de todo un año (generar valores al azar para la temperatura, una temperatura por día, con
valores entre 0 y 40 y la fecha en formato YYYYMMDD). El año puede ser una constante con valor 2020. A
continuación, se solicitará un día y mes del año al usuario y se obtendrá con acceso aleatorio (no
secuencial) la temperatura de ese día. Pista: Recordar que las cadenas guardan su longitud en 2 Bytes antes
de los caracteres
*/
package dam108t2_ficheros;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class dam108t2e716 {
    public static final int year = 2020;
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int dia, mes, opcion = 0;
        
        guardarTemperaturas(); //generamos las temperaturas al azar
        
        do {
            System.out.println("1. Recuperar una temperatura");
            System.out.println("2 Salir");
            opcion = teclado.nextInt();
            
            if (opcion != 2){
                System.out.println("Introduce un dia");
                dia = teclado.nextInt();
                System.out.println("Introduce un mes");
                mes = teclado.nextInt();

                switch(opcion){
                    case 1: recuperarTemperatura(dia, mes);break;
                }
            }
            
            
            
        }while(opcion != 2);
       
        
    }
    
    public static void guardarTemperaturas(){
        LocalDate fec = LocalDate.parse("2020-01-01");
        
        try(RandomAccessFile raf = new RandomAccessFile("archivos\\fich16.dat", "rw")){
            
            while(fec.getYear()== year){
                int temp = (int)(Math.random()*41);
                String sFec = fec.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                raf.seek(raf.length());
                raf.write(String.format("%8s",sFec).substring(0, 8).getBytes());
                raf.writeInt(temp);
                fec = fec.plusDays(1);
                System.out.println(temp);
            }
            
        }catch(IOException ex){
            System.err.printf("%nError:%s\n", ex.getMessage());
             
        }
        
    }
    public static void recuperarTemperatura(int dia, int mes){
        LocalDate fec = LocalDate.of(year,mes,dia);
        int TAMR = 14; // dos bytes + 8 bytes de la fecha + 4 bytes del int
        int pos = Math.abs( (int) ChronoUnit.DAYS.between(fec, LocalDate.parse("2020-01-01")));
        System.out.println(pos);
        try(RandomAccessFile raf = new RandomAccessFile("archivos\\fich16.dat", "r")){
            raf.seek((pos)*TAMR);
            byte[] modeloArray = new byte[8];
            System.out.println(raf.read(modeloArray));
            int temp = raf.readInt();
            System.out.printf("La temperatura de la fecha %s fue %d\n",fec.toString(),temp);
            
        }catch(IOException ex){System.err.printf("%nError:%s\n", ex.getMessage());}

    }
}
 