package exercice;

import java.util.ArrayList;
import java.util.List;

public class SimplicitePire {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> result = new ArrayList<>();

        /*
            Nous pouvons dans un premier temps séparer la chaine de caractère en mots
            Pour cela, nous allons utiliser la méthode split de la classe String
            Nous allons utiliser un regex pour séparer les mots
        */
        String[] mots = str.split("[^a-zA-Z0-9]");

        // On supprime les mots vides de la liste
        for (int i = 0; i < mots.length; i++) {
            if (mots[i].equals("")) {
                mots[i] = " ";
            }
        }

        /*
            Nous allons maintenant trier les mots en fonction de l'ordre donné
            Nous stockerons les mots triés dans la liste result
        */
        // On parcours l'ordre donné
        for (Character c : ordre) {
            // Nous allons parcourir les mots
            for (String mot : mots) {
                System.out.println(mot);
                // Si le mot commence par la lettre courante de l'ordre
                if (mot.charAt(0) == c) {
                    // On ajoute le mot à la liste result
                    //System.out.println(mot);
                    result.add(mot);
                }
            }
        }
        // Si l'ordre n'est pas complet, on ajoute les mots restants
        if (str.isEmpty()) {
            result.add("");
        } else {
            for (String mot : mots) {
                if (!result.contains(mot) && !mot.equals(" ")) {
                    result.add(mot);
                }
            }
        }
        return result;
    }
}