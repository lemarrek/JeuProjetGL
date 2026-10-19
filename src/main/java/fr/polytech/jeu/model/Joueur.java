package fr.polytech.jeu.model;

public class Joueur extends Personnage {
    private static final int VIE_INITIALE = 3;

    private Direction regard = Direction.DROITE;
    private EtatJoueur etat = EtatJoueur.AU_SOL;
    private int monteeRestante = 0; 
    public static final int HAUTEUR_SAUT = 2;

    public Joueur(int x, int y) {
        super(x, y, VIE_INITIALE);
    }

    public Direction getRegard() {
        return regard;
    }

    public void setRegard(Direction regard) {
        this.regard = regard;
    }

    public void setEtat(EtatJoueur etat) {
        this.etat = etat;
    }

    int getMonteeRestante() {
        return monteeRestante;
    }

     void setMonteeRestante(int monteeRestante) {
        this.monteeRestante = monteeRestante;
    }

    public EtatJoueur getEtat(){
        return etat;
    }

    @Override
    public String toString() {
        return "J";
    }
}
