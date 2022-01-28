package com.company;

public class Main {

    public static void main(String[] args) {
        Cliente Kelvem = new Cliente();
        Kelvem.setNome("Kelvem");

        Conta cc = new ContaCorrente(Kelvem);
        Conta poupanca = new ContaPoupanca(Kelvem);

        cc.depositar(500);
        cc.transferir(500, poupanca);
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
        //Compra 1
        System.out.println("Fazendo compra de um livro: ");
        poupanca.fazerCompraDebito("Livro: Use a cabeça!: Java", 135.7);
        System.out.println("\n");
        System.out.println("Fazendo compra de uma cama por crédito!");
        poupanca.fazerCompraCredito("Cama Box Casal (Box + Colchão) Plumatex Mola", 899.5);


    }
}
