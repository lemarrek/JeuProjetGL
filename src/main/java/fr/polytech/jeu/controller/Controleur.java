package fr.polytech.jeu.controller;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import fr.polytech.jeu.model.Model;
import fr.polytech.jeu.view.Vue;

public class Controleur implements KeyListener {
    private Model model;
    private Vue vue;

    public Controleur(Model model, Vue vue) {
        this.model = model;
        this.vue = vue;
    }

    public void demarrer() {
        vue.addKeyListener(this);
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
                System.out.println("Gauche");
                break;

            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                System.out.println("Droite");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
