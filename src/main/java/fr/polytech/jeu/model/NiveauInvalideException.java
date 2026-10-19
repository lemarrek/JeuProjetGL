package fr.polytech.jeu.model;

/** Levée quand un fichier de niveau est introuvable ou mal formé. */
public class NiveauInvalideException extends RuntimeException {

    public NiveauInvalideException(String message) {
        super(message);
    }

    public NiveauInvalideException(String message, Throwable cause) {
        super(message, cause);
    }
}