# Clojure Rest MySQL Basic Template

Basic template to run a REST server with Ring Clojure, serving MySQL database, on clojure environment

## Clojure libraries used

- [Ring](https://github.com/ring-clojure/ring)
- [Compojure](https://github.com/weavejester/compojure)
- [Next-JDBC](https://github.com/seancorfield/next-jdbc)
- [Clojure Data](https://github.com/clojure/data.json)

## Installation

```
git clone https://github.com/daryllman/clojure-rest-mysql-basic-template-basic-template
```

## Usage

### 1. Compile to an UberJAR file

```
lein uberjar
```

This will create 2 uberjar files in /target/uberjar

### 2. Run UberJAR file with java

```
java -jar target\uberjar\clojure-rest-basic-template-0.1.0-SNAPSHOT-standalone.jar [args]
```

### 3. Check if its working

Go to [http://localhost:8000](). If everything looks good, all is working fine.

## License

Copyright © 2020 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
