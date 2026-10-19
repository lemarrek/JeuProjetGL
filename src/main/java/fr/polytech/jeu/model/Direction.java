package fr.polytech.jeu.model;


public enum Direction {
    GAUCHE(-1),
    DROITE(1);

    private final int dx;

    Direction(int dx) {
        this.dx = dx;
    }

    public int getDx() {
        return dx;
    }
}
