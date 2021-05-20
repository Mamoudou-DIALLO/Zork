import java.util.ArrayList;

/**
 *  Un Personnage dans un jeu d'aventure. <p>
 *
 *  Cette classe fait partie du logiciel Zork, un jeu d'aventure simple en mode
 *  texte.</p> <p>
 *
 *  Un "Personnage" est un etre capable de se déplacer dans le jeu,
 *  de son propre chef(ordinateur).
 *  Il a pour nom Personnage et possede un nom, une activite, une humeur et un tableau d'activites valides.</p>
 *
 * @author Diallo Mamoudou
 * @author Diallo Elhadj Mamadou Yero
 * @version    1.1
 * @since      August 2000
 */



public abstract class Personnage extends EtreAnime{
	private boolean humeur;
	
		
	public Personnage(String nom, String activite, boolean humeur){
		super(nom, activite);
		this.humeur = humeur;
	}
	
	//Accesseurs
	
	public boolean getHumeur(){
		return this.humeur;
	}
	
	public abstract void parler();
	public abstract void attaque();
	

/**
	 * Compare cet etre avec l'etre spécifié et renvoie <code>true</code> si
	 * et seulement si cet etre est un Etre Anime de même nom possédant les mêmes
	 * caracteristiques
	 * 
	 * 
	 *
	 * 
	 * @ensures !(e instanceof EtreAnime ) ==> !\result;
	 * @ensures \result ==> getNom().equals(((EtreAnime) e).getNom());
	 * 
	 * 
	 * 
	 * @param          l'etre à comparer
	 * @return <code>true</code> si l'etre spécifié est un Etre Anime 
	 *         
	 * @pure
	 */
	public boolean equals(EtreAnime e){
		
		boolean res = false;
		
		if(!(e instanceof Personnage)){
			return false;
		}
		
		Personnage ea = (Personnage)e;
		
		if(this.getNom().equals(ea.getNom()) && this.getActivite().equals(ea.getActivite()) && this.getHumeur()==ea.getHumeur()){
			res = true;
		}
		
		return res;
	}
	
	/**
	 * renvoie une table de hashage de cet etre
	 */
	public int hashCode(){
			return this.getNom().hashCode();
		}
	
	
	/**
	 *  Renvoie une nom succincte sous forme de chaîne de caractères
	 *  de ce personnage.
	 *
	 * @return    Une description succincte de ce personnage
	 */
	public String toString(){
		return this.getNom() + " activite" + this.getActivite() + " humeur " + this.getHumeur() + "\n";
	}
}	
	
