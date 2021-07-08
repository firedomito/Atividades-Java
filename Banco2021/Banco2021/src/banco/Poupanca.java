package banco;

public class Poupanca extends  Conta{

    public Poupanca(Gerente g){
        super(g);
    }

    Poupanca (String numero, Pessoa titular, Data criacao, Gerente gerente){
        super(numero, titular, criacao, gerente);
    }

    public void extrato() {
        System.out.println("*** EXTRATO DA CONTA POUPANCA ***");
        super.extrato();
    }
}
