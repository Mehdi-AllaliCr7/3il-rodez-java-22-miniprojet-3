package Modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestionMot {
        private List<Mot> mots;


    /**
     * Constructeur de la classe GestionMot.
     * Charge les mots à partir d'un fichier texte lors de l'initialisation de l'objet.
     */
    public GestionMot() {
        mots = new ArrayList<>();
        chargerMots();
    }

    /**
     * Charge les mots à partir du fichier texte "mots.txt".
     * Les mots sont stockés dans une liste de type Mot.
     */
    private void chargerMots() {
        try (BufferedReader br = new BufferedReader(new FileReader("mots.txt"))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parts = ligne.split(" ", 2);
                String mot = parts[0];
                String definition = parts[1];
                mots.add(new Mot(mot, definition));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Choisi un mot aléatoire parmi la liste des mots chargés.
     *
     * @return Un objet Mot représentant le mot choisi aléatoirement.
     */
    public Mot choisirMotAleatoire() {
        Random random = new Random();
        return mots.get(random.nextInt(mots.size()));
    }
}
