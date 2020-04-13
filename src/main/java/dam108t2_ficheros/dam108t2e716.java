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
        int dia, mes;
        
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