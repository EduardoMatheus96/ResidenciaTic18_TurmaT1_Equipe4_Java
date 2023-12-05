
import java.util.Date;

public class Pagamento {
    private Date data;
    private double valor;
    private Reembolso reembolso;
    
    public Pagamento(double  valor){
        data =  new Date();
        this.valor =  valor;
    }

    public void geraReembolso(double valor){
        reembolso = new Reembolso(valor);
    }

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public Reembolso getReembolso() {
        return reembolso;
    }
}
