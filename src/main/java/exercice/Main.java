package exercice;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        double startTime = System.currentTimeMillis();
        String texte = "exemple de texte a classer";
        List<Character> ordre = List.of('c', 't', 'e', 'x', 'a', 'm', 'p', 'l', 's', 'r', 'd');
        System.out.println(Exercice.solution(texte,ordre));
        double endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)/1000+"s");
        // output: [classer, texte, exemple, a, de]

    }
}
