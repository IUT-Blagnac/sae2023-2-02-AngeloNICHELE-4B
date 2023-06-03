package exercice;

import java.util.*;

public class Exercice {

    public static List<String> solution(String str, List<Character> ordre) {
        List<String> mots = new ArrayList<>();

        StringBuilder motCourant = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                motCourant.append(c);
            } else {
                if (motCourant.length() > 0) {
                    mots.add(motCourant.toString());
                    motCourant.setLength(0);
                }
            }
        }

        if (motCourant.length() > 0) {
            mots.add(motCourant.toString());
        }

        ordonnerMots(mots, ordre);

        return mots;
    }

    private static void ordonnerMots(List<String> mots, List<Character> ordre) {
        for (int i = 0; i < mots.size(); i++) {
            int minIndex = i;

            for (int j = i + 1; j < mots.size(); j++) {
                if (comparerMots(mots.get(j), mots.get(minIndex), ordre) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                String temp = mots.get(i);
                mots.set(i, mots.get(minIndex));
                mots.set(minIndex, temp);
            }
        }
    }

    private static int comparerMots(String mot1, String mot2, List<Character> ordre) {
        int len1 = mot1.length();
        int len2 = mot2.length();
        int minLen = Math.min(len1, len2);

        for (int i = 0; i < minLen; i++) {
            char char1 = Character.toLowerCase(mot1.charAt(i));
            char char2 = Character.toLowerCase(mot2.charAt(i));

            int index1 = ordre.indexOf(char1);
            int index2 = ordre.indexOf(char2);

            if (index1 != index2) {
                return Integer.compare(index1, index2);
            }
        }

        return Integer.compare(len1, len2);
    }
}
