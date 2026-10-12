package fr.polytech.jeu;

import javax.swing.SwingUtilities;

import fr.polytech.jeu.controller.Controleur;
import fr.polytech.jeu.model.Model;
import fr.polytech.jeu.view.Vue;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            System.out.println("Start game...");
            Model model = new Model();
            Vue vue = new Vue();
            Controleur controleur = new Controleur(model, vue);
            vue.afficher();
            controleur.demarrer();
        });
    }
}
