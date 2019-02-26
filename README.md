# Ungewöhnlicher Aufenthaltsort

Der Ungewöhnlicher-Aufenthaltsort-Service umfasst die Folgenden Features:
  - Verwaltung von erlaubten Aufenthaltsorten
  - Erkennung und Meldung von ungewöhnlichen Aufenthaltsorten

## Installation
Zur Installation müssen die Quelldateien zunächst unter zuhilfenahme von Maven kompiliert und anschließend das Image erstellt werden.
```sh
$ mvn package -DskipTests=true
$ docker-compose build
```

Standardmäßig sollte ein Microservice immer mit mindestens zwei Instanzen getestet und betrieben werden, um sicherzustellen, dass die Skalierung des Services zu keinerlei Komplikationen führt. Durch den Folgenden Aufruf, wird der Ungewöhnlicher-Aufenthalt-Service und seine direkten Abhängigkeiten gestartet. Die Anzahl der Instanzen für den ua-service kann hierbei beliebig verändert werden, bzw. der --scale Befehl optional auch weggelassen oder auf 1 gesetzt werden. Dies ist Aufgrund der zuvor gennanten Gründe allerdings nicht zu empfehlen.

```sh
$ docker-compose up --scale ua-service=2
```

Neben der ua-service Instanzen werden durch den o.g. Befehl auch noch weitere Container angelegt. Hierbei handelt es sich zum einen um einen Postgres, welcher den ua-service Instanzen als Datenbank dient. Zum anderen wird zusätzlich ein HAProxy erzeugt, dieser dient als Loadbalancer, um eingehende REST Aufrufe in Richtung der ua-service Instanzen zu orchestrieren. Der Proxy ist nach außen (auf dem Host) über den Standardport 80 erreichbar.


Der Ungewöhnlicher-Aufenthalt Service benötigt zudem eine Reihe von anderen Komponenten, bevor er Ordnungsgemäß funktionieren kann.

### Erforderliche Komponenten aus anderen Sub-Domänen
* [Message Broker][FAE-kafka] - Stellt das Messaging Backend basierend auf Apache Kafka bereit
* [Draußen Ortung][FAE-ortung] - Publiziert aktuelle Aufenthaltsorter von GPS-Trackern
* [Dementiell Veränderte Person][FAE-dvp] - Verwaltet Daten über dementiell veränderte Personen


[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

[FAE-kafka]: <https://github.com/Archi-Lab/fae-message-broker>
[FAE-ortung]: <https://github.com/Archi-Lab/fae-draussen-ortung>
[FAE-dvp]: <https://github.com/Archi-Lab/fae-team-2-dementiell-veraenderte-person>
