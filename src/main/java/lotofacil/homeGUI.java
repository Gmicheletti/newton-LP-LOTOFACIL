package lotofacil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.UIManager;


public class homeGUI extends JFrame{



    private JPanel painel = new JPanel(); //CRIA A JANELA
    private JLabel jLabelTitulo = new JLabel("LOTOFÁCIL GM"); //MENSAGEM

    private JLabel jLabelMensagem = new JLabel("Bem-vindo, tente sua sorte:"); //MENSAGEM
    private JButton jButtonAposta1 = new JButton("Apostas de 1 a 100"); //BOTAO
    private JButton jButtonAposta2 = new JButton("Apostas de A a Z"); //BOTAO
    private JButton jButtonAposta3 = new JButton("Apostas Par ou Ímpar"); //BOTAO



    ImageIcon iconWin = new ImageIcon("./src/main/java/lotofacil/imgs/win.gif");    //LOGOS DO SISTEMA
    ImageIcon iconLose = new ImageIcon("./src/main/java/lotofacil/imgs/lose.gif");    //LOGOS DO SISTEMA
    ImageIcon iconMachine = new ImageIcon("./src/main/java/lotofacil/imgs/machine.gif");    //LOGOS DO SISTEMA
    JLabel iconCasino = new JLabel(new ImageIcon("./src/main/java/lotofacil/imgs/casino.gif"));    //LOGOS DO SISTEMA



    public homeGUI(){ //DEFINE PARAMETROS DE LAYOUT DA JANELA
        this.setTitle("LOTOFÁCIL GM");
        this.setSize(400,400);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER,200,20));
        painel.setBackground(new Color(255, 255, 255));
        painel.add(iconCasino);
        painel.add(jLabelTitulo);
        painel.add(jLabelMensagem);
        painel.add(jButtonAposta1);
        painel.add(jButtonAposta2);
        painel.add(jButtonAposta3);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null); //CENTRALIZA JANELA
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); //EXIBE JANELA

        //DEFINE PARAMETROS DE LAYOUT DO SHOW MENSAGEM DIALOG
        UIManager.put("OptionPane.background", new Color(255, 255, 255));
        UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(255, 255, 255));








//      AÇÕES DOS BOTOES
        jButtonAposta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//              Scanner in = new Scanner(System.in);  FORMA DE RECEBER DADOS NO TERMINAL
                Object aposta1 = JOptionPane.showInputDialog(null,"Digite o número de 1 a 100","Aposta 1", JOptionPane.INFORMATION_MESSAGE, iconMachine, null, "");
                int numeroApostado = Integer.parseInt(aposta1.toString());
                zeroCem(numeroApostado);
            }
        });

        jButtonAposta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object aposta2 = JOptionPane.showInputDialog(null, " Insira uma letra de A a Z","Aposta 2", JOptionPane.INFORMATION_MESSAGE, iconMachine, null, "" );
                char letraApostada = aposta2.toString().charAt(0);
                aZ(letraApostada);
            }
        });

        jButtonAposta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object aposta3 = JOptionPane.showInputDialog(null,"Insira um numero para começar","Aposta 3", JOptionPane.INFORMATION_MESSAGE, iconMachine, null, ""  );
                int numeroApostado = Integer.parseInt(aposta3.toString());
                parImpar(numeroApostado);
            }
        });


    }


    public static void main(String[] args) throws IOException {
        new homeGUI(); // INICIA A JANELA DO PROGRAMA
    }

    //  METODOS CRIADOS
    private  void zeroCem(int numeroApostado) {

        int opcaoZeroCem = -1;

        Random rdn = new Random();



        int numbSorteado = rdn.nextInt(100);
        opcaoZeroCem = numeroApostado;



        if(opcaoZeroCem < 0 || opcaoZeroCem > 100){
//                System.out.println(); FORMA DE PRINTAR DADOS NO TERMINAL
            JOptionPane.showMessageDialog(null,"Número Inválido","Aposta 1", JOptionPane.INFORMATION_MESSAGE, iconLose);

        } else if(numbSorteado == opcaoZeroCem){
            JOptionPane.showMessageDialog(null,"Você ganhou R$ 1.000,00 reais.","Aposta 1", JOptionPane.INFORMATION_MESSAGE, iconWin);

        }else if(numbSorteado != opcaoZeroCem && opcaoZeroCem != 0) {
            JOptionPane.showMessageDialog(null,"Que pena! O número sorteado foi: " + numbSorteado,"Aposta 1", JOptionPane.INFORMATION_MESSAGE, iconLose);

        }else{

        }




    }

    private  void aZ(char letraApostada) {
        boolean inputCheck;
        char inputDefault, inputUpper;


        inputDefault = letraApostada;
        inputCheck = Character.isLetter(inputDefault);
        inputUpper = Character.toUpperCase(inputDefault);


        if(inputCheck){

            if(inputUpper == 'G'){
                JOptionPane.showMessageDialog(null,"Você ganhou R$ 500,00 reais.","Aposta 2", JOptionPane.INFORMATION_MESSAGE, iconWin);
            }else{

                JOptionPane.showMessageDialog(null,"Que pena! A letra sorteada foi: G","Aposta 2", JOptionPane.INFORMATION_MESSAGE, iconLose);
            }
        }else {

            JOptionPane.showMessageDialog(null,"Aposta inválida.","Aposta 2", JOptionPane.INFORMATION_MESSAGE, iconLose);
        }





    }

    private void parImpar(int numeroApostado){


        int numbInput = numeroApostado;


        switch (numbInput % 2){
            case 0:
                JOptionPane.showMessageDialog(null,"Você ganhou R$ 100,00 reais.","Aposta 3", JOptionPane.INFORMATION_MESSAGE, iconWin);
                break;
            default:
                JOptionPane.showMessageDialog(null,"Que pena! O número digitado é ímpar e a premiação foi para números pares.","Aposta 3", JOptionPane.INFORMATION_MESSAGE, iconLose);
        }


    }

}




