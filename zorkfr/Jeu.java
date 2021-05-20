import java.util.ArrayList;
import java.util.Random;
/**
 *  Classe principale du jeu "Zork". <p>
 *
 *  Zork est un jeu d'aventure très rudimentaire avec une interface en mode
 *  texte: les joueurs peuvent juste se déplacer parmi les différentes pieces.
 *  Ce jeu nécessite vraiment d'etre enrichi pour devenir intéressant!</p> <p>
 *
 *  Pour jouer a ce jeu, créer une instance de cette classe et appeler sa
 *  méthode "jouer". </p> <p>
 *
 *  Cette classe crée et initialise des instances de toutes les autres classes:
 *  elle crée toutes les pieces, crée l'analyseur syntaxique et démarre le jeu.
 *  Elle se charge aussi d'exécuter les commandes que lui renvoie l'analyseur
 *  syntaxique.</p>
 *
 * @author     Michael Kolling
 * @author     Marc Champesme (pour la traduction francaise)
 * @author Diallo Mamoudou
 * @author Diallo Elhadj Mamadou Yero
 * @version    1.1
 * @since      March 2000
 */

public class Jeu {
	private AnalyseurSyntaxique analyseurSyntaxique;
	private Piece pieceCourante;
	private Piece piecePrecedente;
	private Piece piecePossible[];
	private Piece teleport;
	private Joueur joueurZork;

	/**
	 *  Crée le jeu et initialise la carte du jeu (i.e. les pièces).
	 */
	public Jeu() {
		creerPieces();
		creerJoueur();
		analyseurSyntaxique = new AnalyseurSyntaxique();
	}

	/**
	 *  Crée un joueur et initialise le joueur.
	 */
	public void creerJoueur() {
		
		ArrayList<Objetzork> tabObjet;
		tabObjet =new ArrayList<Objetzork>();
		
		//Créer les objets du joueurZork
		//et les mets sur le joueur
		Objetzork vetement=new Objetzork("habits",2,true);
		Objetzork sac=new Objetzork("sac",3,true);
		Objetzork casquette=new Objetzork("casquettes",1,true);
		
		tabObjet.add(0, vetement);
		tabObjet.add(1, sac);
		tabObjet.add(2, casquette);
		joueurZork = new Joueur("Zork", tabObjet, 1, 2, 80);
	}
		


