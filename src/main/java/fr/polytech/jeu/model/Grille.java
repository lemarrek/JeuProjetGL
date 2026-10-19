package fr.polytech.jeu.model;

import java.util.ArrayList;
import java.util.List;


public class Grille {
    private final int largeur;
    private final int hauteur;
    private final Case[][] cases;

    public Grille(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.cases = new Case[hauteur][largeur];
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                cases[y][x] = new Case();
            }
        }
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public boolean estDansLaGrille(int x, int y) {
        return x >= 0 && x < largeur && y >= 0 && y < hauteur;
    }

    public Case getCase(int x, int y) {
        if (!estDansLaGrille(x, y)) {
            throw new IndexOutOfBoundsException("Case hors grille : (" + x + ", " + y + ")");
        }
        return cases[y][x];
    }

    public boolean estBloquante(int x, int y) {
        return !estDansLaGrille(x, y) || getCase(x, y).estBloquante();
    }

    public void ajouter(Element e) {
        getCase(e.getX(), e.getY()).ajouter(e);
    }

    public void retirer(Element e) {
        getCase(e.getX(), e.getY()).retirer(e);
    }

    void deplacer(Element e, int nouveauX, int nouveauY) {
        getCase(e.getX(), e.getY()).retirer(e);
        e.setPosition(nouveauX, nouveauY);
        getCase(nouveauX, nouveauY).ajouter(e);
    }


    public <T extends Element> List<T> trouver(Class<T> type) {
        List<T> resultat = new ArrayList<>();
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                for (Element e : cases[y][x].getElements()) {
                    if (type.isInstance(e)) {
                        resultat.add(type.cast(e));
                    }
                }
            }
        }
        return resultat;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                Case c = cases[y][x];
                if (c.estVide()) {
                    sb.append('.');
                } else {
                    // on affiche le dernier élément ajouté (celui "au-dessus")
                    sb.append(c.getElements().get(c.getElements().size() - 1));
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}