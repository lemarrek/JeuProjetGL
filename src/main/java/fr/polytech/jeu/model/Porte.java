package fr.polytech.jeu.model;

public class Porte extends Element {

    public Porte(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean estBloquant() {
        return false; 
    }

    @Override
    public String toString() {
        return "P";
    }
}