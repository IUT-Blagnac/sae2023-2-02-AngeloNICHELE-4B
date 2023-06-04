package exercice;

import java.util.*;

public class Exercice {

    public static List<String> solution(String str, List<Character> ordre) {
        List<String> mots = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            String motCourant = "";

            while (i < str.length() && Character.isLetter(str.charAt(i))) {
                motCourant += str.charAt(i);
                i++;
            }

            if (!motCourant.isEmpty()) {
                mots.add(motCourant);
            }
        }

        for (int i = 0; i < mots.size(); i++) {
            for (int j = i + 1; j < mots.size(); j++) {
                String mot1 = mots.get(i);
                String mot2 = mots.get(j);

                int index1 = ordre.indexOf(Character.toLowerCase(mot1.charAt(0)));
                int index2 = ordre.indexOf(Character.toLowerCase(mot2.charAt(0)));

                if (index1 > index2) {
                    String temp = mots.get(i);
                    mots.set(i, mots.get(j));
                    mots.set(j, temp);
                }
            }
        }

        return mots;
    }
}
