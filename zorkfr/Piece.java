import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 *  Une piece dans un jeu d'aventure. <p>
 *
 *  Cette classe fait partie du logiciel Zork, un jeu d'aventure simple en mode
 *  texte.</p> <p>
 *
 *  Une "Piece" represente un des lieux dans lesquels se déroule l'action du
 *  jeu. Elle est reliée a au plus quatre autres "Piece" par des sorties. Les
 *  sorties sont étiquettées "nord", "est", "sud", "ouest". Pour chaque
 *  direction, la "Piece" possède une référence sur la piece voisine ou null
 *  s'il n'y a pas de sortie dans cette direction et possede aussi une liste d'objets.</p>
 *
 *	
 * @invariant getNbObjets() >= 0;
 * @invariant description() != null;
 *
 * @author     Michael Kolling
 * @author     Marc Champesme (pour la traduction francaise)
 * @author Diallo Mamoudou
 * @author Diallo Elhadj Mamadou Yero
 * @version    1.1
 * @since      August 2000
 */

public class Piece {
	private String description;
	private ArrayList<Objetzork> listeObjets;
	private ArrayList<EtreAnime> listeEtres;
	private int nbObjets;
	private int nbEtres;
	private int nbMaxObjets;

	// mémorise les sorties de cette piece.
	private HashMap<String,Piece> sorties;



	/**
	 *  Initialise une piece.
	 *  Initialement, cette piece ne possède aucune sortie. La description fournie
	 *  est une courte phrase comme "la bibliothèque" ou "la salle de TP".
	 *
	 * @param  description  Description de la piece.
	 * @param  tabObjets  liste des objets de la piece.
	 * @param  nbObjets  nombre d'objets de la piece.
	 * @param  nbMaxObjets  nombre maximum d'objets que peut contenir la piece.
	 */
	public Piece(String description, ArrayList<Objetzork> tabObjets, ArrayList<EtreAnime> tabEtres, int nbObjets, int nbMaxObjets, int nbEtres) {
		this.description = description;
		this.listeObjets = tabObjets;
		this.listeEtres = tabEtres;
		this.nbObjets = nbObjets;
		this.nbMaxObjets = nbMaxObjets;
		sorties = new HashMap<String, Piece>(4);
	}
		
	public int getNbObjets(){
		return this.nbObjets;
	}
	
	public int getNbMaxObjets(){
		return this.nbMaxObjets;
	}
	
	public Objetzork getObjet(int i){
		return this.listeObjets.get(i);
	}
	
	public int getNbEtres(){
		return this.listeEtres.size();
	}
	
	public EtreAnime getEtre(int i){
		return this.listeEtres.get(i);
	}

	/**
	 *  Définie les sorties de cette piece. A chaque direction correspond ou bien
	 *  une piece ou bien la valeur null signifiant qu'il n'y a pas de sortie dans
	 *  cette direction.
	 *
	 * @param  nord   La sortie nord
	 * @param  est    La sortie est
	 * @param  sud    La sortie sud
	 * @param  ouest  La sortie ouest
	 */
	public void setSorties(Piece nord, Piece est, Piece sud, Piece ouest) {
		if (nord != null) {
			sorties.put("nord", nord);
		}
		if (est != null) {
			sorties.put("est", est);
		}
		if (sud != null) {
			sorties.put("sud", sud);
		}
		if (ouest != null) {
			sorties.put("ouest", ouest);
		}
	}


	/**
	 *  Renvoie la description de cette piece (i.e. la description spécifiée lors
	 *  de la création de cette instance).
	 *
	 * @return    Description de cette piece
	 */
	public String descriptionCourte() {
		return description;
	}


	/**
	 *  Renvoie une description de cette piece mentionant ses sorties et
	 *  directement formatée pour affichage, de la forme: <pre>
	 *  Vous etes dans la bibliothèque.
	 *  Sorties: nord ouest</pre> Cette description utilise la chaine de caractères
	 *  renvoyée par la méthode descriptionSorties pour décrire les sorties de
	 *  cette piece.
	 *
	 * @return    Description affichable de cette piece
	 */
	public String descriptionLongue() {
		return "\n\n\t\t\tVOUS ETES DANS: " + description + ".\n\n" + descriptionSorties() + ".\nNous avons: " + this.nbObjets + " Objets dans la piece.\n" + descriptionObjets() + ".\nNous avons: " + this.listeEtres.size() + " Etres dans la piece.\n" + descriptionEtres() + ".";
	}


	/**
	 *  Renvoie une description des sorties de cette piece, de la forme: <pre>
	 *  Sorties: nord ouest</pre> Cette description est utilisée dans la
	 *  description longue d'une piece.
	 *
	 * @return    Une description des sorties de cette pièce.
	 */
	public String descriptionSorties() {
		String resulString = "Sorties:";
		Set<String> keys = sorties.keySet();
		for (Iterator<String> iter = keys.iterator(); iter.hasNext(); ) {
			resulString += " " + iter.next();
		}
		return resulString;
	}
	
	public String descriptionObjets(){
		String des = "Liste des objets de la piece:";
		for(int i = 0; i < this.nbObjets; i++){
			des += " " + this.listeObjets.get(i).getDescription() + ",";
		}
	
		return des;
	}

	
	public String descriptionEtres(){
		String des = "Liste des etres de la piece:";
		for(int i = 0; i < this.listeEtres.size(); i++){
			des += " " + this.listeEtres.get(i).getNom() + ",";
		}
	
		return des;
	}	
	
