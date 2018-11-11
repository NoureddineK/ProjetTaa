# ProjetTaa
# Contexte
  Ce projet nous a été proposé dans le cadre des cours de Taa, il vise globalement l’utilisation des technos Web du côté Front et Back End.
Nous avons eu le libre choix de l'environnement de développement, frameworks, base de données…

  Le projet consiste à réaliser un site web dynamique en se basant sur les différentes technos acquises pendant ce module, à savoir : Maven, Spring Boot, Java ee, React, Angular…

  Il permet à un utilisateur de consulter les coordonnées météorologique d’une ou de plusieurs villes afin de programmer une activitée pour le week end.

Un cahier des charges détaillé nous a été fourni au début du projet.

# Fonctionnalitées 
# 1.Connexion :
  Pour une première connexion, l’utilisateur doit s'identifier en introduisant son nom et son adresse mail. Les futures connexion se feront par le nom et le mot de passe choisi.
Un bouton de déconnexion est présent dans la bar de menu qui va servir à l’utilisateur de quitter le site.  

# 2.Site Web: 
  La page Home affiche la liste des lieux et sports favoris de l’utilisateur, en cliquant dessus, il peut retirer un élément de cette liste.

  Le composant Sport, permet à l’utilisateur de visionner les sports proposés par le jeu de données du site, en cliquant dessus il ajoute un nouveau sport dans sa liste des favoris.

  Le composant City aide l’utilisateur à avoir une vision des différentes villes existantes sur le site ainsi que de voir les sports disponibles dans ces dernières.

  En cliquant sur le bouton d’ajout de favori, l’utilisateur pourra ajouter une ville dans sa liste si les sports proposés l'intéressent.


# 3.Récupération de données : 
  La partie Weather fournit la météo qui correspond à la ville saisie par  l’utilisateur. Le site proposera un ensemble d’activitées en se basant à la fois sur les villes favorites et les données météorologique.

  Un email contenant les informations relatives à la météo et aux activitées et villes favorites est envoyé à tous les utilisateurs automatiquement chaque Mercredi à 8h.


# Choix des technologies : 
# 1.Back End: 
  En se basant le contenu des cours de Taa et étant donné les fonctionnalitées du projet, nous avons choisi Spring Boot comme framework qui un outils puissant grâce aux plugins mises à disposition. Apache Maven  nous servira pour la gestion du projet.
nous avons choisi d’utiliser un serveur Apache Tomcat et une base MySQL qui nous donne accès à nos données stockées.
Pour le transfert de données le service REST été choisi.
Pour la récupération de météo, nous avons interagi avec l’API OpenWeatherMap.
Nous avons utilisé SMTP Mail Sender qui un outil permettant l’envoi des emails à partir d’un serveur SMTP configurable.
Le plugin Scheduling Tasks est utilisé pour automatiser l’envoi de mail aux utilisateurs.

# 2.Front End : 
  Nous avons choisi Angular 5 pour la création du coté interface d’utilisation, c’est l’un des framework vu aux cours, nous avons opté pour ce dernier pour sa facilité d’utilisation.Angular est un framework utilisant le langage de programmation TypeScript. 
Utilisation des composant du framework globalement.
Le site se base sur du HTML et un Style CSS.
La non utilisation des composants PrimeNG était un choix également.
Utilisation d’un proxy afin de corriger les problèmes de CORS.

# Difficultés techniques rencontrées et solutions apportées:
   # La gestion de la base de donnée:
Les jointures entre les différentes tables étaient moyennement compliqué afin d’avoir le schéma souhaité.
La mise à jour des données et la récupération des bons résultats de requêtes fonctionnait pas correctement et souvent ça finit avec des erreur.
  La seule solution à disposition était de bien se former et de se baser sur le contenu des cours.
  # La gestion de sécurité avec Spring Security: 
Cette étape nous avait pris légèrement de temps, entre la connexion au compte utilisateur et la gestion du compte admin.
Nous avons géré cette fonctionnalité du côté du Front avec le chargement de composant. 

# Apport de projet:
  Ce projet était une bonne expérience, nous avons appris l’utilisation d’une large liste de technos Web très intéressantes et nous comptons l’améliorer plus tard.

# Conclusion: 
  Nous avons travaillé sur un projet Web basé sur des technologies utilisées dans le monde professionnel. Nous avons consolidé nos connaissances générales et appris à faire des applications plus attrayantes et plus orientées pour le monde de travail.






















