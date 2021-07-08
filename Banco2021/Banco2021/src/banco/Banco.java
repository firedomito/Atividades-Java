package banco;



public class Banco {
    public static void main(String[] args) {
        /*Data d1 = new Data(10, 10, 2000);
        Data d2 = new Data(19, 03,2003);
        Data hoje = new Data(02, 06,2021);
        Data g1 = new Data(22, 04, 1988);
        Data dtc1 = new Data(16, 06, 2020);
        Data dtc2 = new Data(16, 06, 2020);

        Pessoa p1 = new Pessoa("Cleyton", d1, 'M', "123.456.789-00");
        Pessoa p2 = new Pessoa("Elena", d2, 'F',"234.567.890-00" );

        Gerente g = new Gerente("Jacaré das Costas Larga", g1, 'M',"345.678.910-01", "0001", "crqcdpk" );
        ContaCorrente c1 = new ContaCorrente("1234-0", p1,dtc1 , g);
        ContaCorrente c2 = new ContaCorrente("2345-0", p2, dtc2, g);

        c1.extrato();
        c2.extrato();

        c1.sacar(150);
        c1.transferir(100, c2);
        c1.sacar(100);
        c1.depositar(100);
        c1.transferir(200, c2);

        for (int i = 0; i<30; i++){
            c1.chequeEspecial(0.5);
            if (i%30 == 0){
                System.out.println("Saldo após " + i + " dias: R$:" + c1.saldo);
            }
        }*/

        Gerente g = new Gerente();

        ContaCorrente c1 = new ContaCorrente(g);
        Poupanca p1 = new Poupanca(g);

        c1.extrato();
        p1.extrato();

        c1.sacar(200);
        p1.depositar(50);
        p1.transferir( 30, c1);

        c1.extrato();
        p1.extrato();





    }
}
