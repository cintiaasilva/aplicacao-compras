package modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CartaoCredito {

    private BigDecimal limiteDisponivel;

    public CartaoCredito(BigDecimal limiteDisponivel) {
        setLimiteDisponivel(limiteDisponivel);
    }

    public void setLimiteDisponivel(BigDecimal limiteDisponivel) {
        if (limiteDisponivel.compareTo(BigDecimal.ZERO) >= 0){
            this.limiteDisponivel = limiteDisponivel.setScale(2, RoundingMode.UNNECESSARY);
        } else {
            throw new IllegalArgumentException("O valor do limite cartão não pode ser negativo!");
        }
    }

    public BigDecimal getLimiteDisponivel() {
        return limiteDisponivel;
    }

    @Override
    public String toString() {
        return String.valueOf(limiteDisponivel);
    }

    public void calcularLimite(BigDecimal valorGasto){
        limiteDisponivel = limiteDisponivel.subtract(valorGasto);
    }
}
