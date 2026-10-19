package fr.polytech.jeu.model;


public enum Direction {
    GAUCHE(-1, 0),
    DROITE(1, 0),
    HAUT(0, -1);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
