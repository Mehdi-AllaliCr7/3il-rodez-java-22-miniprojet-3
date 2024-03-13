package Controleur;

import Modele.GestionMot;
import Vue.VuePendu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class PenduControleurTest {
    private VuePendu vue;
    private GestionMot gestionMots;
    private PenduControleur penduControleur;

    @BeforeEach
    public void setUp() {
        vue = new VuePendu();
        gestionMots = new GestionMot();
        penduControleur = new PenduControleur(vue, gestionMots);
    }

    @Test
    public void testProposerLettreCorrecte() {
        // Supposons que le mot à deviner est "JAVA" et que la lettre 'A' est correcte
        penduControleur.proposerLettre('A');
        assertEquals("A ", vue.getLettresProposees()); // Vérifie si la lettre proposée est ajoutée aux lettres proposées
        assertEquals("A___", vue.getMot()); // Vérifie si la lettre correcte est affichée dans le mot à deviner
    }

    @Test
    public void testProposerLettreIncorrecte() {
        // Supposons que le mot à deviner est "JAVA" et que la lettre 'Z' est incorrecte
        penduControleur.proposerLettre('Z');
        assertEquals("Z ", vue.getLettresProposees()); // Vérifie si la lettre proposée est ajoutée aux lettres proposées
        assertNotEquals("Z___", vue.getMot()); // Vérifie si la lettre incorrecte n'est pas affichée dans le mot à deviner
    }
}
