package dam108t2_ficheros;

public class MovilPrepago {
    public long numeroMovil;
    private float costeEstablecLlamada;
    private float costeMinutoLlamada ;
    private float costeConsumoMB;
    private float saldo;

    MovilPrepago (long nM, float cEL, float cML, float cMB, float s) {
        numeroMovil = nM;
        costeEstablecLlamada = cEL;
        costeMinutoLlamada = cML;
        costeConsumoMB = cMB;
        saldo =s;
    }    

    @Override
    public String toString() {
        return "MovilPrepago{" + "numeroMovil=" + numeroMovil + ", saldo=" + saldo + '}';
    }
    
    public void efectuarLlamada (int segundos) {
          saldo -= Math.round(costeEstablecLlamada +
                               costeMinutoLlamada /60f * segundos * 100f)/100f; 
          if (saldo < 0) saldo = 0;
    }
    public void navegar (int mb) {
          saldo -= Math.round(costeConsumoMB* mb * 100f) / 100f;
          if (saldo < 0) saldo = 0;
    }
    public boolean recargar (int importe) {
          if (importe % 5 == 0) {
             saldo += importe;
             return true;
          }
          else return false;
    }
    public float consultarSaldo () {
          return saldo;
    }
    public void setSaldo(float importe){
        this.saldo = importe;
    }

    public float getCosteEstablecLlamada() {
        return costeEstablecLlamada;
    }

    public void setCosteEstablecLlamada(float costeEstablecLlamada) {
        this.costeEstablecLlamada = costeEstablecLlamada;
    }

    public float getCosteMinutoLlamada() {
        return costeMinutoLlamada;
    }

    public void setCosteMinutoLlamada(float costeMinutoLlamada) {
        this.costeMinutoLlamada = costeMinutoLlamada;
    }

    public float getCosteConsumoMB() {
        return costeConsumoMB;
    }

    public void setCosteConsumoMB(float costeConsumoMB) {
        this.costeConsumoMB = costeConsumoMB;
    }
} //fin clase