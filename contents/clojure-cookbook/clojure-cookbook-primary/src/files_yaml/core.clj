(ns files-yaml.core
  (:require [clj-yaml.core :as yaml]))

;; Reading YAML Files
(def yaml-file (slurp "data_set/example_read.yaml"))

yaml-file
;; => "name: John Doe\nage: 30\nemail: john.doe@example.com\naddress:\n  street: 123 Main St\n  city: New York\n  state: NY\n  zip: \"10001\"\ninterests:\n  - programming\n  - reading\n  - hiking\n"

(def kw-yaml-data (yaml/parse-string yaml-file))
kw-yaml-data
;; => {:name "John Doe",
;;     :age 30,
;;     :email "john.doe@example.com",
;;     :address {:street "123 Main St", :city "New York", :state "NY", :zip "10001"},
;;     :interests ("programming" "reading" "hiking")}

(class kw-yaml-data)
;; => flatland.ordered.map.OrderedMap
(type kw-yaml-data)
;; => flatland.ordered.map.OrderedMap

(select-keys kw-yaml-data [:name :age :email :interests])
;; => {:name "John Doe", :age 30, :email "john.doe@example.com", :interests ("programming" "reading" "hiking")}
(get-in kw-yaml-data [:address :street])
;; => "123 Main St"

(def non-kw-yaml-data (yaml/parse-string yaml-file :keywords false))
non-kw-yaml-data
;; => {"name" "John Doe",
;;     "age" 30,
;;     "email" "john.doe@example.com",
;;     "address" {"street" "123 Main St", "city" "New York", "state" "NY", "zip" "10001"},
;;     "interests" ("programming" "reading" "hiking")}

(class non-kw-yaml-data)
;; => clojure.lang.PersistentArrayMap
(type non-kw-yaml-data)
;; => clojure.lang.PersistentArrayMap

(select-keys non-kw-yaml-data ["name" "age" "email" "interests"])
;; => {"name" "John Doe", "age" 30, "email" "john.doe@example.com", "interests" ("programming" "reading" "hiking")}
(get-in non-kw-yaml-data ["address" "street"])
;; => "123 Main St"

;; Writing YAML Files
(spit "data_set/example_write_kw.yaml" (yaml/generate-string kw-yaml-data))
(slurp "data_set/example_write_kw.yaml")
;; => "name: John Doe\nage: 30\nemail: john.doe@example.com\naddress: {street: 123 Main St, city: New York, state: NY, zip: '10001'}\ninterests: [programming, reading, hiking]\n"
;; Note: the list of interests is rendered in different style than the original file, but the data is the same

;; the written file's parsed yaml data is the same as the original kw file's parsed yaml data
(= (yaml/parse-string (slurp "data_set/example_write_kw.yaml")) kw-yaml-data)
;; => true

(spit "data_set/example_write_non_kw.yaml" (yaml/generate-string non-kw-yaml-data))
(slurp "data_set/example_write_non_kw.yaml")
;; => "name: John Doe\nage: 30\nemail: john.doe@example.com\naddress: {street: 123 Main St, city: New York, state: NY, zip: '10001'}\ninterests: [programming, reading, hiking]\n"
;; Note: the list of interests is rendered in different style than the original file, but the data is the same

;; the written file's parsed yaml data is the same as the original non-kw file's parsed yaml data
(= (yaml/parse-string (slurp "data_set/example_write_kw.yaml") :keywords false) non-kw-yaml-data)
;; => true

;; the written files are the same for non-keyword and keyword yaml data
(= (slurp "data_set/example_write_non_kw.yaml")
   (slurp "data_set/example_write_kw.yaml"))
;; => true

;; pretty printing when writing yaml files
(spit "data_set/example_write_pretty.yaml" (yaml/generate-string kw-yaml-data :dumper-options {:flow-style :block
                                                                                               :indicator-indent 2
                                                                                               :indent 6}))