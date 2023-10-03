package Velha;

import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.*;

public class JogoDaVelha extends JFrame {
   private JButton[] bt;
   private boolean xo = false;
   private boolean[] click;

   public JogoDaVelha() {
      // Vetor de bot�es
      bt = new JButton[9];
      click = new boolean[9];

      setVisible(true);
      setTitle("Jogo da Velha");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(null); // Deixei nulo para que eu possa fazer as altera��es na maneira que eu quero
      setBounds(0,0,700,500);

      // CRIA��O DOS BOT�ES
      int cont = 0;
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            bt[cont] = new JButton();
            add(bt[cont]);
            bt[cont].setBounds((100 * i) + 50,(100 * j) + 50,95,95);
            bt[cont].setFont(new Font("Arial",Font.BOLD,40));
            cont++;
         }
      }
      for (int i = 0; i < 9; i++) {
         click[i] = false;
      }

      // Adiciona um ActionListener para cada bot�o
      for (int i = 0; i < bt.length; i++) {
         int index = i; // Para poder acessar dentro do ActionListener
         bt[i].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               if (!click[index]) {
                  click[index] = true;
                  mudar(bt[index]);
               }
            }
         });
      }
   }

   public void mudar(JButton btn) {
      if (xo) {
         btn.setText("O");
         xo = false;
      }
      else {
         btn.setText("X");
         xo = true;
      }
      vencedor();
   }

   public void vencedor() {
      if ((bt[0].getText().equals("X") && bt[1].getText().equals("X") && bt[2].getText().equals("X"))
            || (bt[3].getText().equals("X") && bt[4].getText().equals("X") && bt[5].getText().equals("X"))
            || (bt[6].getText().equals("X") && bt[7].getText().equals("X") && bt[8].getText().equals("X"))
            || (bt[0].getText().equals("X") && bt[3].getText().equals("X") && bt[6].getText().equals("X"))
            || (bt[1].getText().equals("X") && bt[4].getText().equals("X") && bt[7].getText().equals("X"))
            || (bt[2].getText().equals("X") && bt[5].getText().equals("X") && bt[8].getText().equals("X"))
            || (bt[0].getText().equals("X") && bt[4].getText().equals("X") && bt[8].getText().equals("X"))
            || (bt[6].getText().equals("X") && bt[4].getText().equals("X") && bt[2].getText().equals("X"))) {
         JOptionPane.showMessageDialog(null,"X Ganhou!");
         limpar();

         // Verifica se O ganhou
      }
      else if ((bt[0].getText().equals("O") && bt[1].getText().equals("O") && bt[2].getText().equals("O"))
            || (bt[3].getText().equals("O") && bt[4].getText().equals("O") && bt[5].getText().equals("O"))
            || (bt[6].getText().equals("O") && bt[7].getText().equals("O") && bt[8].getText().equals("O"))
            || (bt[0].getText().equals("O") && bt[3].getText().equals("O") && bt[6].getText().equals("O"))
            || (bt[1].getText().equals("O") && bt[4].getText().equals("O") && bt[7].getText().equals("O"))
            || (bt[2].getText().equals("O") && bt[5].getText().equals("O") && bt[8].getText().equals("O"))
            || (bt[0].getText().equals("O") && bt[4].getText().equals("O") && bt[8].getText().equals("O"))
            || (bt[6].getText().equals("O") && bt[4].getText().equals("O") && bt[2].getText().equals("O"))) {
               JOptionPane.showMessageDialog(null,"O Ganhou!");
               limpar();

            }
      else {

         for (int i = 0; i < bt.length; i++) {
            if (bt[i].getText() == "") {
               return;
            }
         }
         JOptionPane.showMessageDialog(null,"Empate!");
      }
   }

   public void limpar() {
      for (int i = 0; i < 9; i++) {
         bt[i].setText("");
         click[i] = false;
      }
   }

   public static void main(String[] args) {
      new JogoDaVelha();
   }
}