import java.util.ArrayList;

/**
 *  Un Professeur dans un jeu d'aventure. <p>
 *
 *  Cette classe fait partie du logiciel Zork, un jeu d'aventure simple en mode
 *  texte.</p> <p>
 *
 *  Un "Professeur" est un personnage capable de se déplacer dans le jeu,
 *  de son propre chef(ordinateur).
 *  Il a pour nom Professeur et possede un nom, une activite, une humeur et un tableau d'activites valides.</p>
 *
 * @author Diallo Mamoudou
 * @author Diallo Elhadj Mamadou Yero
 * @version    1.1
 * @since      August 2000
 */


public class Professeur extends Personnage{
	private final static String activitesValides[] = {"deplace","surveille","corrige","enseigner","conseil","manger"};

	/**
	 *  Initialise un Professeur.
	 *  Initialement, cet Professeur possède un nom
	 *  ,une activite, un tableau d'activites valides et son humeur.
	 *
	 * @param  nom  La chaine de caractères qui identifie ce Professeur
	 * @param  activite  La chaine de caractères qui decrit son activite
	 * @param  humour  Le booleen qui decrit son humeur
	 * @requires nom != null;
	 * @requires activite != null;
	 *
	
	 * @throws NullPointerException si la chaîne de caractères spécifiée est null.
	 */
	public Professeur(String nom, String activite, boolean humeur){
		super(nom, activite, humeur);
	}

	/**
	 *  Renvoie l'activite specifie (i.e. le numero dans le tableau spécifiée comme
	 *  parametre de la methode).
	 * @param indice de l'activite dans le tableau
	 * @return    nom de l'activite
	 *
	 * @pure
	 */
	public String getActiviteValide(int i){
		return activitesValides[i];
	}	
	
	/**
	 *  Teste si cette activite est une activite se trouvant dans le tableau
	 *  d'activites Valides.
	 *
	 * @return    true si cette activite est valide ; false sinon
	 */
	public boolean estActivite(String aString) {
		for (int i = 0; i < activitesValides.length; i++) {
			if (activitesValides[i].equals(aString)) {
				return true;
			}
		}
		return false;
	}

	/**
	* Test si l'activite est egale à l'une des activites valides du tableau 	
	* et appelle la methode correspondante
	*/
	public void parler(){
		
		if (this.getActivite().equals("deplace")) {
		}else if (this.getActivite().equals("surveille")) {
			afficherSurveille();
			return;
		}else if (this.getActivite().equals("corrige")) {
			afficherCorrige();
			return;
		}else if (this.getActivite().equals("enseigner")) {
			afficherEnseigner();		
			return;
		} else if (this.getActivite().equals("conseil")) {
			//Verifie si le prof est de bonne humeur
			if(this.getHumeur() == true)
				afficherConseil();
			return;
		} else if (this.getActivite().equals("manger")) {
			afficherManger();
			return;
		}
	}
	
	
	/** Affiche des messages correspondants aux activites*/
	public void attaque(){
		System.out.println("Vous ne pouvez pas attaquer " + getNom() + ".\n");
	}
	
	public void afficherSurveille() {
		System.out.println("Le professeur " + getNom() + " surveille la salle.\n");
		
	}
	public void afficherCorrige() {
		System.out.println("Le professeur " + getNom() + " corrige des copies.\n");
	}
	
	public void afficherEnseigner() {
		System.out.println("Le professeur" + getNom() + " est entrain d'enseigner.\n");
	}

	public void afficherConseil() {
		System.out.println("Vous pouvez donner objets aux personnages.\n");
	}

	public void afficherManger() {
		System.out.println("Le professeur" + getNom() + " prend un repas.\n");
	}

	/**
	 * Compare cet etre avec l'etre spécifié et renvoie <code>true</code> si
	 * et seulement si cet etre est un Etre Anime de même nom possédant les mêmes
	 * caracteristiques
	 * 
	 * 
	 *
	 * 
	 * @ensures !(e instanceof Professeur ) ==> !\result;
	 * @ensures \result ==> getNom().equals(((Professeur) e).getNom());
	 * 
	 * 
	 * 
	 * @param          le Professeur à comparer
	 * @return <code>true</code> si l'etre spécifié est un Professeur
	 *         
	 * @pure
	 */
	public boolean equals(EtreAnime e){
		
		boolean res = false;
		
		if(!(e instanceof Professeur)){
			return false;
		}
		
		Professeur ea = (Professeur)e;
		
		if(this.getNom().equals(ea.getNom()) && this.getActivite().equals(ea.getActivite()) && this.getHumeur()==ea.getHumeur()){
			res = true;
		}
		
		return res;
	}
	
	/**
	 *  Renvoie un code de hashage pour ce Professeur
	 *
	 * @return    un code de hashage pour cet Professeur
	 */
	public int hashCode(){
			return this.getNom().hashCode();
	}
	
	/**
	 *  Renvoie une nom succincte sous forme de chaîne de caractères
	 *  de ce gardien.
	 *
	 * @return    Une description succincte de ce Professeur
	 */	
	public String toString(){
		return this.getNom() + " activite" + this.getActivite() + " humeur " + this.getHumeur() + "\n";
	}


}
