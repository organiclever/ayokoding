(ns files-general.core
  (:require [clojure.java.shell :refer [sh]]
            [clojure.java.io :as io]))

;; Whole file

(def input-file "data_set/file_example_input.txt")
(def output-file "data_set/file_example_output.txt")

(slurp input-file)
;; => "Hi there!\nHello world!\nHola!\nHalo!"

(spit output-file "Hello, world!")
;; => nil
(slurp output-file)
;; => "Hello, world!"

(spit output-file "\nHi there!" :append true)
;; => nil
(slurp output-file)
;; => "Hello, world!\nHi there!"

;; Line by line

(with-open [reader (io/reader input-file)]
  (doall (mapv str (line-seq reader))))
;; => ["Hi there!" "Hello world!" "Hola!" "Halo!"]

(with-open [writer (io/writer output-file)]
  (doseq [line ["Hi there!" "Hello world!" "Hola!" "Halo!"]]
    (.write writer (str line "\n"))))
;; => nil
(slurp output-file)
;; => "Hi there!\nHello world!\nHola!\nHalo!\n"

;; File Properties

(.exists (io/file input-file))
;; => true

(.setReadable (io/file input-file) false)
;; => true
(.canRead (io/file input-file))
;; => false
(.setReadable (io/file input-file) true)
;; => true
(.canRead (io/file input-file))
;; => true

(.setWritable (io/file input-file) false)
;; => true
(.canWrite (io/file input-file))
;; => false
(.setWritable (io/file input-file) true)
;; => true
(.canWrite (io/file input-file))
;; => true

(sh "chmod" "+x" input-file)
;; => {:exit 0, :out "", :err ""}
(.canExecute (io/file input-file))
;; => true
(sh "chmod" "-x" input-file)
;; => {:exit 0, :out "", :err ""}
(.canExecute (io/file input-file))
;; => false

(sh "chmod" "0644" input-file)
;; => {:exit 0, :out "", :err ""}
(sh "ls" "-l" input-file)
;; => {:exit 0, :out "-rw-r--r--@ 1 abcd  programmer  34 Jun 27 06:53 data_set/file_example_input.txt\n", :err ""}