	/**
	 *  Crée toutes les pieces et relie leurs sorties les unes aux autres.
	 */
	public void creerPieces() {
		Piece dehors;
		Piece salleTD;
		Piece taverne;
		Piece batimentC;
		Piece burreau;
		Piece aleatoire;
		//Aleatoires
		Random randAct = new Random();
	
		//Pour pouvoir utiliser le rand
		//Ils ne sont dans aucune piece
		Gardien gardien=new Gardien("M.Soukaya","surveille",false);		
		Professeur prof=new Professeur("M.Dylan","surveille",false);		
		Monstre monstre=new Monstre("Monstre","mange",130);		
	
		//Créer les objets de la piece dehors
		//et les mets dans la piece
		ArrayList<Objetzork> objet1;
		objet1 =new ArrayList<Objetzork>(5);

		Objetzork objet10=new Objetzork("voiture",500,false);
		Objetzork objet11=new Objetzork("tableDeTennis",70,false);

		objet1.add(0, objet10);
		objet1.add(1, objet11);

		ArrayList<EtreAnime> Etre1;
		Etre1 =new ArrayList<EtreAnime>(5);

		EtreAnime Etre10=new Professeur("M.Diallo",prof.getActiviteValide(randAct.nextInt(6)),false);
		EtreAnime Etre11=new Gardien("Pika",gardien.getActiviteValide(randAct.nextInt(6)),true);
		
		Etre1.add(0, Etre10);
		Etre1.add(1, Etre11);		
		
		//Créer les objets de la piece salleTD
		//et les mets dans la piece
		ArrayList<Objetzork> objet2;
		objet2 =new ArrayList<Objetzork>(10);

		Objetzork objet20=new Objetzork("tableau",50,false);
		Objetzork objet21=new Objetzork("tableDuProf",12,false);
		Objetzork objet22=new Objetzork("table",10,true);
		Objetzork objet23=new Objetzork("bic",2,true);
		Objetzork objet24=new Objetzork("crayon",1,true);
		Objetzork objet25=new Objetzork("chaise",6,true);
		
		objet2.add(0, objet20);
		objet2.add(1, objet21);
		objet2.add(2, objet22);
		objet2.add(3, objet23);
		objet2.add(4, objet24);
		objet2.add(5, objet25);
	
		ArrayList<EtreAnime> Etre2;
		Etre2 =new ArrayList<EtreAnime>(5);

		EtreAnime Etre20=new Professeur("M.Dkdl",prof.getActiviteValide(randAct.nextInt(6)),false);
		EtreAnime Etre21=new Professeur("M.Ppso",prof.getActiviteValide(randAct.nextInt(6)),true);
		
		Etre2.add(0, Etre20);
		Etre2.add(1, Etre21);
		

		//Créer les objets de la piece taverne
		//et les mets dans la piece
		ArrayList<Objetzork> objet3;
		objet3 =new ArrayList<Objetzork>(8);
	
		Objetzork objet30=new Objetzork("placard",70,false);
		Objetzork objet31=new Objetzork("tirroir",35,false);
		Objetzork objet32=new Objetzork("cahier",50,true);
		Objetzork objet33=new Objetzork("craie",3,true);
		Objetzork objet34=new Objetzork("bouteille",15,true);
		Objetzork objet35=new Objetzork("crayon",5,true);
	
		objet3.add(0, objet30);
		objet3.add(1, objet31);
		objet3.add(2, objet32);
		objet3.add(3, objet33);	
		objet3.add(4, objet34);
		objet3.add(5, objet35);	
		
		ArrayList<EtreAnime> Etre3;
		Etre3 =new ArrayList<EtreAnime>(5);

		EtreAnime Etre30=new Professeur("M.Ddl",prof.getActiviteValide(randAct.nextInt(6)),false);
		EtreAnime Etre31=new Professeur("M.Pso",prof.getActiviteValide(randAct.nextInt(6)),true);
		
		Etre3.add(0, Etre30);
		Etre3.add(1, Etre31);


		//Créer les objets de la piece batimentC
		//et les mets dans la piece
		ArrayList<Objetzork> objet4;
		objet4 =new ArrayList<Objetzork>(4);

		Objetzork objet40=new Objetzork("ecran",150,false);
		Objetzork objet41=new Objetzork("distributeur",150,false);
		Objetzork objet42=new Objetzork("chaise",25,true);
		Objetzork objet43=new Objetzork("table",50,true);
		
		objet4.add(0, objet40);
		objet4.add(1, objet41);
		objet4.add(2, objet42);
		objet4.add(3, objet43);
			
		ArrayList<EtreAnime> Etre4;
		Etre4 =new ArrayList<EtreAnime>(5);
	
		EtreAnime Etre40=new Professeur("M.Dkll",prof.getActiviteValide(randAct.nextInt(6)),false);
		EtreAnime Etre41=new Professeur("M.Ppho",prof.getActiviteValide(randAct.nextInt(6)),true);
		
		Etre4.add(0, Etre40);
		Etre4.add(1, Etre41);
			
		//Créer les objets de la piece burreau
		//et les mets dans la piece
		ArrayList<Objetzork> objet5;
		objet5 =new ArrayList<Objetzork>(9);

		Objetzork objet50=new Objetzork("placard",70,false);
		Objetzork objet51=new Objetzork("serveur",25,false);
		Objetzork objet52=new Objetzork("cahier",50,true);
		Objetzork objet53=new Objetzork("chaise",25,true);
		Objetzork objet54=new Objetzork("table",50,true);
		Objetzork objet55=new Objetzork("ordinateur",30,true);
		
		objet5.add(0, objet50);
		objet5.add(1, objet51);
		objet5.add(2, objet52);
		objet5.add(3, objet53);
		objet5.add(4, objet54);
		objet5.add(5, objet55);
				
		ArrayList<EtreAnime> Etre5;
		Etre5 =new ArrayList<EtreAnime>(5);
		
		EtreAnime Etre50=new Professeur("M.Dkdlm",prof.getActiviteValide(randAct.nextInt(6)),false);
		EtreAnime Etre51=new Professeur("M.Ppsop",prof.getActiviteValide(randAct.nextInt(6)),true);
		EtreAnime Etre52=new Monstre("Golem",monstre.getActiviteValide(randAct.nextInt(2)),500);
		
		Etre5.add(0, Etre50);
		Etre5.add(1, Etre51);
		Etre5.add(2, Etre52);
				
		//Créer les objets de la piece burreau
		//et les mets dans la piece
		ArrayList<Objetzork> objet6;
		objet6 =new ArrayList<Objetzork>(1);
				
		ArrayList<EtreAnime> Etre6;
		Etre6 =new ArrayList<EtreAnime>(1);
		
		
		// création et initialisation des pieces
		dehors = new Piece("devant le batiment C", objet1, Etre1, 2, 5, 3);
		salleTD = new Piece("une salle de TD dans le batiment G", objet2, Etre2, 5, 7, 6);
		taverne = new Piece("la taverne", objet3, Etre3, 4, 6, 2);
		batimentC = new Piece("le batiment C", objet4, Etre4, 4, 5, 2);
		burreau = new Piece("le secrétariat", objet5, Etre5, 4, 5, 3);
		aleatoire = new Piece("la piece de teleportaion", objet6, Etre6, 0, 0, 0);

		// initialise les sorties des pieces
		dehors.setSorties(null, salleTD, batimentC, taverne);
		salleTD.setSorties(null, null, null, dehors);
		taverne.setSorties(null, dehors, null, null);
		batimentC.setSorties(dehors, burreau, null, null);
		burreau.setSorties(null, null, aleatoire, batimentC);
		aleatoire.setSorties(burreau, null, null, null);
		
		Piece tabPiece[] = {dehors, salleTD, batimentC, taverne, burreau};	
		
		this.piecePossible = tabPiece;
		teleport = aleatoire;
		// le jeu commence dehors
		pieceCourante = dehors;
	}


