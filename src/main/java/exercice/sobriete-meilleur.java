package exercice;

import java.util.*;

public class Exercice {
    
    public static List<String> solution(String str, List<Character> ordre) {
        
        List<String> mots = new ArrayList<>();
        StringBuilder motCourant = new StringBuilder();
        Set<Character> ordreSet = new HashSet<>(ordre);

        for (int i = 0; i < str.length(); i++) {
            char c = Character.toLowerCase(str.charAt(i));

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

        mots.sort(Comparator.comparingInt(a -> {
            for (int i = 0; i < a.length(); i++) {
                char c = Character.toLowerCase(a.charAt(i));
                if (!ordreSet.contains(c)) {
                    return ordre.size();
                }
            }
            return ordre.indexOf(Character.toLowerCase(a.charAt(0)));
        }));

        return mots;

    }
}


