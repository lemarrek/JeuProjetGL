package fr.polytech.jeu.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import fr.polytech.jeu.model.Direction;
import fr.polytech.jeu.model.Model;
import fr.polytech.jeu.view.Vue;

public class Controleur implements KeyListener {
    private Model model;
    private Vue vue;

    private static final int DELAI_TIC_MS = 120;
    private final Timer boucleDeJeu;


    public Controleur(Model model, Vue vue) {
        this.model = model;
        this.vue = vue;
        this.boucleDeJeu = new Timer(DELAI_TIC_MS, e -> model.tic());
    }

    public void demarrer() {
        vue.addKeyListener(this);
        System.out.println(model.getGrille()); // affichage console provisoire
        boucleDeJeu.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_Z:
            case KeyEvent.VK_UP:
                System.out.println("Haut");
                break;

            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                System.out.println("Bas");
                break;

            case KeyEvent.VK_Q:
            case KeyEvent.VK_LEFT:
                model.deplacerJoueur(Direction.GAUCHE);
                break;
            case KeyEvent.VK_SPACE:
                if (model.getProfondeur()>=1){
                model.sauter();
            }
                break;
            
            
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                model.deplacerJoueur(Direction.DROITE);
                break;
        }
        System.out.println(model.getGrille()); // provisoire, en attendant la vraie vue
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}