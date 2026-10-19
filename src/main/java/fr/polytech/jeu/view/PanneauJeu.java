package fr.polytech.jeu.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import fr.polytech.jeu.model.Element;
import fr.polytech.jeu.model.Grille;
import fr.polytech.jeu.model.Joueur;
import fr.polytech.jeu.model.Model;
import fr.polytech.jeu.model.Porte;

/**
 * Dessine la grille du modèle, avec une caméra centrée sur le joueur. Ne
 * modifie jamais le modèle : elle ne fait que le lire.
 */
public class PanneauJeu extends JPanel {

    /**
     * Taille d'une case à l'écran, en pixels (c'est le "zoom").
     */
    private static final int TAILLE_CASE = 40;

    private static final Color FOND = new Color(24, 22, 40);

    private static final Font POLICE_LETTRE = new Font(Font.MONOSPACED, Font.BOLD, TAILLE_CASE * 6 / 10);

    private final Model model;

    public PanneauJeu(Model model) {
        this.model = model;
        setPreferredSize(new Dimension(800, 600));
        setBackground(FOND);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // efface avec la couleur de fond
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Grille grille = model.getGrille();
        Joueur joueur = model.getJoueur();
        int niveau = niveauGraphique();
        // ---- Caméra : décalage pour que le joueur soit au centre du panneau ----
        int decalageX = calculerDecalage(joueur.getX(), getWidth(), grille.getLargeur());
        int decalageY = calculerDecalage(joueur.getY(), getHeight(), grille.getHauteur());

        // ---- Dessin de toutes les cases ----
        for (int y = 0; y < grille.getHauteur(); y++) {
            for (int x = 0; x < grille.getLargeur(); x++) {
                int px = x * TAILLE_CASE - decalageX;
                int py = y * TAILLE_CASE - decalageY;

                // on ne dessine pas ce qui sort de l'écran
                if (px + TAILLE_CASE < 0 || py + TAILLE_CASE < 0 || px > getWidth() || py > getHeight()) {
                    continue;
                }
                for (Element e : grille.getCase(x, y).getElements()) {
                    paintElement(g2, e, px, py, niveau);
                }
            }
        }
        if (model.estPartieGagnee()) {
            g2.setColor(Color.WHITE);
            g2.drawString("Vous avez atteint le rêve le plus profond !", 20, 30);
        }
    }

    private int niveauGraphique() {
        return model.getProfondeur();
    }

    /**
     * Calcule le décalage (en pixels) pour centrer la caméra sur une case, sans
     * montrer de vide au-delà des bords de la carte.
     */
    private int calculerDecalage(int caseJoueur, int tailleEcran, int nbCases) {
        int tailleCarte = nbCases * TAILLE_CASE;
        if (tailleCarte <= tailleEcran) {
            return -(tailleEcran - tailleCarte) / 2; // carte plus petite que l'écran : on la centre
        }
        int decalage = caseJoueur * TAILLE_CASE + TAILLE_CASE / 2 - tailleEcran / 2;
        return Math.max(0, Math.min(decalage, tailleCarte - tailleEcran));
    }

    /**
     * Choisit comment dessiner chaque type d'élément (formes simples en
     * attendant les images).
     */
    private void dessinerLettre(Graphics2D g, String texte, Color couleur, int px, int py) {
        g.setFont(POLICE_LETTRE);
        g.setColor(couleur);
        FontMetrics fm = g.getFontMetrics();

        // horizontal : on retire la moitié de la largeur du texte
        int x = px + (TAILLE_CASE - fm.stringWidth(texte)) / 2;
        // vertical : on part du centre de la case et on descend de la moitié de la hauteur des lettres
        int y = py + (TAILLE_CASE - fm.getHeight()) / 2 + fm.getAscent();

        g.drawString(texte, x, y);
    }

    private void paintElement(Graphics2D g, Element e, int px, int py, int niveau) {
        switch (niveau) {
            case 0:
                dessinerLettre(g, e.toString(), couleurDe(e), px, py);
                break;
            case 1:
                dessinerLettre(g, e.toString(), couleurDe(e), px, py);
                break;

            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;

            default:
                break;
        }

    }

    private Color couleurDe(Element e) {
        if (e instanceof Joueur) {
            return new Color(230, 90, 90);
        } else if (e instanceof Porte) {
            return new Color(255, 255, 20);
        }
        return Color.WHITE;
    }

}
