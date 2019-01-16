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

Wir verwenden Docker Swarm und benötigen aus diesem Grund eine Swarm fähige Version von Kafka.
Dieser Kann durch das beiliegende kafka-swarm.yml erstellt werden. Zuvor muss Docker jedoch in den Swarm Modus versetzt werden.
```sh
$ docker swarm init
```

Anschließend kann der Kafka Swarm Service erstellt und ausgeführt werden:
```sh
$ docker stack deploy -c kafka-swarm.yml fae-message-broker
```

Der Ungewöhnlicher-Aufenthalt Service wird auf gleichem Wege gestartet:
```sh
$ docker stack deploy -c docker-compose.yml fae-ua
```

Standardmäßig werden zwei Instanzen des Ungewöhnlicher-Aufenthalt Service gestartet. Diesen steht eine Postgres Instanz als Datenbank zur Verfügung. Die Instanzen des Ungewöhnlicher-Aufenthalt Service sind über einen HAProxy als Loadbalancer derzeit über Port 80 (Host) erreichbar. Eine beliebige Skalierung der Instanzen ist über den folgenden Docker Befehl möglich:
```sh
$ docker service scale fae-ua_ungewoehnlicher-aufenthaltsort=4
```
Die Anzahl der Instanzen kann hierbei beliebig verändert werden.

Das stoppen der Services erfolgt durch:
```sh
$ docker stack rm fae-ua
$ docker stack rm fae-message-broker
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
