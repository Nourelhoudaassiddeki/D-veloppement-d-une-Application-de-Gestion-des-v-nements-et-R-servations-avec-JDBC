
# Développement d’une Application de Gestion des Événements et Réservations avec JDBC
## description:
**la gestion des événements, la réservation des salles et terrains, ainsi que la gestion des utilisateurs (étudiants et professeurs). Cette application Java utilise JDBC pour interagir avec une base de données relationnelle: **
### Les événements.

### Les salles et terrains.

### Les utilisateurs (étudiants et professeurs).

### Les réservations.
## pre-requis
### les tables :
- `event` (id_event, nom_event, date_event, description, id_user)
- `salle` (id_salle, name,capacite )
- `terrain` (id_terrain, name, type)
- `user` (id_user, nom, prenom, type, email)
- `reservation` (id_reservation, id_event, id_salle, id_terrain, id_user)
## fonctionnalités
- **Gestion des événements** :insertion, affichage, mise à jour et suppression 
- **Gestion des salles et terrains** :insertion, affichage et suppression
- **Gestion des utilisateurs** :insertion, affichage et suppression
- **Gestion des réservations** :insertion, affichage, mise à jour , suppression reservation,verification de disponabilite
### Contraintes techniques
- Utilisation de JDBC pour interagir avec la base de données
- Utilisation de Java pour le développement de l'application
- Utilisation de la base de données relationnelle pour stocker les données par postgresql
### Structure du Projet
JBDC/
├── src/
│   ├
│   └── 
│       ├── ajouteterrain.java
│       ├── ajoutsalle.java
│       ├── ajoutevent.java
│       ├── ajouteusers.java
│       ├── disponibilite.java
│       ├── reserver.java
│       ├── connexion.java
│       ├── selectevent.java
│       ├── selectreservation.java
│       ├── selectsalle.java
│       ├── selectterrain.java
│       ├── selectuser.java
│       ├── supprimerreservation.java
│       ├── supprimesalle.java
│       ├── supprimeterrain.java
│       ├── suppuser.java
│       ├── suprimevent.java
│       ├── updateevent.java
│       └── updatereservation.java
└── README.md