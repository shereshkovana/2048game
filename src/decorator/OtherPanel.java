package decorator;

import logic.Grid;
import logic.Randoming;
import logic.Strategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OtherPanel extends JFrame {
    public OtherPanel() {
        init();
    }
    public static JFrame other = new JFrame("Arrow keys");
    public static JPanel panel = new JPanel();
    public void init() {
        otherFrame();
        JButton up = new JButton("UP");
        panel.add(up, BorderLayout.NORTH);
        JButton down = new JButton("DOWN");
        panel.add(down, BorderLayout.SOUTH);
        JButton left = new JButton("LEFT");
        panel.add(left, BorderLayout.WEST);
        JButton right = new JButton("RIGHT");
        panel.add(right, BorderLayout.EAST);
        JButton reset = new JButton("NEW GAME");
        panel.add(reset, BorderLayout.CENTER);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.start();
            }
        });

        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Strategy.fold(false, true) > 0) {
                    View.move();
                }
            }
        });

        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Strategy.fold(true, true) > 0) {
                    View.move();
                }
            }
        });

        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Strategy.fold(false, false) > 0) {
                    View.move();
                }
            }
        });

        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Strategy.fold(true, false) > 0) {
                    View.move();
                }
            }
        });
    }

    public static void otherFrame(){

        other.setVisible(true);
        other.setContentPane(panel);
        other.setSize(250, 120); //w:h
        other.setLocationRelativeTo(null);
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.white);
        other.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
