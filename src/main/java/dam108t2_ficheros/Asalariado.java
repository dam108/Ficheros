package dam108t2_ficheros;

public class Asalariado extends Trabajador{
    private float salarioFinal;
    private float horasExtra;
    
    Asalariado(int id, String nombre, String fechaNac, float salarioBase){
        super(id, nombre, fechaNac, salarioBase);
        this.horasExtra = 0;
        this.salarioFinal = salarioBase;
    }

    public float getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(float horasExtra) {
        this.horasExtra = horasExtra;
    }
    
    public void calcularSalarioFinal(float precioHoraExtra){
        if (this.horasExtra > 0 ){
            this.salarioFinal =  super.getSalarioBase() + (this.horasExtra * precioHoraExtra);
        }
    }
    
    public float getSalarioFinal (){
        return this.salarioFinal;
    }
    
    public void setSalarioFinal(float salario){
        this.salarioFinal = salario;
    }
    
     @Override
    public String toString() {
        return "Trabajador{" + "id=" + super.getId() + ", nombre=" + super.getNombre() + ", fechaNac=" + super.getFechaNac() + ", salarioBase=" + super.getSalarioBase() +", Salario Final= "+ this.getSalarioFinal()+'}';
    }
    
}
