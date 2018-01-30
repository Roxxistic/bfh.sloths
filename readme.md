# Sloths' Yellowpages

## Hintergrund

Dieses Projekt ist im Rahmen eines Moduls an der [BFH](https://www.bfh.ch) entstanden.

**Modul**: BTI7515 - Software Entwicklung Open Source 1

**Authors**: [Pascal Ammon](https://github.com/ammop2), [Marc Rey](https://github.com/Roxxistic)

**Supervisor**: Villars Roger

**Deadline**: 31.01.2018

**Auftrag**: 
* Aufgrund eines einfachen UML Domain Models ist mit den im Modul besprochenen Technologien eine kleine Applikation zu bauen. 
* Fokus der Applikation ist die Microservice-Architektur. Das Frontend ist irrelevant.
* Technology Stack: 
  * Git
  * Maven
  * Spring, Spring Boot, Spring MVC/REST, Spring Core, Spring Cloud
  * HAL Browser
  * Netflix OSS: Eureka, Ribbon, Feign, Zuul, Hystrix, Turbine
  * Docker
* Es ist eine Dokumentation inkl. Reflexion (dieses readme.md) zu erstellen.

## Manual

### Installation

Vorbedingung:

- Java 8 (zu Java 9 siehe unten)
- Maven
- Docker

### Variante: Spring-Boot:run

Starte jede Spring-Boot Applikation im jeweiligen Directory mit `mvn spring-boot:run` (einigermassen praktisch im integrierten Terminal von IntelliJ).

Dabei muss folgende Reihenfolge eingehalten werden:

1. registry-service
2. partner-service
3. contact-service
4. partner-contact-service
5. frontend-service

Es stehen folgende Endpoints zur Verfügung:

- http://localhost:1111 Eureka
- http://localhost:2222 Partner-Service (HAL Browser)
- http://localhost:3333 Contact-Service (HAL Browser)
- http://localhost:4444 Partner-Contact-Service (HAL Browser)
- http://localhost:8080/partners Frontend-Service für Partner-Service (HAL Browser)
- http://localhost:8080/contacts Frontend-Service für Contact-Service (HAL Browser)
- http://localhost:8080/partnercontacts Frontend-Service für Partner-Contact-Service (HAL Browser)

### Variante: docker-compose up

Im root Verzeichnis findet sich ein Docker-Compose File.

Es genügt mit `docker-compose up` zu starten.

Anzahl:
$$$$$$

## Architecture

### Domains

### Services

## Kritische Reflexion

Bei der Umsetzung der Applikation sind wir mit verschiedensten Schwierigkeiten konfrontiert worden.

### Thema

Das Thema dieser Applikation ist jenem des Moduls sehr ähnlich. Zur Zeit der Einreichung des UML Domain Models wurde im Modul anhand einer Book App demonstriert. Bald wurde dies aber zu einer Person Address Applikation.

### Domain Model

Das finale Domain Model entspricht nicht dem ursprünglich geplanten. Zum Zeitpunkt der Festsetzung eines Domain Models war uns noch nicht genügend bewusst, dass eine Micro-Services Architektur angestrebt wird - und was dies bedeutet. Daher besteht das ursprüngliche Domain Model aus Klassen, die sehr stark Verknüpft sind.

Ursprünglich geplantes Domain Model:

![original domain model UML](https://raw.githubusercontent.com/Roxxistic/bfh.sloths/master/readme-images/readme_domainmodel_original.png)

### Überblick über das Zusammenspiel des Technology Stacks

Aufgrund der Vielfalt an neuen Technologien und verschieden Möglichkeiten derer Integration ist ursprünglich unklar gewesen, wie die Lösung aufgebaut sein soll. Parallel zur Vorlesung haben wir jeweils versucht die App zu bauen, diese jedoch mit neu hinzukommenden Technologien jedoch wieder verworfen. 

Für den Überblick hilfreich sind die regelmässigen Übungen inklusive der Beispiel-Lösungen gewesen (siehe [SWOS Microservices 171207](https://github.com/rvillars/swos-microservices-171207)).

### Docker auf Microsoft Windows

Die Installation von Docker auf Windows 10 ist vorerst gescheitert. 

Das Vorgehen war, wie [offiziell beschrieben](https://docs.docker.com/docker-for-windows/install/):

1. Hyper-V und Containser aktivieren (PowerShell: `	Enable-WindowsOptionalFeature -Online -FeatureName containers –All` und `Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Hyper-V –All`) und Restart.
2. [Download](https://docs.docker.com/docker-for-windows/install/) und Installation von Docker.

Folgender Fehler ist aufgetreten:
![original domain model UML](https://raw.githubusercontent.com/Roxxistic/bfh.sloths/master/readme-images/readme_docker_error.png)

Diese Problem scheint seit einem kürzlichen Update von Windows 10 bei vielen Usern aufzutreten. Die [Emotionen](https://github.com/docker/for-win/issues/606#issuecomment-358697935) gehen hoch. Verschiedenste Lösungen werden präsentiert. Für uns war folgender Tipp hilfreich:

> Navigating to C:\Users\Public\Documents\Hyper-V\Virtual hard disks\ and requesting access, then restarting the Docker for Windows service fixed the issue for me. [tsasioglu](https://github.com/docker/for-win/issues/606#issuecomment-350027237)

### Aufteilung des Codes auf verschiedene Projekte oder alles in einem Projekt?

Bei der Entwicklung ist IntelliJ IDEA verwendet worden. Der Vorteil (neben den üblichen Benefits von IntelliJ) ist die simple Integration von Maven (automatisches Importieren von Dependencies) und Spring-Boot (Initializr).

Jeder Service ist als eigenständiges IntelliJ IDEA Project erstellt worden. Sie befinden sich alle in einem gemeinesamen Verzeichnis. Dieses enthält zusätzlich ein übergeordnetes .POM, welches die einzelnen Spring-Boot Projekte als Module referenziert und ein Docker-Compose File.

Dies entspricht unserer Meinung nach der Idee, dass Microservices von verschiedenen Teams gebaut und gepflegt werden. Somit sollte es sich um verschiedene Projekte handeln. Zudem ist dies mit IntelliJ die angenehmste Variante: Jedes Projekt kann mit dem integrierten Initializer erstellt werden.

### JAVA 9

Folgendes Problem hat uns einige Zeit geraubt:

![original domain model UML](https://raw.githubusercontent.com/Roxxistic/bfh.sloths/master/readme-images/readme_java9.png)

Grund: Gewisse Spring-Boot Starters verwenden JAXB. In JAVA 8 ist JAXB in der SE enthalten. In JAVA 9 jedoch ist dies nur noch über EE erhältlich. Der Einfachheit halber ist JAVA 8 verwendet worden.

(Danke an [rvillars](https://github.com/rvillars) für den Tipp. Siehe auch [Stackoverflow](https://stackoverflow.com/questions/43574426/how-to-resolve-java-lang-noclassdeffounderror-javax-xml-bind-jaxbexception-in-j))

### Vorgehen bei der Entwicklung



### Welche Dependencies werden wirklich benötigt? (Test, Actuator, HystrixDashboard)



### Aufteilung des Domain Models.


### Mehrere Domain Entities pro Service.


### Mapping, falls Unterschiede in Model.

### Stand des Projektes bei Abgabetermin (31.01.2018)

### Frontend Proxy

Wir erwarten, über die URL http://localhost:8080/partners/ auf den Partner-Service zugreifen zu können. Dies funktioniert jedoch nicht. Stattdessen erhalten wir den erwarteten HAL Browser über http://localhost:8080/partner-service/. Stattdessen begrüsst uns eine Whitelabel Error Page.

![Screenshot Frontendproxy Whitelabel Page](https://raw.githubusercontent.com/Roxxistic/bfh.sloths/master/readme-images/readme_frontendproxy_whitelabel.png)

Wenn wir jedoch (anders als in der Demo) im application.yml des Frontend-Service `zuul.routes.partner-service.stripPrefix:true` setzen, so werden wir erfolgreich über http://localhost:8080/partners/browser/index.html#/partners/ mit dem Partner-Service HAL Browser verbunden.

Dasselbe gilt natürlich auch für den Contact-Service und den Partner-Contact-Service.