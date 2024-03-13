package Vue;

import Controleur.PenduControleur;
import Modele.GestionMot;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GestionMot gestionMots = new GestionMot();
                VuePendu vuePendu = new VuePendu();
                new PenduControleur(vuePendu, gestionMots);

                vuePendu.setVisible(true);
            }
        });
    }
}
