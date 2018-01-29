# Modul: BTI7515 - Software Entwicklung Open Source 1

**Authors**: Marc Rey, Pascal Ammon

**Supervisor**: Villars Roger

## Manual

### Installation

### Usage

## Architecture

### Domains

### Services

## Kritische Reflektion

### Domain Model

![original domain model UML](https://raw.githubusercontent.com/Roxxistic/bfh.sloths/master/readme_domainmodel_original.png)

* Problem: Zum Zeitpunkt der Festsetzung eines Domain Models war uns noch nicht genügend bewusst, dass eine Micro-Services Architektur angestrebt wird - und was dies bedeutet. Daher besteht das ursprüngliche Domain Model aus Klassen, die sehr stark Verknüpft sind.


### Schwierigkeiten bei der Umsetzung und deren Lösung
* Docker auf Microsoft Windows
* Aufteilung des Codes auf verschiedene Projekte oder alles in einem Projekt?
* Welche Dependencies werden wirklich benötigt? (Test, Actuator, HystrixDashboard)
* Aufteilung des Domain Models.
* Mehrere Domain Entities pro Service.
* Mapping, falls Unterschiede in Model.

### Stand des Projektes bei Abgabetermin (31.01.2018)