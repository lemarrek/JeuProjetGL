package fr.polytech.jeu.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private static final String[] NIVEAUX = {
        "/maps/map1.txt",
        "/maps/map2.txt"
    };

    private Grille grille;
    private Joueur joueur;
    private Porte porte;
    private int profondeur;
    private boolean partieGagnee;
    private final List<Observateur> observateurs = new ArrayList<>();


    public Model() {
        this.profondeur = 0;
        this.partieGagnee = false;
        chargerNiveau(NIVEAUX[profondeur]);
    }


    public void ajouterObservateur(Observateur o) {
        observateurs.add(o);
    }

    public void retirerObservateur(Observateur o) {
        observateurs.remove(o);
    }

    private void notifierObservateurs() {
        for (Observateur o : observateurs) {
            o.miseAJour();
        }
    }

    public void chargerNiveau(String chemin) {
        this.grille = ChargeurNiveau.charger(chemin);
        this.joueur = grille.trouver(Joueur.class).get(0);
        this.porte = grille.trouver(Porte.class).get(0); 
        notifierObservateurs();
    }


    public boolean deplacerJoueur(Direction direction) {
        joueur.setRegard(direction);
        int nx = joueur.getX() + direction.getDx();
        int ny = joueur.getY() + direction.getDy();
        if (grille.estBloquante(nx, ny)) {
            return false;
        }
        grille.deplacer(joueur, nx, ny);
        if(porte.getX()==joueur.getX() && porte.getY()==joueur.getY()){
            System.out.println("Porte trouvée");
        }

        if (grille.getCase(nx, ny).contient(Porte.class)) {
            descendre();
        }
        notifierObservateurs();
        return true;
    }


    private void descendre() {
        if (profondeur + 1 < NIVEAUX.length) {
            profondeur++;
            chargerNiveau(NIVEAUX[profondeur]);
        } else {
            partieGagnee = true;
        }
    }

    public Grille getGrille() {
        return grille;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public int getProfondeur(){
        return profondeur;
    }

    public boolean estPartieGagnee(){
        return partieGagnee;
    }
}
