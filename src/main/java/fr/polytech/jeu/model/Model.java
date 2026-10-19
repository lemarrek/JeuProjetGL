package fr.polytech.jeu.model;

public class Model {

    private static final String[] CARTE_TEST = {
        "####################",
        "#..................#",
        "#..................#",
        "#.......###........#",
        "#..................#",
        "#.J.........#......#",
        "####################",
    };

    private final Grille grille;
    private Joueur joueur;

    public Model() {
        this.grille = creerGrille(CARTE_TEST);
        if (joueur == null) {
            throw new IllegalStateException("La carte ne contient pas de joueur (J)");
        }
    }

    /** Construit la grille à partir d'une carte texte (sera déplacé dans un ChargeurNiveau). */
    private Grille creerGrille(String[] carte) {
        Grille g = new Grille(carte[0].length(), carte.length);
        for (int y = 0; y < carte.length; y++) {
            for (int x = 0; x < carte[y].length(); x++) {
                switch (carte[y].charAt(x)) {
                    case '#':
                        g.ajouter(new Mur(x, y));
                        break;
                    case 'J':
                        joueur = new Joueur(x, y);
                        g.ajouter(joueur);
                        break;
                    default:
                        break; 
                }
            }
        }
        return g;
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
