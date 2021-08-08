import java.util.Scanner;

public class Bolao {
    public static int menuInicio() {

        Scanner s = new Scanner(System.in);

        System.out.println("🐱🐺🐶 JOGO DO BICHO 2.0 🐶🐺🐱");

        System.out.println("1) Cadastrar Jogador");
        System.out.println("2) Cadastrar Aposta");
        System.out.println("3) Inserir sorteio e listar vencedores");
        System.out.println("4) SAIR");

        return s.nextInt();
    }

    public static void main(String[] args){

        Sistema sistema = new Sistema();

        int selecionar = menuInicio();

        while (selecionar != 4){
            if (selecionar == 1){
                sistema.cadastrarJogador();
                selecionar = menuInicio();
            }
            if (selecionar == 2){
                sistema.cadastrarAposta();
                selecionar = menuInicio();
            }
            if (selecionar == 3) {
                sistema.inserirSorteio();
                selecionar = menuInicio();
            }

        }


    }
}
