(ns clojure-rest-mysql-basic-template.db.handler
  (:require [clojure-rest-mysql-basic-template.db.model :refer [read-all-products
                                                                create-product
                                                                read-a-product]]
            [ring.util.response :refer [response]]
            [clojure.data.json :as json]))


; id - ID of the product
; name - Name of the product
; price - Price of the product


(defn handle-all-products [req]
  (let [ds (:clojure-rest-mysql-basic-template/ds req)
        products (read-all-products ds)]
    ;; {:status 200
    ;;  :headers {}
    ;; ;  :body (str products)}))
    ;;  :body (list (json/write-str (response products)))}))
    {:status 200
     :body (list (json/write-str (response products)))}))

(defn handle-a-product [req]
  (let [ds (:clojure-rest-mysql-basic-template/ds req)
        ; id (get-in req [:params "id"])
        ; name (get-in req [:params "name"])
        price (get-in req [:params "price"])
        ; selected-product (read-a-product ds id name price)
        selected-product (read-a-product ds price)]
    {:status 200
     :headers {}
    ;  :body (str products)}))
     :body (list (json/write-str (response selected-product)))}))


(defn handle-create-product [req]
  (let [ds (:clojure-rest-mysql-basic-template/ds req)
        id (get-in req [:params "id"])
        name (get-in req [:params "name"])
        price (get-in req [:params "price"])]
    (create-product ds id name price)
    {:status 200
     :body (str "Successfully inserted a product - id" "(" id "), " "name" "(" name "), " "price" "(" price ")")}))

