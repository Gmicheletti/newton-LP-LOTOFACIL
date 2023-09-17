package lotofacil;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class home {

    public static void main(String[] args) throws IOException {
     menu();
    }

    private static void menu() throws IOException {

        int opcao;
        Scanner scn = new Scanner(System.in);

        do {
            System.out.println("**************************");
            System.out.println("Menu LotoFácil Guilherme Micheletti");
            System.out.println("1) Apostar de 0 a 100");
            System.out.println("2) Apostar de A à Z");
            System.out.println("3) Apostar em par ou ímpar");
            System.out.println("0) Sair");
            System.out.println("**************************");

            System.out.print("Digite um número para iniciar: ");
            opcao = scn.nextInt();

            switch (opcao) {

                case 1:
                    zeroCem();
                    break;

                case 2:
                    aZ();
                    break;

                case 3:
                    parImpar();
                    break;

                case 0:
                    System.out.println("Obrigado, volte sempre!");
                    break;
                default:
                    System.out.println("O número escolhido é inválido");

            }

        }while (opcao != 0);


        }

    private static void zeroCem() {

        int opcaoZeroCem = -1;
        Scanner scn = new Scanner(System.in);
        Random rdn = new Random();

        do {
            System.out.println("**************************");
            System.out.println("APOSTAS 0 a 100");
            System.out.print("Insira um número de 1 a 100 ou 0 para voltar para o Menu:");

            int numbSorteado = rdn.nextInt(100);
            opcaoZeroCem = scn.nextInt();

            if(opcaoZeroCem < 0 || opcaoZeroCem > 100){
                System.out.println("**************************");
                System.out.println("Número Inválido");

            } else if(numbSorteado == opcaoZeroCem){
                System.out.println("**************************");
                System.out.println("Você ganhou R$ 1.000,00 reais.");

            }else if(numbSorteado != opcaoZeroCem && opcaoZeroCem != 0) {
                System.out.println("**************************");
                System.out.println("Que pena! O número sorteado foi: " + numbSorteado);

            }else{

            }

        }while (opcaoZeroCem != 0);


    }

    private static void aZ() throws IOException {
        boolean inputCheck;
        char inputDefault, inputUpper;

        do {

            System.out.println("**************************");
            System.out.println("APOSTAS A a Z");
            System.out.print("Insira uma letra de A a Z ou insira 0 para voltar para o Menu: ");
            inputDefault = (char) System.in.read();
            inputCheck = Character.isLetter(inputDefault);
            inputUpper = Character.toUpperCase(inputDefault);
            System.in.skip(1);


            if(inputCheck == true){

                if(inputUpper == 'G'){
                    System.out.println("**************************");
                    System.out.println("Você ganhou R$ 500,00 reais.");
                }else{
                    System.out.println("**************************");
                    System.out.println("Que pena! A letra sorteada foi: G");


                }
            }else if(inputCheck == false){
                System.out.println("**************************");
                System.out.println("Aposta inválida.");
            }

        }while (inputUpper != '0');




    }

    private static void parImpar(){
        int numbInput;
        Scanner scn = new Scanner(System.in);

        do{
            System.out.println("**************************");
            System.out.println("APOSTAS PAR OU IMPAR");
            System.out.print("Insira um numero para começar ou 0 para voltar para o Menu: ");
            numbInput = scn.nextInt();

            switch (numbInput % 2){
                case 0:
                    System.out.println("**************************");
                    System.out.println("Você ganhou R$ 100,00 reais.");
                    break;
                default:
                    System.out.println("**************************");
                    System.out.println("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
            }
        }while (numbInput != 0);
            
        
        
        
    }

}




