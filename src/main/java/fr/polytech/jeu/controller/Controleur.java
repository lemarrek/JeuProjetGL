package fr.polytech.jeu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import fr.polytech.jeu.model.Model;
import fr.polytech.jeu.view.Vue;

public class Controleur implements ActionListener {
    private Model model;
    private Vue vue;

    public Controleur(Model model, Vue vue) {
        this.model = model;
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Implémenter la logique de contrôle ici
    }
}
