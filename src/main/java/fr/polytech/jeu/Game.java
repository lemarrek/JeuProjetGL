package fr.polytech.jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JFrame {

    private JLabel fenetre = new JLabel();
    private JButton boutonPlay = new JButton("play");
    private Timer timer;

    Game() {
        super("1ception");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panneau = new JPanel();
        setSize(1920, 1080);
        panneau.add(fenetre);
        panneau.add(boutonPlay);
        this.add(panneau);

        boutonPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boutonPlay.setText("PLAY");
            }
        });

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        timer.start();
        setVisible(true);

    }
}
