package fr.polytech.jeu.model;

public class Joueur extends Personnage {
    private static final int VIE_INITIALE = 3;

    private Direction regard = Direction.DROITE;

    public Joueur(int x, int y) {
        super(x, y, VIE_INITIALE);
    }

    public Direction getRegard() {
        return regard;
    }

    void setRegard(Direction regard) {
        this.regard = regard;
    }

    @Override
    public String toString() {
        return "J";
    }
}
