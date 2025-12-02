package servico;

import modelo.CartaoCredito;
import modelo.Compra;

import java.math.BigDecimal;
import java.util.*;

public class AplicandoCompra {
    Scanner entradaDados = new Scanner(System.in);
    StringBuilder msg = new StringBuilder();
    List<Compra> compras = new ArrayList<>();
    
    CartaoCredito credito;
    BigDecimal limiteAtualizado;


    public void listarCompras(){
        if (compras.isEmpty()){
            System.out.println("Digite o limite do cartão: ");
            credito = new CartaoCredito(entradaDados.nextBigDecimal());
            entradaDados.nextLine();

            Compra primeiraCompra = dadosDaCompra();

            if (credito.getLimiteDisponivel().compareTo(primeiraCompra.getValorCompra()) >= 0){
                adicionarCompraNaListaEOrdena(primeiraCompra);
                limiteAtualizado = atualizarLimite(primeiraCompra);
                System.out.println(retornarRespostas(0));
                menu();
            }

            else {
                System.out.println(retornarRespostas(2));
            }
        }else {
            entradaDados.nextLine();
            Compra proximasCompras = dadosDaCompra();
            if (limiteAtualizado.compareTo(proximasCompras.getValorCompra()) < 0){
                msg.delete(0,msg.length());
                System.out.println( retornarRespostas(2));
                System.out.println(retornarRespostas(1));
            }else {
                adicionarCompraNaListaEOrdena(proximasCompras);
                limiteAtualizado = atualizarLimite(proximasCompras);
                System.out.println(retornarRespostas(0));
                menu();
            }
        }
    }

    public BigDecimal atualizarLimite(Compra compra){
        return limiteAtualizado = credito.calcularLimite(compra.getValorCompra());
    }

    public void adicionarCompraNaListaEOrdena(Compra compra){
        compras.add(compra);
        Collections.sort(compras);
    }

    public Compra dadosDaCompra(){
        Compra compra = new Compra();

        System.out.println("Digite a descrição da compra: ");
        compra.setDescricaoCompra(entradaDados.nextLine());
        System.out.println("Digite o valor da compra:" );
        compra.setValorCompra(entradaDados.nextBigDecimal());
        return compra;
    }


    public void menu() {
        System.out.println("Digite 0 para sair ou 1 para continuar");
        try {
            byte opcao = entradaDados.nextByte();

            switch (opcao){
                case 0:
                    System.out.println(retornarRespostas(1));
                    break;
                case 1:
                    listarCompras();
                    break;
                default:
                    System.out.println("Não existe esta opção no menu!");
                    break;
            }
        }catch (InputMismatchException exception){
            System.out.println("Erro: Só é permitido entradas de números inteiros");
        }

    }

    public String retornarRespostas(int opcaoRetorno){
        switch (opcaoRetorno){
            case 0:
                msg.delete(0, msg.length());
                msg.append("\nCompra realizada!\n");
                break;
            case 1:
                msg.delete(0, msg.length());
                msg.append("\nCOMPRAS REALIZADAS:");
                msg.append("\n");
                for (Compra compra : compras){
                    msg.append(compra).append("\n");
                }
                msg.append("\nSaldo do cartão: ");
                msg.append(limiteAtualizado);
                break;
            case 2:
                msg.append("Saldo insuficiente!");
                break;
        }
        return msg.toString();
    }
}
