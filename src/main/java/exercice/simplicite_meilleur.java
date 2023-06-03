package exercice;

import java.util.*;

public class Exercice {

    public static List<String> solution(String str, List<Character> ordre) {

        List<String> mots = Arrays.asList(str.split("\\P{L}+"));

        mots.sort(Comparator.comparing(mot -> {

            for (int i = 0; i < mot.length(); i++) {

                char lettre = Character.toLowerCase(mot.charAt(i));
                int indiceLettre = ordre.indexOf(lettre);

                if (indiceLettre != -1) {
                    return indiceLettre;
                }
            }

            return ordre.size();

        }));

        return mots;

    }
}
