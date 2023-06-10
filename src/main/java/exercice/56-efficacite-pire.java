package exercice;

import java.util.ArrayList;
import java.util.List;

public class exercice {

    public static List<String> solution(String texte, List<Character> ordre) {
        List<String> mots = new ArrayList<>();

        for (int i = 0; i < ordre.size(); i++) {
            char lettre = ordre.get(i);

            for (int j = 0; j < texte.length(); j++) {
                char caractere = texte.charAt(j);

                if (caractere == ' ') {
                    continue;
                }

                if (caractere == lettre) {
                    StringBuilder motCourant = new StringBuilder();
                    motCourant.append(caractere);

                    for (int k = j + 1; k < texte.length(); k++) {
                        char prochainCaractere = texte.charAt(k);

                        if (prochainCaractere == ' ') {
                            break;
                        }

                        motCourant.append(prochainCaractere);
                    }

                    mots.add(motCourant.toString());
                }
            }
        }

        return mots;
    }
}