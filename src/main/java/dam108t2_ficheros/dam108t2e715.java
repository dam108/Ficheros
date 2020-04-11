//Busca por Internet que valores deben de tener los primeros bytes (cabecera) de los archivos BMP
//y JPG para ser identificados como tal. Implementa un método con nombre comprobarTipoArchivo () que
//devuelva un booleano y al que se le pasará como parámetro un nombre de fichero con ruta y el tipo a
//comprobar (jpg ó bmp). El método deberá comprobar si el valor del campo de la cabecera que identifica
//al tipo de archivo coincide con el del archivo. Si es así devolverá true, en caso contrario devolverá false.
//Pista: Para comparar valores hexadecimales, hacer casting. Ej: if ( varByte1 ==(byte)0x42) …
package dam108t2_ficheros;

import java.io.*;
import java.util.Scanner;

public class dam108t2e715 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String separador = System.getProperty("file.separator");
        System.out.println("Intruduce la carpeta del archivo");
        String carpeta = teclado.nextLine();
        System.out.println("Intruduce el nombre del archivo");
        String archivo = teclado.nextLine();
        System.out.println("Intruduce el tipo de archivo contra el que lo quieres comparar");
        String tipoArchivo = teclado.nextLine();
        
        boolean comprobacion = comprobarTipoArchivo((carpeta+separador+separador+archivo), tipoArchivo);
        if(comprobacion) System.out.println("El archivo "+archivo+" es un tipo "+tipoArchivo);
        else System.out.println("El archivo "+archivo+" no es del tipo "+tipoArchivo);
    }
    
    
    public static boolean comprobarTipoArchivo(String ru, String tipo){
        boolean eof = false;
        try(FileInputStream fis = new FileInputStream(ru);
            BufferedInputStream bfis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bfis);) {
            
            if (tipo.equals("bmp")){
                byte bmp[] = new byte[] {(byte)0x42, (byte)0x4D};
                for (int i = 0; i < bmp.length; i++) {
                    if(bmp[i] != dis.read()  ) return false;
                    
                }
                return true;
            }
            else if (tipo.equals("jpg")){
                int jpg[] = new int[] {(int)0xFF, (int)0xD8, (int)0xFF};
                for (int i = 0; i < jpg.length; i++) {
                    if(jpg[i] != dis.read()) return false;
                }
                return true;
            }
            else{
                System.out.println("Tipo de archivo no valido");
                return false;
            }

        }
        catch(EOFException e){eof = true;}
        catch(IOException ex){System.err.printf("%nError:%s", ex.getMessage());}
        catch(Exception ex){System.err.printf("%nError:%s", ex.getMessage());}
        return false;
    }
}