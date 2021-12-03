import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Sistema {

    private ArrayList<Aposta> apostas;
    private ArrayList<Jogador> jogadores;

    public Sistema(){
        apostas = new ArrayList<>();
        jogadores = new ArrayList<>();
    }




    public void cadastrarJogador(){
        this.getJogadores().add(new Jogador());


    }

    public void  cadastrarAposta(){
        Aposta aposta = new Aposta();

        aposta.inserirJogadores(getJogadores());
        aposta.inserirOrganizador(getJogadores());
        aposta.inserirNumeros();

        getApostas().add(aposta);


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

        premio = premio / apostasVencedoras.size();


        for (Aposta vencedor : apostasVencedoras){
            System.out.println("##################### CARTELA VENCEDORA ##################### " + '\n');
            vencedor.listarVencedores(premio);
        }


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
