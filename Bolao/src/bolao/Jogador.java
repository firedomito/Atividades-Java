package bolao;

import java.util.Scanner;

public class Jogador extends Pessoa {
    private String pix;


    Jogador(){
        super();
        Scanner s = new Scanner(System.in);

        System.out.println("Digite seu PIX: ");
        this.setPix(s.nextLine());
    }

    Jogador(String nome, String cpf, String pix){
        super(nome, cpf);
        this.setPix(pix);
    }

    public void listarDados (){
        super.listarDados();
        System.out.println("PIX: " + this.getPix());
    }






    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }
}
