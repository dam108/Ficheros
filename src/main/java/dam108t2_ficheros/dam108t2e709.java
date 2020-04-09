package dam108t2_ficheros;

import static dam108t2_ficheros.dam108t2e708.teclado;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class dam108t2e709 {

    public static void main(String[] args) {
        guardarDatosEnTXT();
    }

    public static void guardarDatosEnTXT() {
        String nombre = " ";
        LocalDate fecha = null;
        float nota1, nota2, nota3;

        try(FileWriter fw = new FileWriter("archivos\\alumnos.txt"); BufferedWriter bfw = new BufferedWriter(fw); PrintWriter pw = new PrintWriter(bfw)){
            
            while (!nombre.equals("z")){
                System.out.println("Introduce un nombre");
                nombre = teclado.nextLine();
                if(!nombre.valueOf(nombre.charAt(0)).equals("z")){
                    
                    System.out.println("Introduce una fecha AAAA-MM-DD");
                    String sfecha = teclado.nextLine();
                    fecha = LocalDate.parse(sfecha);
                    sfecha = fecha.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                    System.out.println("Introduce la nota de la primera evaluación");
                    nota1 = teclado.nextFloat();
                    System.out.println("Introduce la nota de la segunda evaluación");
                    nota2 = teclado.nextFloat();
                    System.out.println("Introduce la nota de la tercera evaluación");
                    nota3 = teclado.nextFloat();
                    teclado.nextLine();
                    pw.printf("%-100s%s%05.2f%05.2f%05.2f%n", nombre,sfecha,nota1,nota2,nota3);
                    
                }
            }
            
        } catch (IOException ex) {System.out.printf("Error: %s", ex.getMessage());}

    }
}

/* esto funciona pero mejor lo de arriba */
//        String nombre = " ";
//        LocalDate fecha = null;
//        float nota1, nota2, nota3;
//
//        try ( PrintWriter pw = new PrintWriter("archivos\\alumnos.txt")) {
//
//            while (!nombre.equals("z")) {
//                System.out.println("introduce un nombre");
//                nombre = teclado.nextLine();
//                if (!nombre.valueOf(nombre.charAt(0)).equals("z")){
//                    System.out.println("Introduce una fecha");
//                    String sfecha = teclado.nextLine();
//                    System.out.println("Introduce la nota de la primera evaluacion");
//                    nota1 = teclado.nextFloat();
//                    System.out.println("Introduce la nota de la segunda evaluacion");
//                    nota2 = teclado.nextFloat();
//                    System.out.println("Introduce la nota de la tercera evaluacion");
//                    nota3 = teclado.nextFloat();
//                    teclado.nextLine();
//
//                    for (int i = 0; i < 100 - nombre.length(); i++) {
//                            nombre = nombre.concat(" ");
//                        }
//
//                    fecha = LocalDate.parse(sfecha);
//                    sfecha = fecha.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//                    pw.append(nombre.concat(";"));
//                    pw.append(sfecha.concat(";"));
//                    pw.printf("%.2f;", nota1);
//                    pw.printf("%.2f;", nota2);
//                    pw.printf("%.2f;", nota3);
//                    pw.println();
//                    
//                    
//                    
//                    nombre = nombre.valueOf(nombre.charAt(0));
//                }
//            }
//
//        } catch (IOException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
//}
