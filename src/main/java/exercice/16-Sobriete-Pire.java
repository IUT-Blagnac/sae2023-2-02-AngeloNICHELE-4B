package exercice;
import java.util.ArrayList;
import java.util.List;
public class Exercice {
public static List<String> solution(String str, List<Character> ordre) {
List<String> mots = new ArrayList<>();
StringBuilder motActuel = new StringBuilder();
boolean debutMot = true;
for (int i = 0; i < str.length(); i++) {
char caractere = str.charAt(i);
if (caractere == ' ') {
if (debutMot && motActuel.length() > 0) {
mots.add(motActuel.toString());
motActuel.setLength(0);
} else {
motActuel.append(caractere);
}
debutMot = true;
} else if (debutMot && ordre.contains(caractere)) {
if (motActuel.length() > 0) {
mots.add(motActuel.toString());
motActuel.setLength(0);
}
motActuel.append(caractere);
debutMot = false;
} else {
motActuel.append(caractere);
debutMot = false;
}
}
if (debutMot && motActuel.length() > 0) {
mots.add(motActuel.toString());
}
return mots;
}
}
