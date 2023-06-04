package exercice;

import java.util.*;

public class Exercice {

    public static List<String> solution(String str, List<Character> ordre) {
        
        List<String> mots = new ArrayList<>();

        int[] indexOrdre = new int[26];
        for (int i = 0; i < ordre.size(); i++) {
            char lettre = Character.toLowerCase(ordre.get(i));
            indexOrdre[lettre - 'a'] = i;
        }

        int debut = 0;
        int fin = 0;

        while (fin <= str.length()) {
            if (fin == str.length() || !Character.isLetter(str.charAt(fin))) {
                if (debut != fin) {
                    String mot = str.substring(debut, fin);
                    int indexInsertion = trouverIndexInsertion(mots, mot, indexOrdre);
                    mots.add(indexInsertion, mot);
                }
                debut = fin + 1;
            }
            fin++;
        }

        return mots;
    }

    private static int trouverIndexInsertion(List<String> mots, String mot, int[] indexOrdre) {
        int gauche = 0;
        int droite = mots.size() - 1;

        while (gauche <= droite) {
            int milieu = gauche + (droite - gauche) / 2;
            String motMilieu = mots.get(milieu);
            int comparaison = comparerMots(mot, motMilieu, indexOrdre);

            if (comparaison < 0) {
                droite = milieu - 1;
            } else if (comparaison > 0) {
                gauche = milieu + 1;
            } else {
                return milieu;
            }
        }

        return gauche;
    }

    private static int comparerMots(String mot1, String mot2, int[] indexOrdre) {
        int longueur1 = mot1.length();
        int longueur2 = mot2.length();
        int minLongueur = Math.min(longueur1, longueur2);

        for (int i = 0; i < minLongueur; i++) {
            char char1 = Character.toLowerCase(mot1.charAt(i));
            char char2 = Character.toLowerCase(mot2.charAt(i));

            int index1 = indexOrdre[char1 - 'a'];
            int index2 = indexOrdre[char2 - 'a'];

            if (index1 != index2) {
                return Integer.compare(index1, index2);
            }
        }

        return Integer.compare(longueur1, longueur2);
    }

}
