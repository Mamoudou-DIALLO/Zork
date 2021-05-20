import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/**
 *  Un objet dans un jeu d'aventure. <p>
 *
 *  Cette classe fait partie du logiciel Zork, un jeu d'aventure simple en mode
 *  texte. Dans le logiciel Zork un objet peut se trouver dans une pièce ou etre
 *  transporté par un joueur s'il est transportable. </p>
 *
 *  <p>Un ObjetZork est complètement caractérisé par une description, un poids et le fait
 *  qu'il soit ou non transportable. Tous les ObjetZork possèdent 
 *  un poids supérieur ou égal à zéro, mais les ObjetZork transportables doievnt avoir un
 *  un poids strictement positif. Les ObjetZork sont non modifiables 
 *
 * @invariant descriptionCourte() != null;
 * @invariant descriptionLongue() != null;
 * @invariant getPoids() >= 0;
 * @invariant estTransportable() ==> (getPoids() > 0);
 *
 * @author DIALLO Mamoudou
 * @author DIALLO Elhadj Mamadou Yero
 */
	
public class Objetzork{
	private String description;
	private int poids;
	private boolean transportable;
	
	/**
	 *  Initialise un objet.
	 *  Initialement, cet objet possède un nom
	 *  un poids et est transportable ou pas.
	 *
	 * @param  description  La chaine de caractères qui identifie cet objet
	 * @param  poids  liste des objets de l'objet.
	 * @param  transportable  si il est transportbable(true) ou pas(false) de l'objet.
	 *
	 * @requires description != null;
	 * @ensures descriptionCourte() == description;
	 * @ensures getPoids() == 0;
	 * @ensures !estTransportable();
	 *
	
	 * @throws NullPointerException si la chaîne de caractères spécifiée est null.
	 */
	public Objetzork(String description, int poids, boolean transportable){
		this.description = description;
		this.poids = poids;
		this.transportable = transportable;
	}

	/*Accesseurs*/
	
	/**
	 *  Renvoie la description de cet objet (i.e. la description spécifiée lors de
	 *  la création de cette instance).
	 *
	 * @return    Description de cet objet
	 *
	 * @pure
	 */
	public String getDescription(){
		return this.description;
	}
	
	/**
	 *  Renvoie le poids de cet objet. Si cet objet n'est pas transportable, la
	 *  valeur retournée n'est pas significative.
	 *
	 * @return    Le poids de cet objet.
	 *
	 * @pure
	 */
	public int getPoids(){
		return this.poids;
	}
	
	/**
	 *  Renvoie le poids de cet objet. Si cet objet n'est pas transportable, la
	 *  valeur retournée n'est pas significative.
	 *
	 * @return    Le poids de cet objet.
	 *
	 * @pure
	 */
	public boolean gettransportable(){
		return this.transportable;
	}

	/**
	 *  Renvoie true si cet objet est transportable ; false sinon.
	 *
	 * @return    true si cet objet est transportable ; false sinon
	 *
	 * @pure
	 */
	public boolean esttransportable(){
		if(this.transportable == true)
			return true;
		return false;
	}	
		
	/**
	 * Affiche les details de l'objet
	 * @return les details de l'objet
	*/
	public String detailObjet(){
		String detail = this.description;
			detail += " Poids: " + this.poids + " Kg";
		if(transportable)
			detail += "  transportable";
		else
			detail += "  non transportable";
		
		return detail;
	}
	
	/**
	 * Compare cet objet avec l'objet spécifié et renvoie <code>true</code> si
	 * et seulement si cet objet est un objetzork de même nom possédant les mêmes
	 * caracteristiques
	 * 
	 * 
	 *
	 * 
	 * @ensures !(o instanceof objetzork ) ==> !\result;
	 * @ensures \result ==> getDescription().equals(((objetzork) o).getdescription());
	 * 
	 * 
	 * 
	 * @param          l'objet à comparer
	 * @return <code>true</code> si l'objet spécifié est un objetzork 
	 *         
	 * @pure
	 */
	public boolean equals(Object o){
		
		boolean res = false;
		
		if(!(o instanceof Objetzork)){
			return false;
		}
		
		Objetzork oz = (Objetzork)o;
		
		if(this.description.equals(oz.getDescription()) && this.poids==oz.getPoids() && this.esttransportable() == oz.esttransportable()){
			res = true;
		}
		
		return res;
	}
	
	/**
	 *  Renvoie un code de hashage pour cet ObjetZork
	 *
	 * @return    un code de hashage pour cet ObjetZork
	 */
	public int hashCode(){
		if(!transportable)
			return description.hashCode();
		else
			return description.hashCode()+(31)*poids;
	}
	
	/**
	 *  Renvoie une description succincte sous forme de chaîne de caractères
	 *  de cet ObjetZork.
	 *
	 * @return    Une description succincte de cet ObjetZork
	 */
	public String toString(){
		return description + "poids =" + this.poids + "transportable =" + this.transportable;
	}

}

