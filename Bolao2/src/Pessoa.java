import java.util.Scanner;

public class Pessoa {

    protected String nome;
    protected String cpf;

    public Pessoa(){
        Scanner s = new Scanner(System.in);

        System.out.println("Digite seu Nome: ");
        this.setNome(s.nextLine());

        System.out.println("Digite seu CPF: ");
        this.setCpf(s.nextLine());
    }

    public Pessoa(String nome, String cpf){
        this.setNome(nome);
        this.setCpf(cpf);
    }

    public void listarDados(){
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
