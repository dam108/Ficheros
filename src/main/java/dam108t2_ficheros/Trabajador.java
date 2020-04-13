package dam108t2_ficheros;

import java.io.Serializable;

public class Trabajador implements Serializable {
    private int id;
    private String nombre;
    private String fechaNac;
    private float salarioBase;

    public Trabajador(int id, String nombre, String fechaNac, float salarioBase) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.salarioBase = salarioBase;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trabajador other = (Trabajador) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "id=" + id + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", salarioBase=" + salarioBase + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }
    
    
    
}
