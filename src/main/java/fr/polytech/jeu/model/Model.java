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
        if (partieGagnee) {
            return false;
        }
        joueur.setRegard(direction);
        boolean aBouge = essayerDeplacer(direction.getDx(), 0);
        if (aBouge) {
            notifierObservateurs();
        }
        return aBouge;
    }

    public void sauter() {
        if (partieGagnee || joueur.getEtat() != EtatJoueur.AU_SOL) {
            return;
        }
        joueur.setEtat(EtatJoueur.EN_SAUT);
        joueur.setMonteeRestante(Joueur.HAUTEUR_SAUT);
    }



    public void tic() {
        if (partieGagnee) {
            return;
        }
        switch (joueur.getEtat()) {
            case EN_SAUT:
                // on monte d'une case si c'est possible et s'il reste de l'élan
                if (joueur.getMonteeRestante() > 0 && essayerDeplacer(0, -1)) {
                    joueur.setMonteeRestante(joueur.getMonteeRestante() - 1);
                } else {
                    // plus d'élan, ou tête contre un plafond : on commence à tomber
                    joueur.setMonteeRestante(0);
                    joueur.setEtat(EtatJoueur.EN_CHUTE);
                }
                break;

            case EN_CHUTE:
                if (!essayerDeplacer(0, 1)) {
                    joueur.setEtat(EtatJoueur.AU_SOL); // quelque chose sous les pieds : atterrissage
                }
                break;

            case AU_SOL:
                if (!estAuSol()) {
                    joueur.setEtat(EtatJoueur.EN_CHUTE); // le sol a disparu (on a marché dans le vide)
                }
                break;
        }
        notifierObservateurs();
    }

    private boolean estAuSol() {
        return grille.estBloquante(joueur.getX(), joueur.getY() + 1);
    }

    private boolean essayerDeplacer(int dx, int dy) {
        int nx = joueur.getX() + dx;
        int ny = joueur.getY() + dy;
        if (grille.estBloquante(nx, ny)) {
            return false;
        }
        grille.deplacer(joueur, nx, ny);
        if (grille.getCase(nx, ny).contient(Porte.class)) {
            descendre();
        }
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

    public int getProfondeur() {
        return profondeur;
    }

    public boolean estPartieGagnee() {
        return partieGagnee;
    }
}
