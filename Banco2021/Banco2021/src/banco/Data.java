package banco;

import  java.util.Scanner;

public class Data {
     private int dia;
     private int mes;
     private int ano;

    public  Data(){
        Scanner s = new Scanner(System.in);

        System.out.println("Digite o dia: ");
        this.setDia(s.nextInt());

        System.out.println("Digite o mes: ");
        this.setMes(s.nextInt());

        System.out.println("Digite o ano: ");
        this.setAno(s.nextInt());

    }

    public Data(int d, int m, int a) {
        this.setDia(d);
        this.setMes(m);
        this.setAno(a);
    }

    public void imprimir(){
        System.out.println(this.getDia() + "/" + this.getMes() + "/" + this.getAno());

    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}