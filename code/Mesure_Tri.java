import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mesure_Tri {

	/* Affiche un tableau d'entiers
	 */
	public static void afficher(int [] t){
		System.out.print("[");
		for(int k=0;k<t.length;k++)
			System.out.print(" "+t[k]+" ");
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		//Vérification de l'implémentation des tris
		int [] t = new int[10];
		int [] t2 = new int[10];
		for(int k=0;k<t.length;k++){ //initialisation aléatoire
			t[k]=(int) (Math.random()*100);
			t2[k]=t[k];
		}
		System.out.print("Avant le tri : "); afficher(t);
		Tri.triInsertion(t);
		System.out.print("Après le tri par insertion: "); afficher(t);
		Tri.triFusion(t2);
		System.out.print("Après le tri fusion:        "); afficher(t2);
		
		//Analyse du temps d'exécution
		
		//A FAIRE : adapter les 3 valeurs suivantes pour avoir des mesures significatives
		// surtout la valeurs de la variable taille_fin
		int taille_init = 10000000;
		int taille_fin  = 100000000;
		int nbrMesures = 30;
		
		int taille_incr = (taille_fin-taille_init)/(nbrMesures-1);

		List<Integer> tab_tailles = new ArrayList<Integer>();
		List<Integer> tab_temps = new ArrayList<Integer>();
		for(int n = taille_init; n<taille_fin; n=n+taille_incr){			  
			tab_tailles.add(n); //on sauvegarde la taille
			t = new int[n];

			int type = 2; // 0 : meilleur; 1 : pire; 2 : aléatoire

			//A FAIRE : initialisation de t
            for(int k=0;k<t.length;k++){
                switch (type) {
                    case 0:
                        t[k] = k;
                        break;
                    case 1:
                        t[k] = t.length - k;
                        break;
                    case 2:
                        t[k]=(int) (Math.random()*100);
                        break;
                }
            }

			long date1 = System.currentTimeMillis(); //on lance le chrono
			// Tri.triInsertion(t); //on trie le tableau 
			Tri.triFusion(t); //on trie le tableau 
			long date2 = System.currentTimeMillis(); //on arrête le chrono
			tab_temps.add((int)(date2 - date1)); //on sauvegarde le temps
			System.out.println("Temps de calcul pour n="+n+" : "+ tab_temps.get(tab_temps.size()-1)+" millisecondes.");
		}
		
		// Affichage des mesures effectuées
		Graph g = new Graph(tab_tailles,tab_temps);
		g.display();
	}
}
