(ns clojure-rest-mysql-basic-template.db.model
  (:require [next.jdbc :as jdbc]))

; products Dataset columns
; id - ID of the product
; name - Name of the product
; price - Price of the product
;;; To check data types: https://www.w3schools.com/sql/sql_datatypes.asp

; CRUD OPERATIONS for kindle_products mysql database
; - READ all products
; - READ products of a specified price
; - CREATE a product

(def db {:dbtype "mysql" :dbname "shoe-products"})
(def ds (jdbc/get-datasource db))



; Insert some sample data
(defn load-sample-data [ds]
  (jdbc/execute! ds ["INSERT INTO products (id, name, price)
                      VALUES (?,?,?), (?,?,?), (?,?,?), (?,?,?)"
                     "1001" "Nike Black Shoe" "99"
                     "1002" "Nike White Shoe" "99"
                     "1003" "Puma Running Shoe" "110"
                     "1004" "Puma Walking Shoe" "105"]))

; Create 'products' Table
(defn create-table [ds] ;change to drop table if exists;
  (jdbc/execute! ds ["
                      CREATE TABLE IF NOT EXISTS products (
                      id char(4),
                      name varchar(255),
                      price varchar(5),
                      )"])
  (println "Created products Table")
  (load-sample-data ds)
  (println "Loaded some sample data"))



; Insert
(defn create-product [ds id name price]
  (println "Inserting a row")
  (jdbc/execute!
   ds
   ["INSERT INTO products (id, name, price)
                VALUES (?,?,?)"
    id name price]))



; Read All - wont really be used. Just for testing purpose
(defn read-all-products [ds]
  (println "Reading all products")
  (jdbc/execute! ds ["SELECT * from products"]))


; Read products of a price
(defn read-a-review [ds price]
  (println "Reading products of a price - " price)
  (jdbc/execute! ds ["SELECT * from products WHERE price=?" price]))
