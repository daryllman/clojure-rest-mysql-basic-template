(defproject clojure-rest-mysql-basic-template-basic-template "0.1.0-SNAPSHOT"
  :description "Basic template to run a REST server with Ring Clojure, serving MySQL database, on clojure environment"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring "1.8.2"]
                 [compojure "1.6.2"]
                 [org.clojure/java.jdbc "0.7.11"]
                 [seancorfield/next.jdbc "1.1.610"]
                 [mysql/mysql-connector-java "8.0.21"]
                 [org.clojure/data.json "1.0.0"]]
  :main ^:skip-aot clojure-rest-mysql-basic-template.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
