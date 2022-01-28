package com.company;
import java.util.Scanner;
public class Conta implements IConta{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected double fatura = 0;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {

    }

    @Override
    public void fazerCompraDebito(String nomeProduto, double valorProduto) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Compra por cartão de débito!");
        if(this.saldo>=valorProduto){
            this.saldo-=valorProduto;
            System.out.println("Compra realizada com sucesso! seu saldo atual é R$" + this.saldo);
        }else{
            System.out.println("Seu saldo é " + this.saldo + ", ele é insuficiente para fazer um compra em débito!");
        }
    }

    @Override
    public void fazerCompraCredito(String nomeProduto, double valorProduto) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Compra por cartão de crédito!");

        System.out.println("Deseja pagar em quantas parcelas?");
        int parcelas = teclado.nextInt();
        double calculo = valorProduto/parcelas;
        fatura+=calculo;
        System.out.println(String.format("Você terá que pagar: %d parcelas de R$ %.2f e sua fatura é R$ %.2f",parcelas,calculo,this.fatura));
        System.out.println("Deseja pagar agora antes do prazo a fatura desse mês (s/n)?");
        String escolha = teclado.next();
        boolean expressao = escolha.equalsIgnoreCase("s") && this.saldo >=this.fatura;
        if(expressao){
            this.fatura -= calculo;
            System.out.println("Sua fatura atual é " + this.fatura + " e a desse mês foi paga!");
        }
        else if(this.saldo<this.fatura) {
            System.out.println("Seu saldo é insuficiente!");
        }
        else if(escolha.equalsIgnoreCase("n")){
            System.out.println("Cuidado para não passar do prazo!");
        }

    }





    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println(String.format("Fatura: %.2f", this.fatura));
    }
}
