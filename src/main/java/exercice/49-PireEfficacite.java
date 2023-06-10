import java.util.ArrayList;
import java.util.List;

public class PireEfficacite {
    public static List<String> sortWords(String texte, List<Character> ordre) {
        List<String> sortedWords = new ArrayList<>();
        String[] words = texte.split(" ");

        for (char c : ordre) {
            for (String word : words) {
                if (word.charAt(0) == c) {
                    sortedWords.add(word);
                }
            }
        }

        return sortedWords;
    }

    public static void main(String[] args) {
        String texte = "Il fait beau aujourd'hui comme en aout";
        List<Character> ordre = List.of('f', 'I', 'z', 'u', 'k', 'a', 'b', 'o');

        List<String> sortedWords = sortWords(texte, ordre);

        for (String word : sortedWords) {
            System.out.println(word);
        }
    }
}
