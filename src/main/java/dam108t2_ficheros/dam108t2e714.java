package dam108t2_ficheros;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class dam108t2e714 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean eof = false;
        double total=0; int cont = 0;
        try(FileInputStream fis = new FileInputStream("archivos\\fich12.dat");
            BufferedInputStream bfis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bfis)) {
            
            System.out.println("Introduce la fecha de incio (yyyy-MM-dd)"); String sFi = teclado.nextLine();
            System.out.println("Introduce la fecha de fin (yyyy-MM-dd)"); String sFf = teclado.nextLine();
            LocalDate fi = LocalDate.parse(sFi); LocalDate ff = LocalDate.parse(sFf);
            
            while(!eof){
                float temp = dis.readFloat();
                String fec = dis.readUTF();
                LocalDate fecMomentanea = LocalDateTime.parse(fec, DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss")).toLocalDate();
                if (fecMomentanea.isAfter(fi) && fecMomentanea.isBefore(ff) ){
                    total += temp; cont++;
                }
                else System.out.println("No hay temperaturas entre esas fechas");
            }
            System.out.println("salimos del while");
            System.out.println("total: "+total);
            System.out.println("contador: "+cont);
            System.out.println("La media de las temperaturas entre esas fechas es "+total/cont);       
            
        }
        catch (EOFException e){ 
//            System.out.println("salimos del while");
//            System.out.println("total: "+total);
//            System.out.println("contador: "+cont);
            System.out.printf("La media de las temperaturas entre esas fechas es %.2f ", (total/cont)); 
            eof = true;
        }
        catch(IOException ex){System.err.printf("%nError:%s", ex.getMessage());}
        catch(Exception ex){System.err.printf("%nError:%s", ex.getMessage());}
    }
    
}
