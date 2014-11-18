package decorator;

import logic.Grid;
import logic.Randoming;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.GridLayout;

public class View extends JFrame {

    public View() {
        initComponents();
    }

    public static JPanel content = new Panel();
    public static JFrame frame;

    public void initComponents() {
        mainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OtherPanel();
            }
        });
        start();
    }

    public static void reset() {
        content.removeAll();
        content.repaint();
        content.revalidate();
    }

    public static void start(){
        for (int i = 0; i < Grid.SIZE; i++){
            for (int j = 0; j < Grid.SIZE; j++){
                Grid.cells[i][j] = 0;
            }
        }
        reset();
        Randoming.randAppear();
        output();
    }

    public static void move(){
        reset();
        Randoming.randAppear1();
        output();
    }

    public static void mainFrame(){
        frame = new JFrame("2048");
        frame.setVisible(true);
        frame.setContentPane(content);
        frame.setSize(420, 440); //w:h
        frame.setLocationRelativeTo(null);
        content.setLayout(new GridLayout(4, 4));
        content.setBackground(Color.white);
    }

    public static void output(){
        for (int i = 0; i < Grid.SIZE; i++){
            for (int j = 0; j < Grid.SIZE; j++){
                if (Grid.cells[i][j] != 0){
                    JLabel label = new JLabel("" + Integer.toString(Grid.cells[i][j]));
                    label.setFont(new Font("Arial", Font.BOLD, 35));
                    label.setForeground(Color.WHITE);
                    Border border = BorderFactory.createLineBorder(Color.lightGray, 3);
                    label.setBorder(border);
                    switch (Grid.cells[i][j]) {
                        case 2:
                            label.setBackground(new Color (238, 221, 130));
                            break;
                        case 4:
                            label.setBackground(new Color (255, 215, 0));
                            break;
                        case 8:
                            label.setBackground(new Color (255, 175, 0));
                            break;
                        case 16:
                            label.setBackground(new Color(255, 140, 0));
                            break;
                        case 32:
                            label.setBackground(new Color(255, 69, 0));
                            break;
                        case 64:
                            label.setBackground(Color.RED);
                            break;
                        case 128:
                            label.setBackground(new Color(178, 34, 34));
                            break;
                        case 256:
                            label.setBackground(new Color(176, 48, 96));
                            break;
                        case 512:
                            label.setBackground(new Color(208, 32, 144));
                            break;
                        case 1024:
                            label.setBackground(new Color(148, 0, 211));
                            break;
                        case 2048:
                            label.setBackground(new Color(105, 89, 205));
                            break;
                        default:
                            label.setBackground(Color.YELLOW);
                    }
                    label.setOpaque(true);
                    label.setHorizontalAlignment(JLabel.CENTER);
                    label.setVerticalAlignment(JLabel.CENTER);
                    content.add(label);
                }
                else {
                    JLabel lbl = new JLabel("");
                    content.add(lbl);
                }
            }
        }
        boolean isFull = true;
        boolean win = false;

        for (int i=0; i< Grid.SIZE; i++) {
            for (int j=0; j< Grid.SIZE; j++) {
                if (Grid.cells[i][j]==0)
                    isFull = false;
                if (Grid.cells[i][j]==2048)
                    win = true;
            }
        }
        if (isFull) JOptionPane.showMessageDialog(View.frame, "Game over!");
        if (win) {
            JOptionPane.showMessageDialog(View.frame, "You win!");
            start();
        }
    }
}