	/**
	 *  Pour lancer le jeu. Boucle jusqu'a la fin du jeu.
	 */
	public void jouer() {
		afficherMsgBienvennue();

		// Entrée dans la boucle principale du jeu. Cette boucle lit
		// et exécute les commandes entrées par l'utilisateur, jusqu'a
		// ce que la commande choisie soit la commande "quitter"
		boolean termine = false;
		while (!termine) {
			Commande commande = analyseurSyntaxique.getCommande();
			termine = traiterCommande(commande);
		}
		System.out.println("Merci d'avoir jouer.  Au revoir.");
	}


	/**
	 *  Affiche le message d'accueil pour le joueur.
	 */
	public void afficherMsgBienvennue() {
		System.out.println();
		System.out.println("\n\t\t\t\tBienvenue dans le monde de Zork !");
		System.out.println("\t\tZork est un nouveau jeu d'aventure, terriblement ennuyeux.");
		System.out.println("\t\t\tVous etes le joueurZork.");
		System.out.println("\t\t\tTapez 'aide' si vous avez besoin d'aide.");
		System.out.println();
		System.out.println(pieceCourante.descriptionLongue());
	}


	/**
	 *  Exécute la commande spécifiée. Si cette commande termine le jeu, la valeur
	 *  true est renvoyée, sinon false est renvoyée
	 *
	 * @param  commande  La commande a exécuter
	 * @return           true si cette commande termine le jeu ; false sinon.
	 */
	public boolean traiterCommande(Commande commande) {
		if (commande.estInconnue()) {
			System.out.println("Je ne comprends pas ce que vous voulez...");
			return false;
		}

		String motCommande = commande.getMotCommande();
		if (motCommande.equals("aide")) {
			afficherAide();
		}else if (motCommande.equals("mission")) {
			afficherMission();
		}else if (motCommande.equals("attaquer")) {
			attaquerMonstre(commande);		
		}else if (motCommande.equals("aller")) {
			deplacerVersAutrePiece(commande);
		}else if (motCommande.equals("retour")) {
			deplacerVersAutrePiece(commande);
		}else if (motCommande.equals("parler")) {
			traiterActivite(commande);
		}else if (motCommande.equals("donner")) {
			donnerQqch(commande);				
		} else if (motCommande.equals("rechercher")) {
			rechercherObjet(commande);
		} else if (motCommande.equals("emporter")) {
			emporterObjet(commande);
		} else if (motCommande.equals("deposer")) {
			deposerObjet(commande);
		} else if (motCommande.equals("quitter")) {
			if (commande.aSecondMot()) {
				System.out.println("Quitter quoi ?");
			} else {
				return true;
			}
		}
		return false;
	}
	
