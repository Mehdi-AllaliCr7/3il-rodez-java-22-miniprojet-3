package Controleur;
import Modele.MotAleatoire;
import Vue.PenduFrame;

import java.util.List;

public class PenduControleur {
    private PenduFrame vue;
    private List<String[]> motsEtDefinitions;

    public PenduControleur(PenduFrame vue) {
        this.vue = vue;
        motsEtDefinitions = MotAleatoire.lireMotsEtDefinitions();
        // D'autres initialisations et logique de contrôleur peuvent être ajoutées ici
    }

    // Méthode pour obtenir un mot aléatoire et sa définition
    public String[] obtenirMotEtDefinitionAleatoire() {
        int index = (int) (Math.random() * motsEtDefinitions.size());
        return motsEtDefinitions.get(index);
    }
}
