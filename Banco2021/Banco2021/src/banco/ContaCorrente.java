package banco;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(Gerente g){
        super(g);
        this.limite = (200);
    }
    public ContaCorrente(String numero, Pessoa titular, Data criacao, Gerente gerente){
        super(numero, titular, criacao, gerente);
        this.limite = (200);
    }

    protected double disponivel() {
        return this.getSaldo() + this.getLimite();
    }

    public void extrato() {
        System.out.println("*** EXTRATO DA CONTA CORRENTE ***");
        super.extrato();
    }

    public void chequeEspecial(double juro) {
        if (this.getSaldo() <= 0) {

            this.setSaldo(this.getSaldo() + (juro / 100) * this.getSaldo());
        }
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(String senha, double limite) {
        if (this.getGerente().validarAcess(senha)){
            this.limite = limite;
        }
    }
}

