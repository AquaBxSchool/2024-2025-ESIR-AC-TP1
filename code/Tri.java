public class Tri {

	/*
	* Trie le tableau t via la méthode du "Tri par insertion".
	* Cette méthode divise le tableau en deux sous-listes : triée et non triée.
	* À chaque itération, un élément de la sous-liste non triée est inséré
	* à la position correcte dans la sous-liste triée.
	* 
	* @param t : tableau d'entiers à trier
	* @return : aucun (tableau trié)
	*/
	public static void triInsertion(int[] t) {
		// Parcourt chaque élément à partir du second
		for (int j = 1; j < t.length; j++) {
			int clef = t[j]; // Élément courant à insérer
			int i = j - 1;   // Index de l'élément précédent dans la partie triée

			// Décale les éléments plus grands que clef vers la droite
			while (i >= 0 && t[i] > clef) {
				t[i + 1] = t[i]; // Décalage à droite
				i--;             // Passe à l'élément précédent
			}
			t[i + 1] = clef; // Insère clef à sa position correcte
		}
	}

	/*
	 * Tri le tableau t via la méthode "Tri fusion" (cf TD2 exo 5)
	 */
	public static void triFusion(int[] t){
		if (t.length>0)
			triFusion(t, 0, t.length-1);
	}

	/*
	* Sous-fonction récursive pour le tri fusion.
	* Trie le sous-tableau t de l'index debut à l'index fin.
	* 
	* @param t : tableau à trier
	* @param debut : index de début du sous-tableau
	* @param fin : index de fin du sous-tableau
	*/
	private static void triFusion(int[] t, int debut, int fin) {
		if (debut < fin) {
			int milieu = (debut + fin) / 2;   // Calcule le milieu du sous-tableau
			triFusion(t, debut, milieu);      // Trie la première moitié
			triFusion(t, milieu + 1, fin);    // Trie la seconde moitié
			fusionner(t, debut, milieu, fin); // Fusionne les deux moitiés triées
		}
	}

	/* Sous-fonction pour le tri fusion
	 * Suppose que, dans le tableau t, 
	 *       les 2 sous-tableaux t[deb1]..t[fin1] et t[fin1+1]..[t[fin2] sont déjà triés
	 * Fusionne ces 2 sous-tableaux pour que le sous-tableau t[deb1]..t[fin2] soit trié
	 */
	private static void fusionner(int[] t, int deb1, int fin1, int fin2){
		int deb2 = fin1+1;
		//on recopie les éléments du début du tableau
		int[] t1 = new int[fin1-deb1+1];
		for(int i=deb1;i<=fin1;i++){
			t1[i-deb1]=t[i];
        }
		int compt1=deb1;
	    int compt2=deb2;
	    for(int i=deb1;i<=fin2;i++){        
	        if (compt1==deb2) //c'est que tous les éléments du premier tableau ont été utilisés
	            break; //tous les éléments ont donc été classés
	        else if (compt2==(fin2+1)){ //c'est que tous les éléments du second tableau ont été utilisés
	            t[i]=t1[compt1-deb1]; //on ajoute les éléments restants du premier tableau
	            compt1++;
	        }
	        else if (t1[compt1-deb1]<t[compt2]){
	            t[i]=t1[compt1-deb1]; //on ajoute un élément du premier tableau
	            compt1++;
	        }
	        else{
	            t[i]=t[compt2]; //on ajoute un élément du second tableau
	            compt2++;
	        }
        }
    }
}