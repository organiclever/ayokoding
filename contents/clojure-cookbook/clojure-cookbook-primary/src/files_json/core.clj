(ns files-json.core
  (:require [clojure.data.json :as json]))

;; Reading JSON Files
(def json-file (slurp "data_set/example_read.json"))

json-file
;; => "{\n  \"name\": \"John Doe\",\n  \"age\": 30,\n  \"email\": \"john.doe@example.com\",\n  \"address\": {\n    \"street\": \"123 Main St\",\n    \"city\": \"New York\",\n    \"state\": \"NY\",\n    \"zip\": \"10001\"\n  },\n  \"interests\": [\n    \"programming\",\n    \"reading\",\n    \"hiking\"\n  ]\n}\n"

(def non-kw-json-data (json/read-str json-file))
non-kw-json-data
;; => {"name" "John Doe",
;;     "age" 30,
;;     "email" "john.doe@example.com",
;;     "address" {"street" "123 Main St", "city" "New York", "state" "NY", "zip" "10001"},
;;     "interests" ["programming" "reading" "hiking"]}
(class non-kw-json-data)
;; => clojure.lang.PersistentArrayMap
(type non-kw-json-data)
;; => clojure.lang.PersistentArrayMap
(select-keys non-kw-json-data ["name" "age" "email" "interests"])
;; => {"name" "John Doe", "age" 30, "email" "john.doe@example.com", "interests" ["programming" "reading" "hiking"]}
(non-kw-json-data "address")
;; => {"street" "123 Main St", "city" "New York", "state" "NY", "zip" "10001"}
(get-in non-kw-json-data ["address" "street"])
;; => "123 Main St"

(def kw-json-data (json/read-str json-file :key-fn keyword))
kw-json-data
;; => {:name "John Doe",
;;     :age 30,
;;     :email "john.doe@example.com",
;;     :address {:street "123 Main St", :city "New York", :state "NY", :zip "10001"},
;;     :interests ["programming" "reading" "hiking"]}
(class kw-json-data)
;; => clojure.lang.PersistentArrayMap
(type kw-json-data)
;; => clojure.lang.PersistentArrayMap
(select-keys kw-json-data [:name :age :email :interests])
;; => {:name "John Doe", :age 30, :email "john.doe@example.com", :interests ["programming" "reading" "hiking"]}
(kw-json-data :address)
;; => {:street "123 Main St", :city "New York", :state "NY", :zip "10001"}
(get-in kw-json-data [:address :street])
;; => "123 Main St"

;; Writing JSON Files

(spit "data_set/example_write_non_kw.json" (json/write-str non-kw-json-data))
(slurp "data_set/example_write_non_kw.json")
;; => "{\"name\":\"John Doe\",\"age\":30,\"email\":\"john.doe@example.com\",\"address\":{\"street\":\"123 Main St\",\"city\":\"New York\",\"state\":\"NY\",\"zip\":\"10001\"},\"interests\":[\"programming\",\"reading\",\"hiking\"]}"
(= (json/read-str (slurp "data_set/example_write_non_kw.json")) non-kw-json-data)
;; => true
(type (kw-json-data :interests))
;; => clojure.lang.PersistentVector

(spit "data_set/example_write_kw.json" (json/write-str kw-json-data))
(slurp "data_set/example_write_kw.json")
;; => "{\"name\":\"John Doe\",\"age\":30,\"email\":\"john.doe@example.com\",\"address\":{\"street\":\"123 Main St\",\"city\":\"New York\",\"state\":\"NY\",\"zip\":\"10001\"},\"interests\":[\"programming\",\"reading\",\"hiking\"]}"
(= (json/read-str (slurp "data_set/example_write_kw.json") :key-fn keyword) kw-json-data)
;; => true
(= (slurp "data_set/example_write_non_kw.json")
   (slurp "data_set/example_write_kw.json"))
;; => true

;; pretty printing when writing JSON files

(spit "data_set/example_write_pretty.json" (with-out-str (clojure.data.json/pprint kw-json-data)))