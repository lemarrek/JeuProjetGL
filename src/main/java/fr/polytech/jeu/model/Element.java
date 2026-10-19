package fr.polytech.jeu.model;


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

    void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract boolean estBloquant();
}
