package Controleur;

import Modele.GestionMot;
import Modele.Mot;
import Vue.VuePendu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PenduControleur {
    private VuePendu vue;
    private GestionMot gestionMots;
    private Mot motCourant;
    private StringBuilder motCache;
    private StringBuilder lettresProposees;
    private int tentativesRestantes;

    /**
     * Constructeur de la classe PenduControleur.
     *
     * @param vue         La vue du jeu du Pendu.
     * @param gestionMots Gestionnaire de mots pour fournir des mots au jeu.
     */
    public PenduControleur(VuePendu vue, GestionMot gestionMots) {
        this.vue = vue;
        this.gestionMots = gestionMots;
        this.motCache = new StringBuilder();
        this.lettresProposees = new StringBuilder();
        initialiserPartie();
        configurerListeners();
    }

    /**
     * Initialise une nouvelle partie en choisissant un mot aléatoire et en configurant la vue.
     */
    private void initialiserPartie() {
        motCourant = gestionMots.choisirMotAleatoire();
        for (int i = 0; i < motCourant.getMot().length(); i++) {
            motCache.append("_");
        }
        vue.setMot(motCache.toString());
        vue.setDefinition(motCourant.getDefinition());
        tentativesRestantes = 7;
        vue.setLettresProposees("");
    }

    /**
     * Configure les listeners pour les actions de l'utilisateur.
     */
    private void configurerListeners() {
        vue.addProposerListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proposerLettre(vue.getLettreProposee().charAt(0));
            }
        });
    }

    /**
     * Méthode appelée lorsqu'une lettre est proposée par l'utilisateur.
     *
     * @param lettre La lettre proposée par l'utilisateur.
     */
    public void proposerLettre(char lettre) {
        if (!lettresProposees.toString().contains(String.valueOf(lettre))) {
            lettresProposees.append(lettre).append(" ");
            vue.setLettresProposees(lettresProposees.toString());
            boolean lettreCorrecte = false;
            for (int i = 0; i < motCourant.getMot().length(); i++) {
                if (motCourant.getMot().charAt(i) == lettre) {
                    motCache.setCharAt(i, lettre);
                    lettreCorrecte = true;
                }
            }
            if (lettreCorrecte) {
                vue.mettreAJourMot(motCache.toString());
                if (motCache.toString().equals(motCourant.getMot())) {
                    JOptionPane.showMessageDialog(vue, "Vous avez gagné !");
                    recommencerPartie();
                }
            } else {
                tentativesRestantes--;
                if (tentativesRestantes == 0) {
                    JOptionPane.showMessageDialog(vue, "Vous avez perdu. Le mot était : " + motCourant.getMot());
                    recommencerPartie();
                } else {
                    JOptionPane.showMessageDialog(vue, "Lettre incorrecte. Veuillez réessayer.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(vue, "Cette lettre a déjà été proposée.");
        }
    }

    /**
     * Recommence une nouvelle partie en réinitialisant tous les paramètres.
     */
    private void recommencerPartie() {
        initialiserPartie();
    }
}
