package dam108t2_ficheros;

public class ConsultorExterno extends Trabajador {
    private float horasTrabajadas;
    private float salarioFinal;
    
    ConsultorExterno(int id, String nombre, String fechaNac){
        super(id, nombre, fechaNac, 0);
        this.horasTrabajadas = 0;
        this.salarioFinal = 0;
    }


    public float getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(float horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    
    public void calcularSalarioFinal(float precioHoraTrabajada){
        if (this.horasTrabajadas > 0 ){
            this.salarioFinal = (this.horasTrabajadas * precioHoraTrabajada);
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
