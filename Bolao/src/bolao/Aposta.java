package bolao;

import java.util.Scanner;

public class Aposta {
    private int n;
    private int [] numeros;
    private Jogador organizador;
    private Jogador jog1;
    private Jogador jog2;

    public Aposta() {
        Scanner s = new Scanner(System.in);

        System.out.println("Quantos numeros irá jogar? entre 6 a 15 numeros: ");
        this.setN(s.nextInt());

        numeros = new int[n];

        //Faz a leitura da quantidade de numeros jogados
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digite o " + (i + 1) + " Numero:");
            numeros[i] = (s.nextInt());
        }


        // Criação dos jogadores
        System.out.println("Digite o nome do organizador: ");
        Jogador organizador = new Jogador();

        System.out.println("Digite o nome do primeiro Jogador: ");
        Jogador jog1 = new Jogador();

        System.out.println("Digite o nome do segundo Jogador: ");
        Jogador jog2 = new Jogador();


        this.setOrganizador(organizador);
        this.setJog1(jog1);
        this.setJog2(jog2);
    }


    //Salva em uma variavel a quantidade de vezes que os numeros estavam corretas.
    public boolean vencedora(int [] nums) {
        int acertos = 0;

        //Le o array e faz a verificação se os numeros são os mesmos
        for (int i = 0; i < nums.length; i++) {
            for (int x = 0; x < numeros.length; x++) {
                if (numeros[x] == nums[i]) {
                    acertos++;
                }
            }
        }
        if (acertos == 6) {
            return true;
        }
        return  false;
    }

    public void exibirPremio(double valor){
        double premioFinal;

        double valorOrg = (valor*0.1);

        premioFinal = (valor - valorOrg) / 3;

        organizador.listarDados();
        System.out.println("Valor do Premio: " + (premioFinal+valorOrg));

        jog1.listarDados();
        System.out.println("Valor do Premio: " + premioFinal);

        jog2.listarDados();
        System.out.println("Valor do Premio: " + premioFinal);

    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    public Jogador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Jogador organizador) {
        this.organizador = organizador;
    }

    public Jogador getJog1() {
        return jog1;
    }

    public void setJog1(Jogador jog1) {
        this.jog1 = jog1;
    }

    public Jogador getJog2() {
        return jog2;
    }

    public void setJog2(Jogador jog2) {
        this.jog2 = jog2;
    }
}
