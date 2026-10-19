package fr.polytech.jeu.model;

public class Decor extends Element {
    private final TypeDecor type;

    public Decor(TypeDecor type, int x, int y) {
        super(x, y);
        this.type = type;
    }

    public TypeDecor getType() {
        return type;
    }

    @Override
    public boolean estBloquant() {
        return type.estBloquant();
    }

    @Override
    public String toString() {
        return String.valueOf(type.getSymbole());
    }
}
