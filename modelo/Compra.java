package modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Compra implements Comparable<Compra>{

    private String descricaoCompra;
    private BigDecimal valorCompra;

    public Compra(String descricaoCompra, BigDecimal valorCompra) {
        setDescricaoCompra(descricaoCompra);
        setValorCompra(valorCompra);
    }

    public Compra() {

    }

    public void setDescricaoCompra(String descricaoCompra) {
        if (!descricaoCompra.isBlank()){
            this.descricaoCompra = descricaoCompra;
        }else{
            throw new IllegalArgumentException("Precisa da descrição da compra");
        }
    }

    public void setValorCompra(BigDecimal valorCompra) {
        if (valorCompra.compareTo(BigDecimal.ZERO) >= 0){
            this.valorCompra = valorCompra.setScale(2, RoundingMode.UNNECESSARY);
        } else {
            throw new IllegalArgumentException("O valor da compra não pode ser negativo!");
        }
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    @Override
    public String toString() {
        return descricaoCompra + " - " + valorCompra;
    }

    @Override
    public int compareTo(Compra compra) {
        return this.getValorCompra().compareTo(compra.getValorCompra());
    }
}
