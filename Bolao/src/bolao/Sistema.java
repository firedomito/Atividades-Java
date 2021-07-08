package bolao;

import java.util.Scanner;

public class Sistema {
    private Aposta a;

    public Sistema(Aposta a){
        this.setA(a);
    }


    public void sorteio(){
        Scanner s = new Scanner(System.in);
        int [] nums;
        nums = new int[6];
        double premio;


        //O for está pegando um array de tamanho 6 realiza a leitura e salva na variavel "nums"
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Digite o " + (i + 1) + " Numero sorteado: ");
            nums[i] = (s.nextInt());
        }

        System.out.println("Digite o valor do premio: ");
        premio = s.nextDouble();

        //Caso os numeros do sorteio batam com os numeros digitados pelos jogadores ele vence
        if (getA().vencedora(nums)){
            getA().exibirPremio(premio);
        }
        else {
            System.out.println("Não houve vencedores!");
        }




    }

    public Aposta getA() {
        return a;
    }

    public void setA(Aposta a) {
        this.a = a;
    }
}
