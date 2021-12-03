import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Sistema {

    private ArrayList<Aposta> apostas;
    private ArrayList<Jogador> jogadores;

    public Sistema(){
        apostas = new ArrayList<>();
        jogadores = new ArrayList<>();

        this.lerJogadoresCadastrados();
    }


    public void cadastrarJogador(){
        this.getJogadores().add(new Jogador());
        this.salvarJogadores();
    }

    public void salvarJogadores(){
        try {
            FileWriter salvarJog = new FileWriter("jogadores.txt");
            BufferedWriter buff = new BufferedWriter(salvarJog);
            buff.write(this.jogadores.size() + "\n");
            for (Jogador jogador: this.jogadores){
                buff.write(jogador.getNome() + "\n");
                buff.write(jogador.getCpf() + "\n");
                buff.write(jogador.getPix() + "\n");
            }
            buff.close();
        }
        catch (IOException e){
            System.out.println("Não é possivel criar o arquivo!");
        }
      }

   public void lerJogadoresCadastrados(){
        try {
            FileReader leituraArq = new FileReader("jogadores.txt");
            BufferedReader buff = new BufferedReader(leituraArq);

            int qtdJogadores = Integer.parseInt(buff.readLine());

          for (int i = 0; i<qtdJogadores; i++){
              String nome = buff.readLine() ;
              String cpf = buff.readLine();
              String pix = buff.readLine();
              this.getJogadores().add(new Jogador(nome, cpf, pix));
          }
           buff.close();
        }
      catch (IOException e){
            this.jogadores = new ArrayList<>();
         System.out.println("Nenhum jogador cadastrado!");

       }
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
            while ( count >= 0 && count < 6) {
                count++;
                System.out.println("Digite o " + (count) + " Numero sorteado: ");
                while (!s.hasNextInt()) {
                    s.next();
                    System.out.println("Digite apenas numeros!");
                }
                    numerosSorteio.add((s.nextInt()));
            }
        }

        double premio = 0;
        while (premio < 1.0){
            System.out.println("Digite o valor do premio: ");
            while (! s.hasNextDouble()){
                s.next();
                System.out.println("Apenas numeros! Digite novamente ");
            }
            premio = s.nextDouble();
        }


//        System.out.print("Digite o valor do premio:");
//        double premio = s.nextDouble();

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
