package fr.polytech.jeu.view;

import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Vue {
    private JFrame fenetre;

    public Vue() {
        fenetre = new JFrame("Projet GL");
        fenetre.setSize(800, 600);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLocationRelativeTo(null);

        // Ajout direct du texte à la fenêtre
        fenetre.add(new JLabel("Bienvenue dans le jeu", JLabel.CENTER));
    }

    public void afficher() {
        fenetre.setVisible(true);
    }

    public void addKeyListener(KeyListener listener) {
        fenetre.addKeyListener(listener);
    }
}