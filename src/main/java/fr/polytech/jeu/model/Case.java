package fr.polytech.jeu.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Une case de la grille. Elle peut contenir plusieurs éléments à la fois
 * (par exemple le joueur et un objet).
 */
public class Case {
    private final List<Element> elements = new ArrayList<>();

    void ajouter(Element e) {
        elements.add(e);
    }

    void retirer(Element e) {
        elements.remove(e);
    }

    /** Liste en lecture seule : la vue peut la parcourir, mais pas la modifier. */
    public List<Element> getElements() {
        return Collections.unmodifiableList(elements);
    }

    public boolean estVide() {
        return elements.isEmpty();
    }

    public boolean estBloquante() {
        for (Element e : elements) {
            if (e.estBloquant()) {
                return true;
            }
        }
        return false;
    }
}
