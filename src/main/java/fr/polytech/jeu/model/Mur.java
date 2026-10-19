package fr.polytech.jeu.model;

public class Mur extends Element {

    public Mur(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean estBloquant() {
        return true;
    }

    @Override
    public String toString() {
        return "#";
    }
}
