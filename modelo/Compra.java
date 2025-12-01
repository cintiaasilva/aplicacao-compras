package modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Compra {

    private String descricaoCompra;
    private BigDecimal valorCompra;

    public Compra(String descricaoCompra, BigDecimal valorCompra) {
        this.descricaoCompra = descricaoCompra;
        setValorCompra(valorCompra);
    }

    @Override
    public String toString() {
        return descricaoCompra + ", " + valorCompra;
    }

    public void setDescricaoCompra(String descricaoCompra) {
        this.descricaoCompra = descricaoCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        if (valorCompra.compareTo(BigDecimal.ZERO) >= 0){
            this.valorCompra = valorCompra.setScale(2, RoundingMode.UNNECESSARY);
        } else {
            throw new IllegalArgumentException("O valor da compra não pode ser negativo!");
        }
    }

    public String getDescricaoCompra() {
        return descricaoCompra;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }
}
