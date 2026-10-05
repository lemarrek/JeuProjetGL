package fr.polytech.jeu;

import fr.polytech.jeu.view.Vue;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Vue vue = new Vue();
            vue.afficher();
        });
    }
}