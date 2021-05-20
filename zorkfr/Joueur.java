import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;


/**
 *  Un joueur dans un jeu d'aventure. <p>
 *
 *  Cette classe fait partie du logiciel Zork, un jeu d'aventure simple en mode
 *  texte.</p> <p>
 *
 *  Un "Joueur" est celui qu effectue les actions dans le jeu.
 *  Il a pour nom joueurZork et possede une liste d'objets qu'il peut
 *  modifier en y retirant et rajoutant des objets. Il possede aussi le poids 
 *  total des objets.</p>
 *
 * @author Diallo Mamoudou
 * @author Diallo Elhadj Mamadou Yero
 * @version    1.1
 * @since      August 2000
 */


public class Joueur {
	private String nom;
	private ArrayList<Objetzork> listeObjets;
	private int poidsObjets;
	private int nbObjets;
	private int poidsMax;


	/**
	 *  Initialise un joueur.
	 *  Initialement, ce joueur possède des objets
	 *  qu'il ne peut pas retirer.
	 *
	 * @param  nom  Description du joueur.
	 * @param  tabObjets  liste des objets du joueur.
	 * @param  nbObjets  nombre d'objets du joueur.
	 * @param  poidsObjets  poids total des objets se trouvant  du joueur.
	 * @param  poidsMax  poids maximum d'objets que peut avoir le joueur.
	 *
         * @requires nom != null;
    	 * @ensures getNom().equals(nom);
   	 * @ensures getPoidsMax() == 10;
   	 * @ensures getPoids() == 0;
     	 * @ensures getNbObjets() == 0;
	 *
	 * @throws NullPointerException si le nom  est null
	 * @throws IllegalArgumentException si le poids maximal spécifié est négatif ou nul
	 */
	public Joueur(String nom, ArrayList<Objetzork> tabObjets, int poidsObjets, int nbObjets, int poidsMax) {
		this.nom = nom;
		this.listeObjets = tabObjets;
		this.poidsObjets = poidsObjets;		
		this.nbObjets = nbObjets;
		this.poidsMax = poidsMax;
	}

	/*Accesseurs*/
	
	/**
     	* Renvoie le nom du joueur.
     	*
    	*
     	* @return Le nom du joueur.
     	*
     	* @pure
     	*/	
	public String getNom(){
		return this.nom;
	}
	
	/**
     	* Renvoie la somme des poids de l'ensemble des ObjetZork transportés
    	* par ce Joueur.
     	*
     	* 
     	* @return Le poids total des ObjetZork de ce Joueur
     	*
     	* @pure
     	*/
	public int getPoidsObjets(){
		return this.poidsObjets;
	}
	
	/**
     	* Retourne le nombre d'objet du joueur
     	*
     	* @return le nombre d'objet que le joueur contient
     	*
     	* @pure
     	*/
	public int getNbObjets(){
		return this.listeObjets.size();
	}
	
	/**
     	* Retourne le nombre d'objet du joueur
     	*
     	* @return le nombre d'objet que le joueur contient
     	*
     	* @pure
     	*/
	public int getPoidsMax(){
		return this.poidsMax;
	}

	/**
     	 * recupere un objet
    	 *
    	 * @return la liste d' objet du joueur
    	 *
     	 * @pure
    	 */	
	public Objetzork getObjet(int i){
		return this.listeObjets.get(i);
	}

	/**
	 * decrit un objet 
	 * 
	 * @return des renvoi l'objet avec sa description
	 */
	public String descriptionObjets(){
		String des = "Liste des objets sur vous: ";
		for(int i = 0; i < this.nbObjets; i++){
			des += " " + this.listeObjets.get(i).getDescription() + ",";
		}
	
		return des;
	}
	
	
     /**
     *  Renvoie le nombre d'exemplaires de l'objet spécifié en possession 
     *  de cette personne. La présence d'un objet est testé en utilisant la méthode equals de
     *  la classe ObjetZork. Renvoie zéro si l'argument est <code>null</code>.
     *
     * @ensures \result >= 0;
     *
     * @param  o  Objet dont on cherche a savoir en combien d'exemplaires le joeur possede l'objet.
     * @return     le nombre d'exemplaires de l'objet spécifié en possession de ce joueur.
     *
     * @pure
     */
	public int ContientCombienDe(Objetzork o){
		int n=0;
		
		n = this.listeObjets.size();
		
		if(n==0){
			System.out.println("Vous n'avez pas d'objets sur vous!");
		}		
		return n;
	}
	

	/**
	 * ajoute un objet 
	 * @param o l'objet
	 * 
	 * @return true si l'objet a été effectivement ajouté à ce Joueur ;
         * false sinon.
	 *
	 * @requires o!= NULL
	 * @pure
	 */
	public void ajouter(Objetzork o){
	
			int nouveauPoids = this.poidsObjets + o.getPoids();		
	
			if(nouveauPoids>this.poidsMax)
				return;	

			this.listeObjets.add(o);
			this.nbObjets++;
			this.poidsObjets = nouveauPoids;
			System.out.println("L'objet " + o.getDescription() + " est maintenant sur vous.");
	}

     /**
     *  Retire l'objet spécifié du joueur si cet objet y est
     *  présent. Renvoie true si cet objet était présent chez le
     *  joueur et que l'objet a pu etre retiré , renvoie false sinon.
     * 
     *
     * @ensures \result ==> (getPoids() == (\old(getPoids()) - o.getPoids()));
     *
     * @param  oz  Objet dont un exemplaire doit etre retirer de cette piece
     * @return     true si cet objet était effectivement présent ; false sinon.
     */
	public boolean retirer(Objetzork o){
					
		boolean r = false;
		r = this.listeObjets.remove(o);
		
		if(r==true){
			this.nbObjets--;
			System.out.println("Vous venez de deposer l'objet " + o.getDescription());
			System.out.println("Il vous reste: " + this.nbObjets + " objets.\nLes objets sont:" + descriptionObjets());				
		}
		
		return r;		
	}
}

