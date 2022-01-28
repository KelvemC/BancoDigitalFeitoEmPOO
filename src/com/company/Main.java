package com.company;

public class Main {

    public static void main(String[] args) {
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        cc.depositar(500);
        cc.transferir(500, poupanca);
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
        //Compra 1
        /*System.out.println("Fazendo compra de um livro: ");
        poupanca.fazerCompraDebito("Livro: Use a cabeça!: Java", 135.7);*/
        System.out.println("\n");
        System.out.println("Fazendo compra de uma cama por crédito!");
        poupanca.fazerCompraCredito("Cama Box Casal (Box + Colchão) Plumatex Mola", 899.5);


    }
}
