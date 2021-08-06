import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private ArrayList<Aposta> apostas;
    private ArrayList<Jogador> jogadores;

    public Sistema(){
        apostas = new ArrayList<>();
        jogadores = new ArrayList<>();
    }

    public void mostrarMenu(){
        Scanner s = new Scanner(System.in);
        System.out.println("1) Cadastrar Jogador");
        System.out.println("2) Cadastrar Aposta");
        System.out.println("3) Inserir sorteio e listar vencedores");
        System.out.println("4) SAIR");

        int selecionar = s.nextInt();

        if (selecionar == 1) cadastrarJogador();
        if (selecionar == 2) cadastrarAposta();
        if (selecionar == 3) inserirSorteio();
        if (selecionar == 4) return;



    }



    public void cadastrarJogador(){
        this.getJogadores().add(new Jogador());

        mostrarMenu();

    }

    public void  cadastrarAposta(){
        Aposta aposta = new Aposta();

        aposta.inserirJogadores(getJogadores());
        aposta.inserirOrganizador(getJogadores());
        aposta.inserirNumeros();

        getApostas().add(aposta);

        mostrarMenu();

    }


    public void inserirSorteio(){
        Scanner s = new Scanner(System.in);

        ArrayList<Integer> numerosSorteio = new ArrayList<>();

        int count = 0;
        while (count < 6) {
            count++;
            System.out.println("Digite o " + (count) + " Numero sorteado: ");
            numerosSorteio.add((s.nextInt()));
        }

        System.out.println("Digite o valor do premio: ");
        double premio = s.nextDouble();

        ArrayList<Aposta> apostasVencedoras = vencedoras(numerosSorteio);

        for (Aposta vencedor : apostasVencedoras){
            vencedor.listarVencedores(premio);
        }



        mostrarMenu();
    }

    private ArrayList<Aposta> vencedoras (ArrayList<Integer> nums){

        ArrayList<Aposta> vencedores = new ArrayList<>();

        for (Aposta aposta : this.getApostas()){
            boolean vencedor = aposta.vencedora(nums);

            if (vencedor == true){
                vencedores.add(aposta);
            }

        }

        return vencedores;
    }

    public ArrayList<Aposta> getApostas() {
        return apostas;
    }

    public void setApostas(ArrayList<Aposta> apostas) {
        this.apostas = apostas;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }





}
