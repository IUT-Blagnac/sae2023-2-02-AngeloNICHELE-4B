package exercice;

import java.util.ArrayList;
import java.util.List;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        str = str.replaceAll("[^\\p{Alnum}]", " ");
        String[] mots = str.split("\\s+");

        List<String> motsHorsOrdre = new ArrayList<>();

        List<String> resultat = new ArrayList<>();

        for (char lettre : ordre) {
            List<String> motsCorrespondants = new ArrayList<>();

            for (int i = 0; i < mots.length; i++) {
                String mot = mots[i];
                if (!mot.isEmpty() && mot.charAt(0) == lettre) {
                    motsCorrespondants.add(mot);
                    mots[i] = "";
                }
            }

            if (!motsCorrespondants.isEmpty()) {
                if (motsCorrespondants.size() > 1) {
                    motsCorrespondants.sort((a, b) -> {
                        for (int i = 1; i < Math.min(a.length(), b.length()); i++) {
                            char charA = Character.toLowerCase(a.charAt(i));
                            char charB = Character.toLowerCase(b.charAt(i));
                            if (charA != charB) {
                                if (ordre.indexOf(charA) != -1) {
                                    return ordre.indexOf(charA) - ordre.indexOf(charB);
                                }
                            }
                        }
                        return 0;
                    });
                }
                resultat.addAll(motsCorrespondants);
            }
        }

        for (String mot : mots) {
            if (!mot.isEmpty()) {
                motsHorsOrdre.add(mot);
            }
        }

        resultat.addAll(motsHorsOrdre);

        return resultat;
    }
}
