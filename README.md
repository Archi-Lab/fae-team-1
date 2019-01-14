# Ungewöhnlicher Aufenthaltsort

Der Ungewöhnlicher-Aufenthalt Service umfasst die Folgenden Features:
  - Verwaltung von erlaubten Aufenthaltsorten
  - Erkennung und Meldung von ungewöhnlichen Aufenthaltsorten

## Installation
Zur Installation müssen die Quelldateien zunächst mittles Maven kompiliert werden und anschließend das Image erstellt werden.
```sh
$ mvn package
$ docker-compose build
```

Wir verwenden Docker Swarm und benötigen aus diesem Grund eine geeignete Version eines Kafka Containers.
Dieser Kann durch das beiliegende swarm-broker.yml erstellt werden. Zuvor muss Docker jedoch in den Swarm Modus versetzt werden.
```sh
$ docker swarm init
```

Anschließend kann der Kafka Container erstellt und ausgeführt werden:
```sh
$ docker-compose -f swarm-broker.yml -p fae-message-broker up -d
```

Zuletzt wird der Ungewöhnlicher-Aufenthalt Service gestartet:
```sh
$ docker stack deploy --compose-file=docker-compose.yml fae-prod
```
Standardmäßig werden zwei Instanzen des Ungewöhnlicher-Aufenthalt Service gestartet. Diesen steht eine Postgres Instanz als Datenbank zur Verfügung. Die Insanzen des Ungewöhnlicher-Aufenthalt Service sind über einen HAProxy als Loadbalancer auf Port 80 (Host) erreichbar. Eine beliebige Skalierung der Instanzen ist über den folgenden Docker Befehl möglich:
```sh
$ docker service scale fae-prod_ungewoehnlicher-aufenthaltsort=4
```
Die Anzahl der Instanzen kann hierbei beliebig verändert werden.

Das stoppen der Services erfolgt durch:
```sh
$ docker stack rm fae-prod
$ docker-compose -f swarm-broker.yml -p fae-message-broker stop
```

Der Ungewöhnlicher-Aufenthalt Service benötigt zudem eine Reihe von anderen Komponenten, bevor er Ordnungsgemäß funktionieren kann.

### Erforderliche Komponenten aus anderen Sub-Domänen
* [Draußen Ortung][FAE-ortung] - Publiziert aktuelle Aufenthaltsorter von GPS-Trackern
* [Dementiell Veränderte Person][FAE-dvp] - Verwaltet Daten über dementiell veränderte Personen


## Benutzung
Hier sollte die Benutzung des Services evtl. durch ein Beispiel unterstützt beschrieben werden.


[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

[FAE-kafka]: <https://github.com/Archi-Lab/fae-message-broker>
[FAE-ortung]: <https://github.com/Archi-Lab/fae-draussen-ortung>
[FAE-dvp]: <https://github.com/Archi-Lab/fae-team-2-dementiell-veraenderte-person>