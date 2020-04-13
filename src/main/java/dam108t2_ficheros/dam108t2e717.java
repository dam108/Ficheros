/*
Realizar un programa que cree un ArrayList de 5 Trabajadores (pueden ser Asalariados o
ConsultoresExternos). Inserta objetos de ambas clases con unos valores cualesquiera “a mano”. A
continuación, guarda los objetos serializados en un archivo llamado fich17.dat. Copia ambas clases de
ejercicios anteriores y su superclase (añadiendo _v2 a su nombre) para adaptarlas a este ejercicio. Pista: La
superclase debe implementar Serializable
*/
package dam108t2_ficheros;
import java.io.*;
import java.util.ArrayList;

public class dam108t2e717 {
    public static ArrayList <Trabajador> trabajadores;
    public static void main(String[] args) {
        trabajadores = new ArrayList<>();
        //creamos 5 trabajadores y los guardamos en el arrayList
        trabajadores.add(new ConsultorExterno(01,"Juan","1980-05-16"));
        trabajadores.add(new ConsultorExterno(02,"Jose","1986-11-08"));
        trabajadores.add(new ConsultorExterno(03,"Carmen","1990-03-30"));
        trabajadores.add(new Asalariado(04, "Rodrigo","1987-02-01", 675.50f));
        trabajadores.add(new Asalariado(05, "Paula","1995-06-06", 1250.85f));

        
        try(FileOutputStream fos = new FileOutputStream("archivos\\fich17.dat",false);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos); ){
            
            for(int cont=0;cont <trabajadores.size();cont++){
                oos.writeObject(trabajadores.get(cont));
            }
            
        }
        catch(IOException ex){System.err.println("Error: "+ex.getMessage());}
        
    }
    
}
