(ns clojure-rest-mysql-basic-template.core
  (:require [clojure-rest-mysql-basic-template.db.model :as products]
            [clojure-rest-mysql-basic-template.db.handler :refer [handle-all-products
                                                                  handle-create-product
                                                                  handle-a-product]])
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [compojure.core :refer [defroutes ANY GET POST PUT DELETE]]
            [compojure.route :refer [not-found]]
            [ring.handler.dump :refer [handle-dump]]
            [next.jdbc :as jdbc]))

; Initialise database -> datasource
(def db {:dbtype "mysql" :dbname "shoe-products" :user "root" :password "1234" :serverTimezone "UTC"})
(def ds (jdbc/get-datasource db))


(defn greet [req]
  {:status 200
   :body "Hello world"
   :headers {}})

(defn yo [req]
  (let [name (get-in req [:route-params :name])]
    {:status 200
     :body (str "Yo " name "!")
     :headers {}}))

; REST routes
(defroutes routes
  (GET "/" [] greet)
  (GET "/request" [] handle-dump)
  (GET "/yo/:name" [] yo)

  (GET "/products" [] handle-all-products)
  (POST "/products" [] handle-create-product)
  (POST "/product" [] handle-a-product)

  (not-found "Page not found"))

(defn wrap-db [hdlr]
  (fn [req]
    (hdlr (assoc req :clojure-rest-mysql-basic-template/ds ds))))

(defn wrap-server [hdlr]
  (fn [req]
    (assoc-in (hdlr req) [:headers "Server"] "shoe-products MySQL Server")))

(def app
  (wrap-server (wrap-db (wrap-params routes))))

(defn -main []
  (println "Starting...")
  (products/create-table ds)
  (jetty/run-jetty app {:port (Integer. 8000)}))

(defn -dev-main []
  (products/create-table ds)
  (jetty/run-jetty (wrap-reload #'app) {:port (Integer. 8000)}))


