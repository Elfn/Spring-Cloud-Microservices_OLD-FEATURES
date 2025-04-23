SPRING-MICROSERVICES
bash
mvn spring-boot:run -Drun.jvmArguments='-Dserver.port=8088'
🛠️ Configuration
Config Server : Centralise la configuration de tous les microservices.

⚙️ Architecture & Composants
Scalabilité Dynamique
Eureka (Naming Server) :

Enregistrement des microservices

Découverte des microservices

Ribbon : Load balancing entre les instances de microservices

Feign : Création simplifiée de clients REST

Visibilité & Monitoring
Zipkin & Sleuth : Tracing distribué

Netflix API Gateway (Zuul) : Gateway de l'architecture

Tolérance aux Pannes
Hystrix : Définit une réponse par défaut quand un service est indisponible

🧱 Étapes de Création de l'Architecture
Création du microservice Limit

Mise en place du Config Server

Création d’un dépôt Git local pour les configurations centralisées

Développement du service Currency Exchange

Développement du service Currency Conversion

Mise en place du serveur Eureka

🚀 Ordre de Lancement des Services
Eureka Naming Server

bash
Copier le code
mvn spring-boot:run
Zipkin (avec RabbitMQ)

bash
Copier le code
RABBIT_URI=amqp://localhost java -jar zipkin.jar
Currency Conversion & Exchange Services

bash
Copier le code
mvn spring-boot:run
Netflix Zuul API Gateway

bash
Copier le code
mvn spring-boot:run
🔍 Tracing Distribué avec Sleuth & Zipkin
Sleuth attribue un ID unique à chaque requête pour le suivi

Zipkin écoute via RabbitMQ pour tracer les requêtes

bash
Copier le code
RABBIT_URI=amqp://localhost java -jar zipkin.jar
Plus d'infos : Zipkin Quickstart

🔗 Liens Utiles
Eureka Dashboard : http://localhost:8761/
















ChatGPT peut faire des erreurs. Envisagez de vérifier les informations importantes.
