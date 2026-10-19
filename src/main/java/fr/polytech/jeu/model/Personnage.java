package fr.polytech.jeu.model;


public abstract class Personnage extends Element {
    private int pointsDeVie;

    protected Personnage(int x, int y, int pointsDeVie) {
        super(x, y);
        this.pointsDeVie = pointsDeVie;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public boolean estVivant() {
        return pointsDeVie > 0;
    }

    public void subirDegats(int degats) {
        pointsDeVie = Math.max(0, pointsDeVie - degats);
    }

    @Override
    public boolean estBloquant() {
        return false; 
    }
}
