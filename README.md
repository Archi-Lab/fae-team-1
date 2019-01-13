# Ungewöhnlicher Aufenthaltsort

Der Ungewöhnlicher-Aufenthalt Service umfasst die Folgenden Features:
  - Verwaltung von erlaubten Aufenthaltsorten
  - Erkennung und Meldung von ungewöhnlichen Aufenthaltsorten

## Installation
Zur Installation müssen die Quelldateien zunächst mittles Maven kompiliert werden, anschließend kann der Service über die beiliegende docker-compose.yml durch Docker gestartet werden.
```sh
$ mvn package
$ docker-compose build
$ docker swarm init
$ docker stack deploy --compose-file=docker-compose.yml fae-prod
```
Der Ungewöhnlicher-Aufenthalt Service benötigt zudem eine Reihe von anderen Komponenten, bevor er Ordnungsgemäß funktionieren kann. Welche dies sind und wie Sie konfiguriert werden müssen ist im Folgenden erläutert.

### Erforderliche Komponenten aus anderen Sub-Domänen

* [Message Broker][FAE-kafka] - Kafka Message Broker
* [Draußen Ortung][FAE-ortung] - Publiziert aktuelle Aufenthaltsorter von GPS-Trackern
* [Dementiell Veränderte Person][FAE-dvp] - Verwaltet Daten über dementiell veränderte Personen

### Datenbank
Das beiliegende docker-compose Skript konfiguriert neben dem Ungewöhnlicher-Aufenthaltsort Service zusätzliche eine Postgres Instanz.

### Netzwerk Konfiguartion
Dies sind die Hostnamen und Ports, unter welchen die anderen Services erwartet werden:
| Port | Hostname | Service |
| ------ | ------ | ------ |
| 5432 | postgres | Postgres Datenbank |
| xxxx | xxxx | xxxx |

## Benutzung
Hier sollte die Benutzung des Services evtl. durch ein Beispiel unterstützt beschrieben werden.


[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

[FAE-kafka]: <https://github.com/Archi-Lab/fae-message-broker>
[FAE-ortung]: <https://github.com/Archi-Lab/fae-draussen-ortung>
[FAE-dvp]: <https://github.com/Archi-Lab/fae-team-2-dementiell-veraenderte-person>