	/**
	 *  Renvoie la piece atteinte lorsque l'on se déplace a partir de cette piece
	 *  dans la direction spécifiée. Si cette piece ne possède aucune sortie dans cette direction,
	 *  renvoie null.
	 *
	 * @param  direction  La direction dans laquelle on souhaite se déplacer
	 * @return            Piece atteinte lorsque l'on se déplace dans la direction
	 *      spécifiée ou null.
	 */
	public Piece pieceSuivante(String direction) {
		return sorties.get(direction);
	}
	
	public int ContientCombienDe(Objetzork o){
		int n=0;
		
		n = this.listeObjets.size();
		
		if(n==0){
			System.out.println("Il n'y a pas d'objets dans cette piece!");
		}		
		return n;
	}
	
	/**
     *  Renvoie le nombre d'exemplaires de l'objet spécifié présents dans cette
     *  piece. La présence d'un objet est testé en utilisant la méthode equals de
     *  la classe ObjetZork. Renvoie 0 si l'argument est null.
     *
     * @ensures \result >= 0;
     * @ensures contient(oz) <==> \result > 0;
     * @ensures !contient(o) <==> \result == 0;
     * @ensures (o == null) ==> (\result == 0);
     *
     * @param  o  Objet dont on cherche a savoir en combien d'exemplaires il est
     *      présent dans cette piece
     * @return     le nombre d'exemplaires de l'objet spécifié présents dans cette
     *      piece
     * @pure
     */
	public boolean contientEtre(EtreAnime e){
		if(this.listeEtres.contains(e))
			return true;
		return false;
	}
	
	/**
     *  Ajoute l'objet spécifié aux objets présents dans cette pièce. Si l'objet
     *  est déja présent dans cette piece un exemplaire supplémentaire de cet objet
     *  y est ajouté. La présence d'un objet est testé en utilisant la méthode
     *  equals de la classe ObjetZork. L'argument doit etre non <code>null</code>.
     *
     * @requires o != null;
     *
     *
     * @param  o  L'objet a ajouter dans cette piece
     * @throws NullPointerException si le paramètre est null
     */
	public void ajouter(Objetzork o){
		this.listeObjets.add(o);
		this.nbObjets++;
		System.out.println("L'objet " + o.getDescription() + " est maintenant dans la piece.");
		System.out.println("Il reste: " + this.nbObjets + " objets dans la piece.\n" + descriptionObjets());
		
	}
	
	/**
     *  Retire un exemplaire de l'objet spécifié de cette piece si cet objet y est
     *  présent. Renvoie true si cet objet était effectivement présent dans la
     *  pièce et que l'objet a pu etre effectivement retiré ; renvoie false sinon.
     *  La présence d'un objet est testé en utilisant la méthode equals de la
     *  classe ObjetZork. L'argument doit etre non <code>null</code>.
     *
     *
     * @param  o  Objet dont un exemplaire doit etre retirer de cette piece
     * @return     true si cet objet était effectivement présent ; false sinon.
     */
	public boolean retirer(Objetzork o){
			
		boolean r = false;

		r=this.listeObjets.remove(o);
		
		if(r==true){
			this.listeObjets.remove(o);
			this.nbObjets--;
			System.out.println("L'objet " + o.getDescription() + " a bien été pris de la piece.");
			System.out.println("Il reste: " + this.nbObjets + " objets dans la piece.\nQui sont: " + descriptionObjets());				
		}
		
		return r;	
	}		
	
		
    /**
     *  Ajoute l'objet spécifié aux objets présents dans cette pièce. Si l'objet
     *  est déja présent dans cette piece un exemplaire supplémentaire de cet objet
     *  y est ajouté. La présence d'un objet est testé en utilisant la méthode
     *  equals de la classe ObjetZork. L'argument doit etre non <code>null</code>.
     *
     * @requires o != null;
     *
     *
     * @param  o  L'objet a ajouter dans cette piece
     * @throws NullPointerException si le paramètre est null
     */
	public void ajouterEtre(EtreAnime e){
		this.listeEtres.add(e);
		this.nbEtres++;
		System.out.println("L'Etre " + e.getNom() + " est maintenant dans la piece: " + this.description + ".\n");
		
	}
	
	/**
     *  Retire un exemplaire de l'objet spécifié de cette piece si cet objet y est
     *  présent. Renvoie true si cet objet était effectivement présent dans la
     *  pièce et que l'etre a pu etre effectivement retiré ; renvoie false sinon.
     *  La présence d'un objet est testé en utilisant la méthode equals de la
     *  classe ObjetZork. L'argument doit etre non <code>null</code>.
     *
     *
     * @param  e  Etre dont un exemplaire doit etre retirer de cette piece
     * @return     true si cet etre était effectivement présent ; false sinon.
     */
	public boolean retirerEtre(EtreAnime e){
			
		boolean r = false;

		r=this.listeEtres.remove(e);
		
		if(r==true){
			this.nbEtres--;
			System.out.println("L'Etre " + e.getNom() + " a quitte la piece.");
			System.out.println("Il reste: " + this.nbEtres + " etres animes dans la piece.\n");
		}
		
		return r;	
	}
	
}	

