# ProjetTaa : Week End Planner


# Contexte
  Ce projet nous a été proposé dans le cadre du cours de `Taa`, il vise globalement l’utilisation des technologies Web.
Nous avons eu le libre choix de l'environnement de développement, frameworks, base de données…

  Le projet consiste à réaliser un site web dynamique en utilisant les différentes technos acquises, à savoir : `Maven`, `Spring Boot`, `Java ee`, `React`, `Angular` …

  Ce site Web permet l'utilisateur de consulter les coordonnées météorologiques d’une ou de plusieurs villes afin de programmer une activitée pour le week end.

Un cahier des charges détaillé nous a été fourni au début du projet.

# Fonctionnalités 

## 1.Connexion :
  La première connexion, l’utilisateur doit s'identifier en introduisant son nom et son adresse mail. Les futures connexions se font par le nom et le mot de passe choisis.
Un bouton de déconnexion est présent dans la bar de menu pour quitter le compte.  

## 2.Site Web: 
  La page `Home` affiche la liste des lieux et sports favoris de l’utilisateur, en cliquant dessus, il peut retirer un élément de ces listes.

  Le composant `Sport`, permet à l’utilisateur de visionner les sports proposés par le site, en cliquant dessus il ajoute un sport à sa liste des favoris.

  Le composant `City` aide l’utilisateur à avoir une vision des différentes villes existantes sur le site ainsi les sports disponibles dans ces dernières.

  En cliquant sur le bouton d’ajout de favori, l’utilisateur pourra ajouter une ville dans sa liste si les sports proposés l'intéressent.


# 3.Récupération de données : 
  La partie `Weather` fournit la météo qui correspond à la ville saisie par  l’utilisateur. Le site proposera un ensemble d’activitées en se basant à la fois sur les villes favorites et les données météorologiques.
  Une activité se pratique dans une ou plusieurs conditions météorologiques précises.

  Un email contenant les informations relatives à la météo et aux activitées et villes favorites est envoyé à tous les utilisateurs automatiquement chaque `Mercredi à 8h`.


# Choix des technologies : 

## 1.Back End: 
  En se basant le contenu des cours de `Taa` et étant donné les fonctionnalitées du projet, nous avons choisi `Spring Boot` comme framework qui est un outils puissant grâce aux plugins. `Apache Maven`  nous servira pour la gestion du projet.
Nous avons choisi d’utiliser un serveur `Apache Tomcat` et une base `MySQL` qui nous offre accès à nos données stockées.
Pour le transfert des données, le service `REST` été choisi.
Pour la récupération de météo, nous avons interagi l’API `OpenWeatherMap`.
Nous avons utilisé `SMTP Mail Sender` qui un outils permettant l’envoi des emails à partir d’un serveur `SMTP` configurable.
Le plugin `Scheduling Tasks` est utilisé pour automatiser l’envoi de mails aux utilisateurs.
Le schéma des services proposés par l'API sont détaillés avec le `Swagger`via l'url: `localhost:xxxx/swagger-ui.html`

## 2.Front End : 
  Nous avons choisi `Angular 5` pour la création de la partie Vue, c’est l’un des frameworks vus aux cours, nous avons opté pour ce dernier pour sa facilité d’utilisation. Angular est un framework utilisant le langage de programmation `TypeScript`. 
Utilisation des composant du framework globalement.
Le site se base sur du `HTML` et du `CSS`.
La non utilisation des composants `PrimeNG` était un choix également.
Utilisation d’un `proxy` afin de corriger les problèmes de `CORS`.

# Difficultés techniques rencontrées et solutions apportées:

   ## La gestion de la base de données:
Les jointures entre les différentes tables étaient moyennement compliqué afin d’avoir le schéma de la base souhaité.
La mise à jour des données et la récupération des bons résultats de requêtes fonctionnait pas correctement et souvent ça finit par des erreurs.
  La seule solution à disposition était de revenir aux des cours.
  
  ## La gestion de sécurité avec `Spring Security`: 
Cette étape nous avait pris légèrement de temps, spécialement la connexion au compte utilisateur et la gestion du compte admin.
Nous avons géré cette fonctionnalité du côté du Front et nous avons limiter l'accès au model à l'admin. 

# Apport du projet:
  Ce projet était une bonne expérience, nous avons appris l’utilisation d’une large liste de technologies Web très intéressantes et nous comptons l’améliorer plus tard.
  
 # fonctionnalités à ajouter :
  1. Mettre l'application sous conteneur `Docker`
  2. Amélioration des contraintes de sécurité
  3. Déploiement sur un serveur `Nginx`
  4. Ajout de fonctionnalités 
  5. Envoi de mail via le site
  6. Ajout de sports, villes par l'utilisateur
  7. Gestion avancée du service de météo

# Conclusion: 
  Nous avons travaillé sur un projet Web basé sur des technologies utilisées dans le monde professionnel. Nous avons consolidé nos connaissances générales et appris à faire des applications plus attrayantes et plus orientées pour le monde de travail.
