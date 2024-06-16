# Java

Damit wir mehr Features einbauen und generell flexibler aufgestellt sind, wollen wir die
Aufgabe in Java lösen.

## Ablauf

- [x] Ordner erstellen
- [x] Mvp aufbauen
  - [x] Einbinden der Api
  - [x] Mergen
  - [x] Rückgabe
- [x] Was kann man noch machen?
  - [x] einbinden Openapi
  - [x] Docker
  - [x] Doku
  - tests könnte man noch einbauen (Mockito, Jacoco)
  - [x] Fehlerhandling (beispielhaft)
  - [x] User nach id suchen

## Herausforderungen

### Welchen Requestclient verwende ich?

Hier habe ich mich für Webclient entschieden, da dieser sehr gut mit der asynchronen Verarbeitung harmoniert.

## How To

### Voraussetzungen

Du musst folgende Tools installiert haben:

- java (21)
- maven (optional)
- docker (optional)

#### Ausführung mittels Maven

```shell
mvn spring-boot:run
```

Anschließend kann man mittels curl oder Postman einen Request gegen "localhost:8080/user" abschicken.
Wenn man den Query-Parameter "id" hinzufügt, kann man noch nach weiteren User suchen.

#### Ausführung via Docker

```shell
# build the image
docker build . -t kata:1.0

# run the image
docker run -p 8080:8080 kata:1.0
```
