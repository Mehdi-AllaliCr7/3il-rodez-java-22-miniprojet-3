package Modele;

import java.io.*;
import java.util.*;

public class MotAleatoire {
    private static final String FICHIER_MOTS = "mots.txt"; // Chemin du fichier contenant les mots à deviner

    // Méthode pour lire le mot et sa définition à partir d'une liste de phrases
    public static List<String[]> lireMotsEtDefinitions() {
        List<String[]> motsEtDefinitions = new ArrayList<>();

        // Lecture du fichier mots.txt et récupération des mots et de leurs définitions
        try (BufferedReader reader = new BufferedReader(new FileReader(FICHIER_MOTS))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] motsDefinition = ligne.split(" ", 2); // Séparer le mot de sa définition
                motsEtDefinitions.add(motsDefinition);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf(motsEtDefinitions.toString());
        return motsEtDefinitions;
    }

}
