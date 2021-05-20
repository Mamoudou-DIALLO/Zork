import java.util.ArrayList;

/**
 *  Un Monstre dans un jeu d'aventure. <p>
 *
 *  Cette classe fait partie du logiciel Zork, un jeu d'aventure simple en mode
 *  texte.</p> <p>
 *
 *  Un "Monstre" est un etre capable de se déplacer dans le jeu,
 *  de son propre chef(ordinateur).
 *  Il a pour nom Gardien et possede un nom, une activite, une humeur et un tableau d'activites valides.</p>
 *
 * @author Diallo Mamoudou
 * @author Diallo Elhadj Mamadou Yero
 * @version    1.1
 * @since      August 2000
 */



public class Monstre extends EtreAnime{
	private final static String activitesValides[] = {"deplace","manger"};
	private int vie;
	
	/**
	 *  Initialise un Monstre
	 *  Initialement, cet Monstre possède un nom
	 *  ,une activite, un tableau d'activites valides et une Vie.
	 *
	 * @param  nom  La chaine de caractères qui identifie cet Monstre
	 * @param  activite  La chaine de caractères qui decrit son activite
	 * @param  vie  Le point de vie du monstre
	 * @requires nom != null;
	 * @requires activite != null;
	 * @requires vie != null;
	
	 * @throws NullPointerException si la chaîne de caractères spécifiée est null.
	 */
		
	public Monstre(String nom, String activite, int vie){
		super(nom, activite);
		this.vie = vie;
	}
	
	//Accesseurs
	
	public int getVie(){
		return this.vie;
	}
	
	public String getActiviteValide(int i){
		return activitesValides[i];
	}
	
	
	/**
	* Test si l'activite est egale à l'une des activites valides du tableau 	
	* et appelle la methode correspondante
	*/
	public void parler(){
		if (this.getActivite().equals("manger")) {
			afficherManger();
			return;
		}
	}

	/** Affiche des messages correspondants aux activites*/
	public void afficherManger() {
		System.out.println("mAujourd'hui votre mission est de prendre toutes les tables");
		System.out.println("sur le campus et de les envoyer dans la salle de TD");
	}
	
	
	public void attaque(){
		if(this.vie > 0){
			this.vie = this.vie - 50;
			System.out.println("Vous venez de l'attaquer");
			System.out.println("Il lui reste " + this.vie + " de point de vie.");
		}else{
			System.out.println("Vous avez gagnez vous avez reussi a tuer le montre");
			System.out.println("							");	
		}
	}

	/**
	 * Compare cet Monstre avec l'etre specifie et renvoie <code>true</code> si
	 * et seulement si cet etre est un Etre Anime de meme nom possedant les memes
	 * caracteristiques
	 * 
	 * 
	 *
	 * 
	 * @ensures !(e instanceof Monstre ) ==> !\result;
	 * @ensures \result ==> getNom().equals(((Monstre) e).getNom());
	 * 
	 * 
	 * 
	 * @param          le Monstre a comparer
	 * @return <code>true</code> si l'etre specifie est un Monstre 
	 *         
	 * @pure
	 */
	public boolean equals(EtreAnime e){
		
		boolean res = false;
		
		if(!(e instanceof Monstre)){
			return false;
		}
		
		Monstre ea = (Monstre)e;
		
		if(this.getNom().equals(ea.getNom()) && this.getActivite().equals(ea.getActivite()) && this.getVie()==ea.getVie()){
			res = true;
		}
		
		return res;
	}
	
	/**
	 *  Renvoie un code de hashage pour ce Monstre
	 *
	 * @return    un code de hashage pour ce Monstre
	 */
	public int hashCode(){
			return this.getNom().hashCode();
		}
	
	/**
	 *  Renvoie un nom succincte sous forme de chaîne de caracteres
	 *  de ce monstre.
	 *
	 * @return    Une description succincte de ce Monstre
	 */
	public String toString(){
		return this.getNom() + " activite" + this.getActivite() + " Vie " + this.getVie() + "\n";
	}
}	
	
