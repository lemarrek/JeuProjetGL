package fr.polytech.jeu.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public final class ChargeurNiveau {

    private ChargeurNiveau() {

    }

    /**
     * Charge un niveau depuis les ressources du projet.
     * @param chemin 
     */
    public static Grille charger(String chemin) {
        InputStream flux = ChargeurNiveau.class.getResourceAsStream(chemin);
        if (flux == null) {
            throw new NiveauInvalideException("Niveau introuvable : " + chemin);
        }
        List<String> lignes = new ArrayList<>();
        try (BufferedReader lecteur = new BufferedReader(new InputStreamReader(flux, StandardCharsets.UTF_8))) {
            String ligne;
            while ((ligne = lecteur.readLine()) != null) {
                if (!ligne.isBlank()) { // on ignore les lignes vides (fin de fichier...)
                    lignes.add(ligne);
                }
            }
        } catch (IOException e) {
            throw new NiveauInvalideException("Erreur de lecture de " + chemin, e);
        }
        return depuisLignes(lignes);
    }

    public static Grille depuisLignes(List<String> lignes) {
        verifierFormat(lignes);

        Grille grille = new Grille(lignes.get(0).length(), lignes.size());
        for (int y = 0; y < lignes.size(); y++) {
            String ligne = lignes.get(y);
            for (int x = 0; x < ligne.length(); x++) {
                Element e = creerElement(ligne.charAt(x), x, y);
                if (e != null) {
                    grille.ajouter(e);
                }
            }
        }
        return grille;
    }

    private static Element creerElement(char c, int x, int y) {
        switch (c) {
            case ' ':
            case '.':
                return null; // case vide
            case 'J': return new Joueur(x, y);
            case 'P': return new Porte(x, y);
            default:
                TypeDecor decor = TypeDecor.depuisSymbole(c);
                if (decor != null) {
                    return new Decor(decor, x, y);
                }
                throw new NiveauInvalideException(
                    "Caractère inconnu '" + c + "' en ligne " + (y + 1) + ", colonne " + (x + 1));
        }
    }

    private static void verifierFormat(List<String> lignes) {
        if (lignes.isEmpty()) {
            throw new NiveauInvalideException("Le niveau est vide");
        }
        int largeur = lignes.get(0).length();
        int nbJoueurs = 0;
        for (int y = 0; y < lignes.size(); y++) {
            String ligne = lignes.get(y);
            if (ligne.length() != largeur) {
                throw new NiveauInvalideException("Ligne " + (y + 1) + " : longueur " + ligne.length()
                    + " au lieu de " + largeur + " (toutes les lignes doivent avoir la même longueur)");
            }
            for (char c : ligne.toCharArray()) {
                if (c == 'J') {
                    nbJoueurs++;
                }
            }
        }
        if (nbJoueurs != 1) {
            throw new NiveauInvalideException("Le niveau doit contenir exactement un joueur (J), trouvé : " + nbJoueurs);
        }
    }
}