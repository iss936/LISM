LISM
====

1) t�l�charger git bash(c'est en faite un terminal pour git).
Tout le reste se fait avec git bash

Pre condition: avoir configurer son git:
- git config --list (voir si user.email et user.name sont renseign� sinon configurer comme ci-dessous)
-  git config --global user.email ""
- git config --global user.name ""

I] Update ou r�cup�ration de la derni�re version 

Par pr�cautions et pour �viter des conflits il faut toujours faire un "update"

1) Pour r�cup�rer un projet sur git faire git clone git@github.com:iss936/LISM.git (cl� ssh de mon git)
Attention!!!!!!!!!! cette ce commande ce fait une seule fois afin de r�cup�rer l'ensemble du projet
2) Une fois qu'on a r�cup�rer le projet on fera simplement git pull

tu feras un git pull � chaque fois que tu te mettra � travailler
pour �viter les coonflits de version.   

II] Les commit

1) Toujours dans le m�me r�pertoire faire git add modif1.txt modif2.txt modif3.txt ...
 ou git add. dans le cas ou tu a modifier tout les fichiers!!!!
2) git commit -m "ce que j'ai fait.."

3) Sinon git push -u origin master


