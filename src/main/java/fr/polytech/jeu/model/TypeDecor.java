package fr.polytech.jeu.model;

public enum TypeDecor {
    FEUILLE('F', false),
    ARBRE('T', false),
    NUAGE('N', false),
    ROCHER('R', true),
    MUR('#', true);

    private final char symbole;
    private final boolean bloquant;

    TypeDecor(char symbole, boolean bloquant) {
        this.symbole = symbole;
        this.bloquant = bloquant;
    }

    public char getSymbole() {
        return symbole;
    }

    public boolean estBloquant() {
        return bloquant;
    }

    public static TypeDecor depuisSymbole(char c) {
        for (TypeDecor t : values()) {
            if (t.symbole == c) {
                return t;
            }
        }
        return null;
    }
}
