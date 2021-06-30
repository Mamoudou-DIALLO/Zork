# Zork
Au cours de ce projet d’informatique, nous avons réalisé un jeu en java. L’intérêt principal de ce projet est de mettre en pratique les connaissances que nous avons apprises lors du cours de programmation orienté objet. 

En effet le Zork est un jeu d’aventure très rudimentaire avec une interface en mode texte : les joueurs peuvent juste se déplacer parmi les différentes pièces.

Pour rendre intéressant ce projet, il a été nécessaire d’ajouter plusieurs fonctionnalités notamment un joueur qui se déplace entres plusieurs pièces tout en emportant des objets avec lui et tenter de gagner une partie, pour cela il a fallu rajouter de nouvelles classes et modifiés celles déjà existantes dans le fichier de base parmi les plus notable on peut citer :le personnage capable de déplacer, emporter ou se débarrasser d’un objet , cela à été consigné dans la classe joueur.
# 		Règles du jeu

Les commandes jouent un rôle très important dans ce projet car elles permettent de contrôler   l’exécution du code de bout en bout tout en guidant l’utilisateur d’une meilleur exploitation du travail réalisé.

En dehors de celle déjà existantes au prime abord telles que:
    • aller : qui assure le déplacement d’une pièce à une autre, elle fonctionne en tapant aller et indiquer le lieu (nord,est,sud,ouest).
    • Aide : elle joue un rôle essentielle en guidant l’utilisateur à tout moment pendant l’exécution du programme en l’invitant notamment d’entrer les bonnes commandes, 
      elle fonction en tapant juste aide sans autre mot.
    • quitter : cette dernière permet de sortir du jeu en saisissant le nom de la commande.
    • rechercher : cette commande vérifie si un objet existe dans une pièce puis l’affiche en précisant son poids et l’état selon qu’il soit transportable ou non, elle fonctionne quand l’objet recherché est dans la pièce en tapant le mot clé rechercher puis le nom de l’objet voulu.
    • emporter : celle ci permet de prendre un objet dans une pièce puis l’affecte au joueur si l’objet est transportable selon le poids, à l’image de la commande précédente il faut que l’objet à emporter soit présent dans la pièce puis taper emporter suivi du nom de l’objet.
    • déposer : c’est une commande qui supprime un objet du joueur tout en la plaçant dans la pièce présente, il faut que le joueur dispose de l’objet pour fonctionner, elle prend aussi un second argument c’est le mot clé déposer puis l’objet à déposer.
    • retour : retourne dans la pièce précédente.
    • mission: affiche la mission ( Tuer le golem qui se promène sur le campus).

