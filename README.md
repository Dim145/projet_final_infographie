## Modelisation de la salle de classe A106
#### Projet réalisé par **Dimitri Dubois**  

### 1 Précisions sur les termes:
Tous le long du projet je considèrerais que:
- Les coordonées X Y Z sont celles fixe par rapport à l'écran. Elles sont modélisé par les axes rouge, vert et bleu.
- De même:
  - la largeur représenteras toujours la taille le long de l'axe X
  - La longueur représenteras toujours la taille le long de l'axe Z
  - Pareil pour la hauteur le long de l'axe Y
- la coordonnée Y est inversé*<sup>1</sup>, donc une valeur négative pointe vers le bas et positive vers le haut.

### 2 Les contrôles
La caméra est contrôlable à la manière d'un jeu vidéo.
Il est possible de contrôler le "personnage" avec les touches ZQSD. Avec :
- Z pour avancer
- Q pour aller à gauche
- S pour reculer
- D pour aller à droite.
- Espace pour aller vers le haut (~ au saut ou vol de minecraft) ou sauter avec la nouvelle caméra
- shift pour descendre (~ à se baisser ou descendre sur minecraft)
- CTRL + R pour réinitialiser position et caméra (seulement en caméra libre)
- CTRL + A (ou Q pour clavier QUERTY) pour enlever/ajouter les axes

La caméra se contrôle via la souris.

Attention tous de même, à la différence d'un jeu, 
la caméra se contrôle en cliquant puis déplaçant la souris (drag) 


En caméra libre, les directions sont statiques. Si une rotation à 180° est faite avec la caméra, la touche Q déplaceras le curseur vers la droite et inversement pour D.  

La touche P permet d'ouvrir la porte de la salle.  

### 3 Points d'entrée
Il existe plusieurs points d'entrée dans le projet. Chacun sont fonctionnels et permettent de voir le comportment de certains éléments :
- exécuter le projet via la class **TestsCamera** permet d'avoir une caméra fonctionnelle, mais aucuns shader de chargée (celui par défaut).
- exécuter le projet via la class **TestShaders** permet d'avoir les fonctionnalités précédentes, mais avec les shaders personnalisée et la lumière.
- exécuter le projet via la class **TestNewCamera** permet d'avoir une caméra type jeux vidéo. Celle-ci est plus intuitive, mais aussi plus restreint niveau mouvements.

La commande maven pour compiler et exécuter le code est la suivante :  
`maven compile exec:java -Dfile.encoding=utf-8 -Dexec.mainClass=pfd.TestNewCamera`  
Des guillemets peuvent être nécessaires sur les paramètres (après les '=') selon votre système d'exploitation.
Changer le "*pfd.TestNewCamera*" en *pfd.AutreClasse* parmi celle cité plus haut pour changer de fonctionnalités.

### 4 Pécisions
- 1: Au début du programme, la caméra est inversée sur l'axe Y, le reste est créé et déplacé normalement. Donc si la caméra est mise dans le bon sens, toutes les formes seraient à l'envers.