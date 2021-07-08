package banco;

import  java.util.Scanner;
public class Conta {
    protected String numero;
    protected Pessoa titular;
    protected double saldo;
    protected Data criacao;
    protected Gerente gerente;

    public Conta(Gerente g){
        Scanner s = new Scanner(System.in);

        System.out.println("Digite o numero : ");
        this.setNumero(s.nextLine());

        System.out.println("Digite os dados do titular");
        this.setTitular(new Pessoa());

        this.setSaldo(0);

        System.out.println("Digite a data de criacao: ");
        this.setCriacao(new Data());

        this.setGerente(g);

    }

    public Conta(String numero, Pessoa titular, Data criacao, Gerente gerente) {
        this.setNumero(numero);
        this.setTitular(titular);
        this.setCriacao(criacao);
        this.setGerente(gerente);
        this.setSaldo(0);
    }

    protected double disponivel() {
        return this.getSaldo();
    }

    public void depositar (double valor){
        this.setSaldo(this.getSaldo() + valor);
        System.out.println("Depósito realizado com sucesso.");
        System.out.println("Novo saldo: R$" + this.getSaldo());

    }


    public void extrato() {
        System.out.println("Titular: " + this.getTitular().getNome());
        System.out.println("Conta: " + this.getNumero());
        System.out.println("Valor disponivel para saque: " + this.disponivel() + "\n");
    }

    public boolean sacar(double valor) {
        if (valor <= this.disponivel()) {
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("Saque na conta: " + this.getNumero() + " Realizado com Sucesso! Novo Saldo: " + this.getSaldo());
            return true;
        }
        else {
            System.out.println("ERRO: Saque na conta: " + this.getNumero() + " Não foi realizado. Valor Dispononivel: " + this.disponivel());
            return false;
        }
    }

    public boolean transferir(double valor, Conta destino) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transferencia de: " + valor + " da conta: " + this.getNumero() + " para a conta " + destino.getNumero() + " Foi realizado com sucesso! ");
            return true;
        } else {
            System.out.println("ERRO: Não foi possivel transferir: " + valor + " da conta: " + this.getNumero() + " para Conta " + destino.getNumero() + ". Valor Disponivel: " + this.disponivel());
            return false;
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Data getCriacao() {
        return criacao;
    }

    public void setCriacao(Data criacao) {
        this.criacao = criacao;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
}
