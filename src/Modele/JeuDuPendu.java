package Modele;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class JeuDuPendu {
    private String motActuel;
    private Set<Character> lettresProposees;
    private int nombreErreurs;
    private int maxErreurs;
    private String motAffiche;

    public JeuDuPendu(String mot, int maxErreurs) {
        this.motActuel = mot.toUpperCase();
        this.lettresProposees = new HashSet<>();
        this.nombreErreurs = 0;
        this.maxErreurs = maxErreurs;
        this.motAffiche = "_".repeat(mot.length());
    }

    public boolean proposerLettre(char lettre) {
        lettre = Character.toUpperCase(lettre);

        if (lettresProposees.contains(lettre) || !Character.isLetter(lettre)) {
            // La lettre a déjà été proposée ou n'est pas une lettre
            return false;
        }

        lettresProposees.add(lettre);

        if (motActuel.contains(String.valueOf(lettre))) {
            // Mise à jour du mot affiché avec les lettres correctement devinées
            mettreAJourMotAffiche(lettre);
            return true;
        } else {
            nombreErreurs++;
            return false;
        }
    }

    private void mettreAJourMotAffiche(char lettre) {
        StringBuilder nouveauMotAffiche = new StringBuilder(motAffiche);
        for (int i = 0; i < motActuel.length(); i++) {
            if (motActuel.charAt(i) == lettre) {
                nouveauMotAffiche.setCharAt(i, lettre);
            }
        }
        motAffiche = nouveauMotAffiche.toString();
    }

    public boolean estGagne() {
        return !motAffiche.contains("_");
    }

    public boolean estPerdu() {
        return nombreErreurs >= maxErreurs;
    }

    public String getMotAffiche() {
        return motAffiche;
    }

    public int getNombreErreurs() {
        return nombreErreurs;
    }

    public List<Character> getLettresProposees() {
        return new ArrayList<Character>(lettresProposees);
    }

    public int getTentativesRestantes() {
        return maxErreurs - nombreErreurs;
    }
}
