package modelo;

import java.math.BigDecimal;

public class Compra {

    private String descricaoCompra;
    private BigDecimal valorCompra;

    public Compra(String descricaoCompra, BigDecimal valorCompra) {
        this.descricaoCompra = descricaoCompra;
        this.valorCompra = valorCompra;
    }

    @Override
    public String toString() {
        return descricaoCompra + ", " + valorCompra;
    }


    //TODO: Implementar a validação de valor da compra, não pode ser negativo ou 0
}
