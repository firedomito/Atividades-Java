package banco;

import java.util.Scanner;

public class Gerente extends Pessoa {
    private String matr;
    private String senha;


    Gerente(){
        super();
        Scanner s = new Scanner(System.in);

        System.out.println("Digite a matricula: ");
        this.setMatr(s.nextLine());

        System.out.println("Digite a Senha: ");
        this.senha = (s.nextLine());
    }

    Gerente(String nome, Data dtNasc, char sexo, String cpf, String matr, String senha){
        super(nome, dtNasc, sexo, cpf);
        this.setMatr(matr);
        this.senha = (senha);
    }

    boolean validarAcess(String senha){
        return senha.equals(this.getSenha());
    }

    boolean validarAcess(){
        Scanner s = new Scanner(System.in);

        System.out.println("Informe a senha: ");
        String senha = s.nextLine();
        return this.validarAcess(senha);
    }


    public String getMatr() {
        return matr;
    }

    public void setMatr(String matr) {
        this.matr = matr;
    }
    public String getSenha(){
        return senha;
    }


    public void setSenha(String atual, String senha) {
        if (atual.equals(this.senha)){
            this.senha = senha;
        }
    }
}
