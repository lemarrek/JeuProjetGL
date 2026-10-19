package fr.polytech.jeu.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Case {
    private final List<Element> elements = new ArrayList<>();

    void ajouter(Element e) {
        elements.add(e);
    }

    void retirer(Element e) {
        elements.remove(e);
    }

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
