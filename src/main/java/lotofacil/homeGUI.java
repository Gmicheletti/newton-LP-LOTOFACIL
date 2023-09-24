package lotofacil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class homeGUI extends JFrame{

    private JPanel painel = new JPanel(); //CRIA A JANELA
    private JLabel jLabelMensagem = new JLabel("Bem vindo a Lotofácil GM"); //MENSAGEM
    private JButton jButtonAposta1 = new JButton("Apostas de 1 a 100"); //BOTAO
    private JButton jButtonAposta2 = new JButton("Apostas de A a Z"); //BOTAO
    private JButton jButtonAposta3 = new JButton("Apostas Par ou Ímpar"); //BOTAO

    public homeGUI(){ //DEFINE PARAMETROS DE LAYOUT DA JANELA
        this.setTitle("Lotofácil GM");
        this.setSize(400,250);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER,200,20));
        painel.setBackground(new Color(255,255,255));
        painel.add(jLabelMensagem);
        painel.add(jButtonAposta1);
        painel.add(jButtonAposta2);
        painel.add(jButtonAposta3);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null); //CENTRALIZA JANELA
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); //EXIBE JANELA

//      AÇÕES DOS BOTOES
        jButtonAposta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Scanner in = new Scanner(System.in);  FORMA DE RECEBER DADOS NO TERMINAL
                String aposta1 = JOptionPane.showInputDialog(null,"Digite o número de 1 a 100");
                int numeroApostado = Integer.parseInt(aposta1);
                    zeroCem(numeroApostado);
            }
        });

        jButtonAposta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aposta2 = JOptionPane.showInputDialog(null, " Insira uma letra de A a Z" );
                char letraApostada = aposta2.charAt(0);
                    aZ(letraApostada);
            }
        });

        jButtonAposta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aposta3 = JOptionPane.showInputDialog(null,"Insira um numero para começar" );
                int numeroApostado = Integer.parseInt(aposta3);
                    parImpar(numeroApostado);
            }
        });

    }


    public static void main(String[] args) throws IOException {
     new homeGUI(); // INICIA A JANELA DO PROGRAMA
    }

//  METODOS CRIADOS
    private static void zeroCem(int numeroApostado) {

        int opcaoZeroCem = -1;

        Random rdn = new Random();



            int numbSorteado = rdn.nextInt(100);
            opcaoZeroCem = numeroApostado;

            if(opcaoZeroCem < 0 || opcaoZeroCem > 100){
//                System.out.println(); FORMA DE PRINTAR DADOS NO TERMINAL
                JOptionPane.showMessageDialog(null,"Número Inválido");

            } else if(numbSorteado == opcaoZeroCem){
                JOptionPane.showMessageDialog(null,"Você ganhou R$ 1.000,00 reais.");

            }else if(numbSorteado != opcaoZeroCem && opcaoZeroCem != 0) {
                JOptionPane.showMessageDialog(null,"Que pena! O número sorteado foi: " + numbSorteado);

            }else{

            }




    }

    private static void aZ(char letraApostada) {
        boolean inputCheck;
        char inputDefault, inputUpper;


            inputDefault = letraApostada;
            inputCheck = Character.isLetter(inputDefault);
            inputUpper = Character.toUpperCase(inputDefault);


            if(inputCheck){

                if(inputUpper == 'G'){
                    JOptionPane.showMessageDialog(null,"Você ganhou R$ 500,00 reais.");
                }else{

                    JOptionPane.showMessageDialog(null,"Que pena! A letra sorteada foi: G");
                }
            }else {

                JOptionPane.showMessageDialog(null,"Aposta inválida.");
            }





    }

    private static void parImpar(int numeroApostado){


        int numbInput = numeroApostado;


            switch (numbInput % 2){
                case 0:
                    JOptionPane.showMessageDialog(null,"Você ganhou R$ 100,00 reais.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Que pena! O número digitado é ímpar e a premiação foi para números pares.");
            }

        
    }

}




