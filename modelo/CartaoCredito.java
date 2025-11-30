package modelo;

import java.math.BigDecimal;

public class CartaoCredito {
    private BigDecimal limiteDisponivel;

    public CartaoCredito(BigDecimal limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
    }

    public void calcularLimite(BigDecimal valorGasto){
        limiteDisponivel = limiteDisponivel.subtract(valorGasto);
    }

    // TODO: Implementar o validador do limite do cartão de crédito, não pode ser negativo
//    public void validaLimite(){

//    }



    @Override
    public String toString() {
        return String.valueOf(limiteDisponivel);
    }
}
