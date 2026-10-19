package fr.polytech.jeu.model;

public class Model {

    private static final String MAP1 = "/maps/map1.txt";

    private Grille grille;
    private Joueur joueur;

    public Model() {
        chargerNiveau(MAP1);
    }


    public void chargerNiveau(String chemin) {
        this.grille = ChargeurNiveau.charger(chemin);
        this.joueur = grille.trouver(Joueur.class).get(0); 
    }


    public boolean deplacerJoueur(Direction direction) {
        joueur.setRegard(direction);
        int nx = joueur.getX() + direction.getDx();
        int ny = joueur.getY();
        if (grille.estBloquante(nx, ny)) {
            return false;
        }
        grille.deplacer(joueur, nx, ny);
        return true;
    }

    public Grille getGrille() {
        return grille;
    }

    public Joueur getJoueur() {
        return joueur;
    }
}
