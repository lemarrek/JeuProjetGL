package fr.polytech.jeu.model;

/**
 * Tout ce qui peut occuper une case de la grille (mur, joueur, objet, PNJ...).
 */
public abstract class Element {
    private int x;
    private int y;

    protected Element(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Visibilité "package" : seule la Grille (même package) peut changer la position,
     * pour que l'élément et la case qui le contient restent toujours cohérents.
     */
    void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /** Un élément bloquant empêche un personnage d'entrer dans sa case. */
    public abstract boolean estBloquant();
}
