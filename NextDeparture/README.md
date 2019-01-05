## Hexagonal Architecture

### NextDeparture

NextDeparture est une application permettant de rechercher les prochains départs pour une gare.
Ce nouveau service sera à la disposition :
- Des services de cartographies (Google, Mappy etc ...)
- Des particuliers via le site Transilien

Une recherche est considérée comme invalide lorsque celle ci ne comporte pas de nom de gare ou la date de recherche
est inférieur à la date actuelle.

#### Service de cartographie

Lorsque un service de cartographie identifie une gare, il envoie une demande de recherche à NextDeparture.
NextDeparture renvoie les quatres prochaines départs à cette gare. Les informations à afficher sont 
- l'heure
- Le trigramme de la ligne
- La possibilité de retard

{
    hour: """,
    train: ""
    disruption : true | false
} 

#### Plateforme Transilien

L'intégration de NextDeparture se fera de la façon suivante. Un moteur de recherche sera présentée à l'utilisateur. 
Celui ci aura la possibilité d'effectuer :
- une recherche simple (via le nom de la gare) 
- une recherche complexe (nombre de résultat, heure d'arrivée et/ou de départ) 

Les résultats de recherche indiqueront le détail des pertubations à la gare.
La recherche de la gare est une recherche fullText et elle ne cible que les gares de la région parisienne.
- l'heure
- Le trigramme de la ligne
- La société qui gère le transport
- La destination
- Les problèmes rencontrés dans cette gare

{
    station: "",
    hour: "",
    name: "",
    type: "train|bus|subway|tramway"
    partner: "",
    destination : {
        from: "",
        to: ""
    },
    disruptions  : []
}

NextDeparture renvoie au maximum 500 résultats.

Sur la plateforme transilien, il sera possible d'exporter les résultats au format CSV.

