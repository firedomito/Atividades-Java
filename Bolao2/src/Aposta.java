import java.util.ArrayList;
import java.util.Scanner;

public class Aposta {

    private ArrayList<Integer> nums;
    private Jogador organizador;
    private ArrayList<Jogador> jogadores;



    public Aposta(){
        this.setJogadores(new ArrayList<>());
        this.setNums(new ArrayList<>());
    }

    public void inserirNumeros() {

        Scanner s = new Scanner(System.in);

        System.out.println("Quantos numeros serão jogados? ");
        int num = s.nextInt();

        while (this.getNums().size() < num) {
            System.out.println("Digite o Numero: ");
            int numeros = s.nextInt();

            if (numeros >= 1 && numeros <= 60) {
                this.getNums().add(numeros);
            }

            else {
                System.out.println("Numero não está entre 1 e 60. Tente Novamente!");
            }

        }
    }


    // Retorna boolean para validação futura
    public boolean inserirOrganizador(ArrayList<Jogador> jogadores){
        Scanner s = new Scanner(System.in);


        // Caso tenha jogadores no arraylist = True.
        boolean inseriuSucesso = true;

        // Faz a verificação e caso não tenha nenhum jogador cadastrado retorna falso

        if (jogadores.size() <= 0 ){
            System.out.println("NENHUM JOGADOR CADASTRADO! Cadastre jogadores antes de inserir um organizador");
            return  !inseriuSucesso;
        }

        System.out.println("CPF do Organizador: ");
        String cpfOrg = s.nextLine();

        // Variavel de controle de CPF
        boolean encontrouCPF = false;

        // Cada item dos jogadores se torna um jogador
        for (Jogador jogador : jogadores){
            jogador.listarDados();

            // Verifica se o CPF digitado é de um Jogador valido e adiciona o jogador como Organizador
            if (jogador.getCpf().equals(cpfOrg)) {
                this.setOrganizador(jogador);
                encontrouCPF = true;
            }
        }

        // ! -> Inverte valor boolean//
        // Caso CPF não seja valido coloca o primeiro jogador cadastrado como organizador
        if (!encontrouCPF){
            System.out.println("Organizador não encontrado. O primeiro jogador cadastrado será o Organizador!");
            this.setOrganizador(jogadores.get(0));
        }

        return inseriuSucesso;
    }

        public void





    public ArrayList<Integer> getNums() {
        return nums;
    }

    public void setNums(ArrayList<Integer> nums) {
        this.nums = nums;
    }

    public Jogador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Jogador organizador) {
        this.organizador = organizador;
    }

    public ArrayList<Jogador> getJog() {
        return jog;
    }

    public void setJog(ArrayList<Jogador> jog) {
        this.jog = jog;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
}










}