	/**
	 *  Exécute l'activité spécifiée. Si cette acitivité est un conseil, l'être animé peut
	 *  vous conseiller selon son humeur, sinon false est renvoyée
	 *
	 * @param  commande  La commande a exécuter
	 * @return           true si cette commande termine le jeu ; false sinon.
	*/

	public void traiterActivite(Commande commande) {
		 if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas à qui parler..
			System.out.println("Avec qui parler?");
			return;
		}
		
		String nom = commande.getSecondMot();
		
		for(int i=0; i<pieceCourante.getNbEtres(); i++){		
			if(nom.equals(pieceCourante.getEtre(i).getNom())){
				System.out.println("Il est entrain de: " +pieceCourante.getEtre(i).getActivite() + ".\n");
				
				if(pieceCourante.getEtre(i).getActivite().equals("deplace")){
					deplacementAleatoire(pieceCourante.getEtre(i));
				}
				else{
					pieceCourante.getEtre(i).parler();
					return;				
				}				
			}
		}
				
		System.out.println("Il n'y a pas de: " + nom + ".\n");		
			
		return;
	}

	// implementations des commandes utilisateur:

	/**
	 *  Affichage de l'aide. Affiche notamment la liste des commandes utilisables.
	 */
	public void afficherAide() {
		System.out.println("Vous etes perdu. Vous etes seul. Vous errez");
		System.out.println("sur le campus de l'Université Paris 13.");
		System.out.println();
		System.out.println("Les commandes reconnues sont:");
		analyseurSyntaxique.afficherToutesLesCommandes();
	}
	
	/**
	 *  Affichage de la mission. Affiche notamment la mission du joueur.
	 */
	public void afficherMission() {
		System.out.println("Aujourd'hui votre mission est de tuer le Golem qui se trouve quelque part");
		System.out.println("sur le campus");
	}
	
	/**
	 *  Tente de rechercher un objet dans la piece spécifiée par la commande. Si la piece
	 *  possède un objet de même nom que second mot de la commande alors la description complète de l'objet correspondant à
	 *  ce nom est affiché, dans les autres cas affiche un
	 *  message d'erreur.
	 *
	 * @param  commande  Commande dont le second mot spécifie l'objet à deposer
	 */
	public void rechercherObjet(Commande commande){
		if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas quoi rechercher..
			System.out.println("Quel objet rechercher?");
			return;
		}
		
		String nom = commande.getSecondMot();
		//Recherche de l'objet
		for(int i = 0; i<pieceCourante.getNbObjets();i++){
			if(nom.equals(pieceCourante.getObjet(i).getDescription())){
				System.out.println( "\n On a "+" " + nom + "\n" + pieceCourante.getObjet(i).detailObjet());
				return;
			}
		}
		
		System.out.println( "\n IL N'Y A PAS DE " + nom + " DANS CETTE PIECE");
		return;
	}

	/**
	 *  Tente d'emporter un objet de la piece spécifiée par la commande. Si la piece
	 *  possède un objet de même nom que le second mot de la commande alors l'objet correspondant à
	 *  ce nom est ajouté au joueur et retiré de la piece, dans les autres cas affiche un
	 *  message d'erreur.
	 *
	 * @param  commande  Commande dont le second mot spécifie l'objet à emporter
	 */
	
	public void emporterObjet(Commande commande){
		if (!commande.aSecondMot()){
			// si la commande ne contient pas de second mot, nous ne
			// savons pas quoi emporter..
			System.out.println("Quel objet emporter?");
			return;
		}
		
		String nom = commande.getSecondMot();
		//Tentative de prendre l'objet
		for(int i = 0; i<pieceCourante.getNbObjets();i++){
			//Teste s'il ya un objet de meme nom dans la piece
			if(nom.equals(pieceCourante.getObjet(i).getDescription())){
				//Teste si l'objet est transportable
				if(pieceCourante.getObjet(i).esttransportable()==true){
					//Teste si le poids max n'est pas atteint pour le joueur
					if((joueurZork.getPoidsObjets()+pieceCourante.getObjet(i).getPoids())<=joueurZork.getPoidsMax())	
					{
						Objetzork objEmp = pieceCourante.getObjet(i);						
						joueurZork.ajouter(objEmp);
						pieceCourante.retirer(objEmp);
						return;
					}else{
						System.out.println("Vous ne pouvez pas porter plus de " + joueurZork.getPoidsMax() + " sur vous.");
						return;
					}
				}else{
					System.out.println("L'objet " + pieceCourante.getObjet(i).getDescription() + " n'est pas transportable!");
					return;
				}
			}
		}
		
		System.out.println("L'objet " + nom + " ne se trouve pas dans la piece!");
	}

	/**
	 *  Tente de deposer un objet dans la piece spécifiée par la commande. Si le joueur
	 *  possède un objet de même nom que le second mot de la commande alors l'objet correspondant à
	 *  ce nom est ajouté à la piece et retiré du joueur, dans les autres cas affiche un
	 *  message d'erreur.
	 *
	 * @param  commande  Commande dont le second mot spécifie l'objet à deposer
	 */

	public void deposerObjet(Commande commande){
		if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas quoi deposer..
			System.out.println("Quel objet deposer?");
			return;
		}
		
		String nom = commande.getSecondMot();
	        //Tentative de depôt de l'objet 
		for(int i = 0; i<joueurZork.getNbObjets();i++){
			//Teste s'il ya un objet de meme nom sur le joueur			
			if(nom.equals(joueurZork.getObjet(i).getDescription())){
				//Teste si on a pas atteint le nbre max d'objets dans la piece
				if((pieceCourante.getNbObjets()+1)<=pieceCourante.getNbMaxObjets()){						
						Objetzork objDep = joueurZork.getObjet(i);
						pieceCourante.ajouter(objDep);
						joueurZork.retirer(objDep);				
						return;
				}else{
					System.out.println("La piece ne prend que " + pieceCourante.getNbMaxObjets() + " objets au maximum!");			
					return;
				}		
			}
		}	
			
		
		System.out.println("Vous n'avez pas l'objet " + nom + " sur vous!");
	}


	/**
	 *  Tente de donner un objet a l'etre spécifiée par la commande. Si la piece
	 *  possède un objet de même nom que second mot de la commande alors la description complète de l'objet correspondant à
	 *  ce nom est affiché, dans les autres cas affiche un
	 *  message d'erreur.
	 *
	 * @param  commande  Commande dont le second mot spécifie l'objet à deposer
	 */
	public void donnerQqch(Commande commande){
		if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas quoi donner..
			System.out.println("Quel objet donner?");
			return;
		}
				
		if (!commande.aTroisiemeMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas aqui donner..
			System.out.println("A qui donner?");
			return;
		}
				
		String nom = commande.getSecondMot();
		String nomEtre = commande.getTroisiemeMot();
		
		//Recherche de l'objet
		for(int i = 0; i<joueurZork.getNbObjets();i++){
			//Teste s'il ya un objet de meme nom sur le joueur
			if(nom.equals(joueurZork.getObjet(i).getDescription())){
				Objetzork objDonner = joueurZork.getObjet(i);

				for(int j = 0; j<pieceCourante.getNbEtres();j++){
					//Teste s'il ya un etre de meme nom dans la piece
					if(nomEtre.equals(pieceCourante.getEtre(j).getNom())){
						joueurZork.retirer(objDonner);
					}
				}
				
				return;
			}
		}
		
		System.out.println("Vous n'avez pas l'objet " + nom + " sur vous!");
		return;
	}
	
	/**
	 *  Tente d'aller dans la direction spécifiée par la commande. Si la piece
	 *  courante possède une sortie dans cette direction, la piece correspondant a
	 *  cette sortie devient la piece courante, dans les autres cas affiche un
	 *  message d'erreur.
	 *
	 * @param  commande  Commande dont le second mot spécifie la direction a suivre
	 */
	public void deplacerVersAutrePiece(Commande commande) 
	{
		
		//Déconne si vous utilisez mal la commande aller 
		if(commande.getMotCommande().equals("retour"))
		{
			 if(pieceCourante.descriptionCourte().equals("devant le batiment C"))
			 {
				//car le jeu commence dehors c'est à dire devant le batiment C
				 System.out.println("Vous ne pouvez pas retourner");
				 return;
			 }
			 else
			 {
				 pieceCourante=piecePrecedente;
				 System.out.println(pieceCourante.descriptionLongue());
				 return;
			 }
		}
		
	
		 else   if (!commande.aSecondMot()) 
		{
			// si la commande ne contient pas de second mot, nous ne
			// savons pas ou aller..
			System.out.println("Aller oû ?");
			return;
		}
		String direction = commande.getSecondMot();
       //sauvegarde de la pièce courante dans la pièce precedente.
			piecePrecedente=pieceCourante;
			
		// Tentative d'aller dans la direction indiquée.
		Piece pieceSuivante = pieceCourante.pieceSuivante(direction);

		if (pieceSuivante == null) 
		{
			System.out.println("Il n'y a pas de porte dans cette direction!");
		}
		else if(pieceSuivante.equals(teleport))
		{	
			Random randPiece = new Random();
					
			System.out.println("Vous allez etre teleporter");
			System.out.println(pieceCourante.descriptionLongue());
			pieceCourante = piecePossible[randPiece.nextInt(5)];
			System.out.println(pieceCourante.descriptionLongue());
		} 
		else 
		{
			pieceCourante = pieceSuivante;
			
			System.out.println(pieceCourante.descriptionLongue());
			
			
		}
	}
		

	
	/**
	 * deplace un etre animee de facon aleatoire
	 *
	 * @param etre l'etre a deplace aleatoirement
	 */
	public void deplacementAleatoire(EtreAnime etre) 
	{
		String sortiesPossibles[] = {"nord", "sud", "est", "ouest"};
		Random randSortie = new Random();
		String direction = sortiesPossibles[randSortie.nextInt(4)];		
	
		while(pieceCourante.pieceSuivante(direction) == null)
			direction = sortiesPossibles[randSortie.nextInt(4)];
		 
		// Tentative d'aller dans la direction indiquée.
		Piece pieceSuivante = pieceCourante.pieceSuivante(direction);
 		
		pieceCourante.retirerEtre(etre);
		pieceSuivante.ajouterEtre(etre);
	}
	
		
		
	
	/**
	 * attaque un monstre
	 *
	 * @param etre l'etre a deplace aleatoirement
	 */

	public void attaquerMonstre(Commande commande) {
		 if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas qui attaquer..
			System.out.println("Qui attaquer?");
			return;
		}
		
		String nom = commande.getSecondMot();
		
		for(int i=0; i<pieceCourante.getNbEtres(); i++){		
			if(nom.equals(pieceCourante.getEtre(i).getNom())){
				System.out.println("Il est entrain de: " +pieceCourante.getEtre(i).getActivite() + ".\n");
				pieceCourante.getEtre(i).attaque();
				return;						
				
			}
		}
				
		System.out.println("Il n'y a pas de: " + nom + ".\n");		
			
		return;
	}
}
