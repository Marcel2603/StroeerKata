# Javascript

Javascript hat den Vorteil, dass wir sehr komfortabel über Promises die Asynchronität verarbeiten können. Außerdem
arbeitet es perfekt mit JSON zusammen.

## Ablauf

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
  - [x] Fehlerhandling

## Herausforderungen

### Unterschiedliche Datentypen (done)

Wie kann ich die Requests unterscheiden?
-> Das eine ist ein Objekt, das andere eine Liste.\
**Lösung:** ~~Prüfe ob "Name" als Key im Objekt vorkommt.~~ Mittels `Array.isArray` prüfen, ob die erste Antwort ein
Array ist.

### Geo-Informationen werden nicht korrekt dargestellt (done)

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
