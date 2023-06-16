(ns files-edn.core
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

;; Reading Simple EDN Files

(defn read-edn-file [file-path]
  (with-open [reader (io/reader file-path)]
    (edn/read-string (slurp reader))))

(def edn_simple_sample_data (read-edn-file "data_set/read_simple_example.edn"))

edn_simple_sample_data
;; => {:name "John Doe", :age 30, :email "john.doe@example.com", :address {:street "123 Main St", :city "New York", :state "NY", :zip "10001"}, :interests ["programming" "reading" "hiking"]}

(class edn_simple_sample_data)
;; => clojure.lang.PersistentArrayMap

(:name edn_simple_sample_data)
;; => "John Doe"
(:age edn_simple_sample_data)
;; => 30
(:email edn_simple_sample_data)
; => "john.doe@example.com"
(:address edn_simple_sample_data)
;; => {:street "123 Main St", :city "New York", :state "NY", :zip "10001"}
(:street (:address edn_simple_sample_data))
;; => "123 Main St"
(:interests edn_simple_sample_data)
;; => ["programming" "reading" "hiking"]

(def edn_simple_sample_meta_data (meta edn_simple_sample_data))

edn_simple_sample_meta_data
;; => {:author "John", :created-at "2022-01-01"}

(:author edn_simple_sample_meta_data)
;; => "John"
(:created-at edn_simple_sample_meta_data)
;; => "2022-01-01"

;; Writing Simple EDN Files

(defn write-edn-file [file-path data]
  (with-open [writer (io/writer file-path)]
    (binding [*out* writer]
      (prn data))))

(write-edn-file "data_set/write_simple_example.edn" edn_simple_sample_data)