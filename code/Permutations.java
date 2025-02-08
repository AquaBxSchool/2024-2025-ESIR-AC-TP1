import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static void permutation(String target, String original,boolean afficher){
	    int i;
	    String target1, original1;
	    if (original.length() == 0 && afficher){
	        System.out.println(target);
	    }
		else {
			i = 0;
			while (i < original.length()){
			    target1 = target + original.substring(i,i+1);
			    original1 = original.substring(0,i) + original.substring(i+1,original.length());
			    permutation(target1,original1,afficher);
			    i = i + 1;
			}
		} 
	}

    public static void main(String[] args) {
        String x = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<Integer> tab_n = new ArrayList<>();
        List<Integer> tab_temps = new ArrayList<>();

        // Mesurer le temps d'exécution pour n de 1 à 26
        for (int n = 1; n <= 12; n++) {
            String y = alphabet.substring(0, n);
            tab_n.add(n);

            // Mesure du temps d'exécution
            long startTime = System.currentTimeMillis();
            permutation(x, y, false);  // désactiver l'affichage avec "false"
            long endTime = System.currentTimeMillis();

            int elapsedTime = (int) (endTime - startTime);
            tab_temps.add(elapsedTime);

            System.out.println("Temps de calcul pour n=" + n + " : " + elapsedTime + " millisecondes.");
        }

        Graph g = new Graph(tab_n, tab_temps);
        g.display();
    }

}
