/*
Realizar un programa que cree un fichero de tipo Properties que contenga los parámetros globales
de un _MovilPrepago a partir de los valores que introduzca el usuario. Si el fichero existe, al solicitar al
usuario cada valor, le informará del valor actual09
*/
package dam108t2_ficheros;

import java.io.*;
import java.util.*;

public class dam108t2e719 {
    public static Scanner teclado = new Scanner(System.in);
    public static String numero, costeEstablecLlamada, costeMinutoLlamada, costeConsumoMB, saldo;
    public static void main(String[] args) {
        //pedir valores
        pedirValores();
        //creamos archivo de configuracion del movil
        crearConf(Long.valueOf(numero), Float.valueOf(costeEstablecLlamada), Float.valueOf(costeMinutoLlamada), Float.valueOf(costeConsumoMB), Float.valueOf(saldo));
        File f = new File("archivos\\movilConf.props");
        if (f.exists()){
            leerConf("movilConf.props");
        }
        pedirValores();
        crearConf(Long.valueOf(numero), Float.valueOf(costeEstablecLlamada), Float.valueOf(costeMinutoLlamada), Float.valueOf(costeConsumoMB), Float.valueOf(saldo));
        
        leerConf("movilConf.props");

    }
    
   public static void pedirValores(){
       System.out.println("Introduce el numero: ");
       numero = teclado.nextLine();
       System.out.println("Introduce el coste del establecimiento de llamada: ");
       costeEstablecLlamada = teclado.nextLine();
       System.out.println("Introduce el coste del minuto: ");
       costeMinutoLlamada = teclado.nextLine();
       System.out.println("Introduce el coste del consumo de Megas: ");
       costeConsumoMB = teclado.nextLine();
       System.out.println("Introduce el saldo: ");
       saldo = teclado.nextLine();
   }
            
    
    public static void crearConf(long nM, float cEL, float cML, float cMB, float s){
        Properties config = new Properties();
        config.setProperty("numero_de_telefono", String.valueOf(nM));
        config.setProperty("Coste_establecimiento_de_llamada", String.valueOf(cEL));
        config.setProperty("Coste_minuto_de_llamada", String.valueOf(cML));
        config.setProperty("Coste_MegaByte", String.valueOf(cMB));
        config.setProperty("Saldo", String.valueOf(s));
        try{config.store(new FileOutputStream("archivos\\movilConf.props"), "Fichero de configuración movil prepago");}
        catch (IOException ioe) {ioe.printStackTrace();}
    }
    
    public static void leerConf(String archivo){
        Properties config = new Properties();
        try {
            config.load(new FileInputStream("archivos\\"+archivo));
            numero = config.getProperty("numero_de_telefono");
            costeEstablecLlamada = config.getProperty("Coste_establecimiento_de_llamada");
            costeMinutoLlamada = config.getProperty("Coste_minuto_de_llamada");
            costeConsumoMB = config.getProperty("Coste_MegaByte");
            saldo = config.getProperty("Saldo");
            System.out.println("Los datos que hay el archivo de configuracion son: ");
            System.out.printf("Numero de telefono: %s\nCoste de establecimiento de llamada: %s\n"
                    + "Coste del minuto: %s\nCoste del MegaByte: %s\nSaldo: %s\n",numero, costeEstablecLlamada, costeMinutoLlamada, costeConsumoMB, saldo);
        }
        catch (FileNotFoundException e){System.out.println("No existe el archivo");}
        catch (IOException ioe){ioe.printStackTrace();}
    }
}
