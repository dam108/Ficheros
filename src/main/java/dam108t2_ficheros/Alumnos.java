package dam108t2_ficheros;

import java.util.ArrayList;

public class Alumnos {
    public String nombre;
    public String fecha;
    public ArrayList<Double> notas;
    
    Alumnos(String nombre, String fecha, double nota1, double nota2, double nota3){
        this.nombre = nombre;
        this.fecha = fecha;
        notas = new ArrayList();
        notas.add(nota1);notas.add(nota2);notas.add(nota3);
    }
    
    public double calcularNotaFinal(){
        double n;
        double nota1, nota2, nota3;
        nota1 = notas.get(0)* 0.20;
        nota2 = notas.get(1)* 0.30;
        nota3 = notas.get(2)* 0.50;
        
        n = nota1 + nota2 + nota3;
        return n;
    }
}
