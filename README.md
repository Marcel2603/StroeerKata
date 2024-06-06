# StroeerKata

Dies ist das Repository, für die Fachaufgabe von Ströer

## Aufgabe

> "Fetch asynchronous data from an API".\
> \
> Your task is to write a script or app, which gathers data from two endpoints asynchronously, merges the responses and
> displays them in any way, for example as JSON response from an REST API.\
> For example, you could use these two endpoints:\
> \
> <http://jsonplaceholder.typicode.com/users/1> to obtain a user's data\
> <http://jsonplaceholder.typicode.com/posts?userId=1> to obtain all comments written by that user\
> \
> Please submit your solution via GitHub and commit frequently. \
> \
> If you find a straightforward solution for the 'problem', even better.
> We would like to see, what you achieve within 2 hours timeboxed and how you approach the challenge.
> If you have time left over, we are happy if you improve your solution in a direction that you think fits the challenge.
> We are looking forward to speak with you about your solution.

## Überlegungen / Herangehensweise

### Anforderungen

- asynchron
- json-verarbeiten
- lightweight

### Entscheidungen

#### Programmiersprache

Die Aufgabe ist in 2 Teile untergliedert. Der erste Teil beschäftigt sich mit dem Abholen der Daten. Dieser soll
asynchron erfolgen. Anschließend sollen die Antworten zusammengefügt werden.

Die ich einen lightweight Ansatz verfolge, fällt Java und Spring Boot raus, da diese mit der JVM und einem BuildTool zu
aufwändig / klobig ist.\
Eine weitere Idee wäre Python. Hier haben wir mit Python 3.5 (oder 6?) async/await als natives Feature erhalten. Der
Nachteil, dass die async Api aufwändiger zu implementieren wäre. Bleibt also noch Javascript (um im Techstack der Firma
zu bleiben).

Javascript hat den Vorteil, dass wir sher komfortabel über Promises die Asynchronität verarbeiten können. Außerdem
arbeitet es perfekt mit JSON zusammen.

### Ablauf

- [x] Repository erstellen
- [x] MVP implementieren
  - [x] Was gebe ich zurück?
- [x] Was kann ich zusätzlich dokumentieren?
  - [x] How-To ergänzen
- Wie kann ich die Qualität erhöhen?
  - [x] formatter (prettier, markdown-lint)
  - [x] Hilft ein Dockercontainer?
  - brauche ich tests? --> mehrwert hier fraglich
    - test wäre "Prüfe ob Mockresponses gemerged werden"
  - github actions? --> mehrwert für dieses projekt nicht gegeben
    - könnte auf formatierung prüfen
    - ausführung von tests
    - docker container bauen
  - Fehlerhandling

### Herausforderungen

#### Unterschiedliche Datentypen (done)

Wie kann ich die Requests unterscheiden?
-> Das eine ist ein Objekt, das andere eine Liste.\
**Lösung:** ~~Prüfe ob "Name" als Key im Objekt vorkommt.~~ Mittels `Array.isArray` prüfen, ob die erste Antwort ein
Array ist.

#### Geo-Informationen werden nicht korrekt dargestellt (done)

```json
address: {
  street: 'Kulas Light',
  suite: 'Apt. 556',
  city: 'Gwenborough',
  zipcode: '92998-3874',
  geo: [Object]
}
```

Wie man bereits sieht, existieren aktuell noch 2 Probleme.\
Zum einen loggt das Script **nicht** im Json-Format und zum anderen wird "geo" als Object ausgegeben.\
**Lösung:** Ausgabe der Antwort als Json-String.

## How To

### Voraussetzungen

Du musst folgende Tools installiert haben:

- node
- npm (optional)
- docker (optional)

### Ausführung

#### Ausführung mittels Node

```shell
node src/index.js
```

Das Skript gibt die Antwort als JSON-String auf der Konsole aus.

#### Ausführung mittels npm

```shell
npm run script
# falls nur der output des Skripts gewünscht ist
npm -s run script
```

#### Ausführung via Docker

```shell
# build the image
docker build . -t kata:1.0

# run the image
docker run kata:1.0
```

#### Ausführung via Terminal

```shell
./src/index.js
```

### Formatierung

```shell
npm install

# format js code
npm run format:javascript

# format markdown
npm run format:markdown

# alles formatieren
npm run format
```
