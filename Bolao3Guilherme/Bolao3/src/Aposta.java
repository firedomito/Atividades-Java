import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Aposta {
    private ArrayList<Integer> numeros;
    private Jogador organizador;
    private ArrayList<Jogador> jogadores;


    public Aposta() {
        this.setJogadores(new ArrayList<>());
        this.setNumeros(new ArrayList<>());
    }

    public void inserirNumeros() {
        Scanner s = new Scanner(System.in);

        int num = 0;

        while (num < 1) {
            System.out.println("Quantidade de numeros a serem apostados: ");
            while (! s.hasNextInt()) {
                s.next();
                System.out.println("Apenas numeros! Digite novamente ");
            }
            num = s.nextInt();
        }

        // Repete até que a quantidade inserida seja completa
        while (this.getNumeros().size() < num) {
            int numerosAposta = 0;
            while (numerosAposta < 1) {
                System.out.println("Digite o Numero: ");
                while (! s.hasNextInt()){
                    s.next();
                    System.out.println("Digite apenas numeros!");
                }
                numerosAposta = s.nextInt();
            }

            // maneira encontrada para resolver o erro: local variables referenced from a lambda expression must be final or effectively final
            int numerosApostados = numerosAposta;

            // .anyMatch verifica se existe algum numero repetido
            boolean existeNumRepetido = this.getNumeros().stream().anyMatch(x -> x == numerosApostados);

            if (numerosApostados >= 1 && numerosApostados <= 60) {
                if (existeNumRepetido) {
                    System.out.println("Numero repetido. DIGITE NOVAMENTE! ");
                } else {
                    this.getNumeros().add(numerosApostados);
                }
            } else {
                System.out.println("Numero não está entre 1 e 60. Tente Novamente!");
            }
        }
    }


    //
    public void inserirOrganizador(ArrayList<Jogador> jogadores) {
        Scanner s = new Scanner(System.in);


        // Caso tenha jogadores no arraylist = True.

        // Faz a verificação e caso não tenha nenhum jogador cadastrado sai do metodo

        if (jogadores.size() <= 0) {
            System.out.println("NENHUM JOGADOR CADASTRADO! Cadastre jogadores antes de inserir um organizador");
            return;
        }

        System.out.println("CPF do Organizador: ");
        String cpfOrg = s.nextLine();


        // Variavel de controle de CPF
        boolean encontrouCPF = false;


        System.out.println("Jogadores no bilhete");
        // Cada item dos jogadores se torna um jogador
        for (Jogador jogador : jogadores) {
            jogador.listarDados();

            // Verifica se o CPF digitado é de um Jogador valido e adiciona o jogador como Organizador
            if (jogador.getCpf().equals(cpfOrg)) {
                this.setOrganizador(jogador);
                encontrouCPF = true;
            }
        }

        // ! -> Inverte valor boolean//
        // Caso CPF não seja valido coloca o primeiro jogador cadastrado como organizador
        if (!encontrouCPF) {
            System.out.println("Organizador não encontrado. O primeiro jogador cadastrado será o Organizador!");
            this.setOrganizador(jogadores.get(0));
        }

    }

    public void inserirJogadores(ArrayList<Jogador> todosJogadores) {
        Scanner s = new Scanner(System.in);

        boolean encontrouCPF = false;

        int numBilhete = 0;


        while (numBilhete < 1) {
                System.out.println("Digite o numero de Jogadores no bilhete: ");
                while (! s.hasNextInt()) {
                    s.next();
                    System.out.println("Apenas numeros! Digite novamente ");
                }
                numBilhete = s.nextInt();

            }

        for (int i = 1; i <= numBilhete; i++) {
            System.out.println("---- JOGADORES CADASTRADOS ----");
            for (Jogador davez : todosJogadores) {
                System.out.println("Nome: " + davez.nome);
                System.out.println("CPF: " + davez.cpf + '\n');
            }

            System.out.printf("Informe o CPF do Jogador: ");
            String cpfJog;
            cpfJog = s.next();

            for (Jogador jogador : todosJogadores) {
                if (jogador.getCpf().equals(cpfJog)) {
                    this.jogadores.add(jogador);
                    encontrouCPF = true;
                }
            }

            if (!encontrouCPF) {
                System.out.println("Jogador não encontrado. O primeiro jogador cadastrado será o primeiro jogador encontrado!");
                this.jogadores.add(todosJogadores.get(0));
            }
        }
    }


    public boolean vencedora(ArrayList<Integer> sorteados){
            int acertos = 0;

            //Le o array e faz a verificação se os numeros são os mesmos
            for (int i = 0; i < sorteados.size(); i++) {
                for (int x = 0; x < numeros.size(); x++) {
                    if (numeros.get(x) == sorteados.get(i)) {
                        acertos++;
                    }
                }
            }

            if (acertos == 6) {
                return true;
            }
            return  false;
        }

    public void listarVencedores(double valor){
        double premioFinal;

        double valorOrg = (valor*0.1);

        premioFinal = (valor - valorOrg) / this.getJogadores().size() ;


        // Caso o organizador da cartela seja um jogador da cartela recebera o valor do premio + 10%
        if (this.getJogadores().contains(this.getOrganizador())){
            valorOrg = premioFinal + valorOrg;
        }


        System.out.println("🐱🐺🐶 ORGANIZADOR 🐶🐺🐱");
        organizador.listarDados();

        // Caso o organizador da cartela NÃO seja um jogador da cartela recebera apenas 10% do valor do premio
        System.out.println("Valor do Premio do Organizador: " + (valorOrg) + '\n');


        System.out.println("🐱🐺🐶 Premio dos jogadores 🐶🐺🐱");
        for (Jogador jogador : this.getJogadores()) {
            if (jogador.getCpf() != organizador.getCpf()){
                jogador.listarDados();
                System.out.println("Valor do Premio: " + premioFinal + '\n');
            }
        }
    }







    public ArrayList<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Integer> numeros) {
        this.numeros = numeros;
    }

    public Jogador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Jogador organizador) {
        this.organizador = organizador;
    }


    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
}











