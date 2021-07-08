package banco;

import java.util.Scanner;

public class Pessoa {
    protected String nome;
    protected Data nasc;
    protected char sexo;
    protected String cpf;

    public Pessoa(){
        Scanner s = new Scanner(System.in);

        System.out.println("Digite os dados: ");
        this.setNome(s.nextLine());

        System.out.println("Digite a data de nascimento: ");
        this.setNasc(new Data());

        System.out.println("Digite o sexo: ");
        this.setSexo(s.nextLine().charAt(0));

        System.out.println("Digite o CPF: ");
        this.setCpf(s.nextLine());
    }
    public Pessoa(String nome, Data dtNasc, char sexo, String cpf) {
        this.setNome(nome);
        this.setNasc(dtNasc);
        this.setSexo(sexo);
        this.setCpf(cpf);
    }

    public int idade (Data hoje){
        int diff = (hoje.getAno() - this.getNasc().getAno());
        if (this.getNasc().getMes() < hoje.getMes()){
            return diff;
        }
        if (this.getNasc().getMes() > hoje.getMes()){
            return  diff-1;
        }
        if (this.getNasc().getDia() <= hoje.getDia()){
            return diff;
        }
        return  diff-1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Data getNasc() {
        return nasc;
    }

    public void setNasc(Data nasc) {
        this.nasc = nasc;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
