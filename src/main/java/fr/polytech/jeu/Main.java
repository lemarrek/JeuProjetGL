package fr.polytech.jeu;

import javax.swing.SwingUtilities;

import fr.polytech.jeu.view.Vue;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Vue vue = new Vue();
            vue.afficher();
			System.out.println("Start game...");
			Game game = new Game();
        });
    }
}