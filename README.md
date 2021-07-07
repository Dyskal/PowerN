PowerN est un jeu créé en Java qui consiste en une sorte de Puissance 4,
mais avec une taille de plateau et un nombre de jetons a aligner variable.

Le joueur 1 est jaune et sa représentation est : X.

Le joueur 2 est rouge et sa représentation est : O.

Il a une partie console jouable dans le terminal et une partie graphique qui affiche le plateau de jeu.

Les limitations du projet sont :

    - La partie graphique ne permet pas de jouer, seulement d'afficher le plateau.
    - Le nom des joueurs ne peut pas être sauvegardé, il faudrais changer la syntaxe des fichiers de données.
    - L'IA du joueur automatique n'est constituée que d'un random, il n'a pas de stratégie.
    - Une partie ne peut pas être sauvegardée et reprise.

Le dossier des données doit être placé au même endroit que le fichier jar, la disposition doit être :

    - data
        - configN.txt (ou N est le numéro de la config)
        - images
            - empty.png
            - red.png
            - yellow.png
    - PowerN.jar

Le contenu d'un fichier de configuration doit être : `x:y:z:MM`
avec x la longueur du plateau, y la hauteur du plateau, z le nombre de jetons à aligner et MM le mode entre HH (Humain/Humain), HA (Humain/Automatique), AA (Automatique/Automatique).

Pour compiler le jeu, il faut lancer la commande `javac -d ./class ./src/*.java ./src/*/*.java`

Pour créér le jar, il faut lancer la commande `jar cvfe PowerN.jar GameLauncher -C class/ .`

Pour lancer le jeu, il faut lancer la commande `java -jar PowerN.jar`
