package concours_algo;
import java.util.List;

public class SimpliciteMeilleur {
	
	public static boolean comparateur(String mot1, String mot2,List<Character> ordre) {
		int i;
		int un =999;
		int deux =999;
		for(i=0;i<ordre.size();i++) {
			if (mot1.charAt(0)==(ordre.get(i))) {
				un=i;
			}
			if (mot2.charAt(0)==(ordre.get(i))) {
				deux=i;
			}
		}
		if (un>=deux) {
			return true;
		}else {
			return false;
		}
	}
	public static void Tribulle( String[] mots,List<Character> ordre) {
		String ech ="";
		boolean permut = true;
		while(permut==true) {
			permut=false;
			for(int i=0; i<mots.length-1;i++) {
				if (comparateur(mots[i],mots[i+1], ordre)) {
					ech = mots[i];
					mots[i]=mots[i+1];
					mots[i+1]=ech;
					permut=true;
				}
			}
		}
	}
	public static void main (String texte, List<Character> ordre) {
		 String[] mots = new String[30];
		 mots=texte.split(" ");
		 Tribulle(mots, ordre);
		for (int i =0; i<mots.length;i++) {
			System.out.print(mots[i]+" ");
		}
	}	
}