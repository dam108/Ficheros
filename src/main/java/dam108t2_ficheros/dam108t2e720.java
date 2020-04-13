/* Realizar un programa que inserte en un ArrayList 5 elementos de tipo _MovilPrepago pero solo
   solicitando al usuario el número de móvil, ya que el resto de parámetros los tomará del fichero obtenido
   en el ejercicio anterior, valores iguales para todos los móviles. Finalmente mostrará la suma del saldo de
   los 5 móviles
*/
package dam108t2_ficheros;

import java.io.*;
import java.util.*;

public class dam108t2e720 {
    public static ArrayList <MovilPrepago> moviles;
    public static Scanner teclado = new Scanner(System.in);
    public static String numero, costeEstablecLlamada, costeMinutoLlamada, costeConsumoMB, saldo;
    public static void main(String[] args) {
        moviles = new ArrayList<>();
        leerConf("movilConf.props");
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Introduce el numero del movil: ");
            numero = teclado.nextLine();
            moviles.add(new MovilPrepago(Long.valueOf(numero), Float.valueOf(costeEstablecLlamada), Float.valueOf(costeMinutoLlamada), Float.valueOf(costeConsumoMB), Float.valueOf(saldo)));
        }
        
        float total = 0;
        for (int i = 0; i < moviles.size(); i++) {
            total += moviles.get(i).consultarSaldo();
        }
        
        System.out.println("La suma del saldo de los 5 moviles es: "+total);
    }
    
        public static void leerConf(String archivo){
        Properties config = new Properties();
        try {
            config.load(new FileInputStream("archivos\\"+archivo));
            costeEstablecLlamada = config.getProperty("Coste_establecimiento_de_llamada");
            costeMinutoLlamada = config.getProperty("Coste_minuto_de_llamada");
            costeConsumoMB = config.getProperty("Coste_MegaByte");
            saldo = config.getProperty("Saldo");
        }
        catch (FileNotFoundException e){System.out.println("No existe el archivo");}
        catch (IOException ioe){ioe.printStackTrace();}
    }
    
}
