package bolao;

public class Bolao {
    public static void main(String[] args){

        System.out.println("*** SEJA BEM VINDO AO JOGO DO BICHO ***");
        Aposta aposta = new Aposta();

        Sistema sistema = new Sistema(aposta);

        sistema.sorteio();


    }
}
