package fr.polytech.jeu.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Vue {
    private JFrame fenetre;

    public Vue() {
        fenetre = new JFrame("Projet GL");
        fenetre.setSize(800, 600);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLocationRelativeTo(null);

        // Création d'un panneau (Panel)
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        JLabel message = new JLabel("Bienvenue dans le jeu", JLabel.CENTER);
        panel.add(message, BorderLayout.CENTER);

        fenetre.add(panel);
    }

    public void afficher() {
        fenetre.setVisible(true);
    }
}