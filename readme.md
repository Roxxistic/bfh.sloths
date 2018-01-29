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

### Usage

### Entwicklung

Bei der Entwicklung ist IntelliJ IDEA verwendet worden. Der Vorteil (neben den üblichen Benefits von IntelliJ) ist die simple Integration von Maven (automatisches Importieren von Dependencies) und Spring-Boot (Initializr).
Jeder Service ist als eigenständiges IntelliJ IDEA Project erstellt worden. Sie befinden sich alle in einem gemeinesamen Verzeichnis. Dieses enthält zusätzlich ein übergeordnetes .POM, welches die einzelnen Spring-Boot Projekte als Module referenziert und ein Docker-Compose File.

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

### Aufteilung des Codes auf verschiedene Projekte oder alles in einem Projekt?
### Welche Dependencies werden wirklich benötigt? (Test, Actuator, HystrixDashboard)
### Aufteilung des Domain Models.
### Mehrere Domain Entities pro Service.
### Mapping, falls Unterschiede in Model.

### Stand des Projektes bei Abgabetermin (31.01.2018)