import java.util.Scanner;

public class Bolao {
    public static int menuInicio() {

        Scanner s = new Scanner(System.in);



        int opcao = 0;
        while (opcao < 1) {
            System.out.println("🐱🐺🐶 JOGO DO BICHO 2.0 🐶🐺🐱");

            System.out.println("1) Cadastrar Jogador");
            System.out.println("2) Cadastrar Aposta");
            System.out.println("3) Inserir sorteio e listar vencedores");
            System.out.println("4) SAIR");
            while (! s.hasNextInt()) {
                s.next();
                System.out.println("Apenas numeros! Digite as opções abaixo ");
                System.out.println("1) Cadastrar Jogador");
                System.out.println("2) Cadastrar Aposta");
                System.out.println("3) Inserir sorteio e listar vencedores");
                System.out.println("4) SAIR");
            }
            opcao = s.nextInt();

        }
        return opcao;
    }
    public static void main(String[] args){

        Sistema sistema = new Sistema();

        int selecionar = menuInicio();

        while (selecionar != 4){
            if (selecionar == 1){
                sistema.cadastrarJogador();
            }
            else if (selecionar == 2){
                sistema.cadastrarAposta();
            }
            else if (selecionar == 3) {
                sistema.inserirSorteio();
            }
            else {
                System.out.println("Numero Invalido! Digite as opções abaixo");
            }
            selecionar = menuInicio();
        }





    }
}
