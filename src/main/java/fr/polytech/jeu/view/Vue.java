package fr.polytech.jeu.view;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

import fr.polytech.jeu.model.Model;
import fr.polytech.jeu.model.Observateur;

public class Vue implements Observateur{
    private JFrame fenetre;
    private final PanneauJeu panneau;

    public Vue(Model model) {
        fenetre = new JFrame("1ception");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panneau = new PanneauJeu(model);
        fenetre.add(panneau);
        fenetre.pack(); 
        fenetre.setLocationRelativeTo(null);
    }

    public void afficher() {
        fenetre.setVisible(true);
    }

    public void addKeyListener(KeyListener listener) {
        fenetre.addKeyListener(listener);
    }

    @Override 
    public void miseAJour() {
        panneau.repaint();
    }
}