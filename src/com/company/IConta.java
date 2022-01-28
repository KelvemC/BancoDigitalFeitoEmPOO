package com.company;

public interface IConta {
    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, IConta contaDestino);

    void imprimirExtrato();

    void fazerCompraDebito(String nomeProduto, double valorProduto);
    void fazerCompraCredito(String nomeProduto, double valorProduto);
}
