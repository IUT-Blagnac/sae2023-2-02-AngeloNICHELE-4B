package exercice;

import java.util.*;

public class Exercice {

public static List<String> solution(String str, List<Character> ordre) {
List<String> M = Arrays.asList(str.split("\\P{L}+"));
M.sort(Comparator.comparing(m -> {
for (int i = 0; i < m.length(); i++) {
int j = ordre.indexOf(Character.toLowerCase(m.charAt(i)));
if (j != -1) {
return j;}}
return ordre.size();}));
return M;
}

}
