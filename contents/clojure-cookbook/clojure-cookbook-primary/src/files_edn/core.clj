(ns files-edn.core
  (:require
   [clojure.edn :as edn]))

;; Reading Simple EDN Files

(def edn_simple_sample_data (edn/read-string (slurp "data_set/simple_example_read.edn")))

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
(spit "data_set/simple_example_write.edn" edn_simple_sample_data)

;; Read Custom EDN Files

(defn wishes-reader [data]
  (println "Parsing myapp/wishes tag with data:" data)
  (str data " >>|<< " data))

(def edn_custom_sample_data (edn/read-string {:readers {'myapp/wishes wishes-reader}} (slurp "data_set/custom_example_read.edn")))

edn_custom_sample_data
;; => {:name "John Doe", :age 30, :email "john.doe@example.com", :address {:street "123 Main St", :city "New York", :state "NY", :zip "10001"}, :interests ["programming" "reading" "hiking"], :wishes ["Learn 100 languages >>|<< Learn 100 languages" "Teleport to office >>|<< Teleport to office"]}

(:wishes edn_custom_sample_data)
;; => ["Learn 100 languages >>|<< Learn 100 languages" "Teleport to office >>|<< Teleport to office"]

(:age edn_custom_sample_data)
;; => 30

(:author (meta edn_custom_sample_data))
;; => "John"
