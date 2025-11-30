package servico;

import modelo.CartaoCredito;
import modelo.Compra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicandoCompra {
    Scanner entradaDados = new Scanner(System.in);
    CartaoCredito credito = new CartaoCredito(entradaDados.nextBigDecimal());
    Compra compra = new Compra(entradaDados.nextLine(), entradaDados.nextBigDecimal());
    List<Compra> compras = new ArrayList<>();
}
