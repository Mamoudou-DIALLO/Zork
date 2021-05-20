import java.util.ArrayList;

/**
 *  Un Etre anime dans un jeu d'aventure. <p>
 *
 *  Cette classe fait partie du logiciel Zork, un jeu d'aventure simple en mode
 *  texte.</p> <p>
 *
 *  Un "Etre Anime" est une entité capable de se déplacer dans le jeu,
 *  de son propre chef(ordinateur).
 *  Il a pour nom EtreAnime et possede un nom et une activite.</p>
 *
 * @author Diallo Mamoudou
 * @author Diallo Elhadj Mamadou Yero
 * @version    1.1
 * @since      August 2000
 */


public abstract class EtreAnime{
	private String nom;
	private String activite;
	
	/**
	 *  Initialise un Etre anime.
	 *  Initialement, cet etre possède un nom
	 *  et une activite.
	 *
	 * @param  nom  La chaine de caractères qui identifie cet etre
	 * @param  activite  La chaine de caractères qui decrit son activite
	 *
	 * @requires nom != null;
	 * @requires activite != null;
	 *
	
	 * @throws NullPointerException si la chaîne de caractères spécifiée est null.
	 */
	
	public EtreAnime(String nom, String activite){
		this.nom = nom;
		this.activite = activite;
	}
		
	//Accesseurs
	
	/**
	 *  Renvoie le nom de cet etre (i.e. le nom spécifiée lors de
	 *  la création de cette instance).
	 *
	 * @return    nom de l'etre anime
	 *
	 * @pure
	 */
	public String getNom(){
		return this.nom;
	}
	

	/**
	 *  Renvoie l'ativite de cet etre (i.e. l'activite spécifiée lors de
	 *  la création de cette instance).
	 *
	 * @return    ativite de l'etre anime
	 *
	 * @pure
	 */
	public String getActivite(){
		return this.activite;
	}
	
	/**
	*Des methodes abstraites
	*qui dependent de l'etre
	*/ 
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
	public boolean equals(Object e){
		
		boolean res = false;
		
		if(!(e instanceof EtreAnime)){
			return false;
		}
		
		EtreAnime ea = (EtreAnime)e;
		
		if(this.nom.equals(ea.getNom()) && this.activite.equals(ea.getActivite())){
			res = true;
		}
		
		return res;
	}
	
	/**
	 *  Renvoie un code de hashage pour cet Etre anime
	 *
	 * @return    un code de hashage pour cet Etre anime
	 */
	public int hashCode(){
			return nom.hashCode();
		}
	
	
	/**
	 *  Renvoie une nom succincte sous forme de chaîne de caractères
	 *  de cet Etre.
	 *
	 * @return    Une description succincte de cet Etre anime
	 */
	public String toString(){
		return this.nom + " activite" + this.activite + "\n";
	}



}
