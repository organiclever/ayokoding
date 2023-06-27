(ns files-general.core
  (:require [clojure.java.shell :refer [sh]]
            [clojure.java.io :as io]))

;; ---
;; File Manipulation
;; ---

;; Whole file

(def file-input "data_set/file_example_input.txt")
(def file-output "data_set/file_example_output.txt")

(slurp file-input)
;; => "Hi there!\nHello world!\nHola!\nHalo!"

(spit file-output "Hello, world!")
;; => nil
(slurp file-output)
;; => "Hello, world!"

(spit file-output "\nHi there!" :append true)
;; => nil
(slurp file-output)
;; => "Hello, world!\nHi there!"

;; Line by line

(with-open [reader (io/reader file-input)]
  (doall (mapv str (line-seq reader))))
;; => ["Hi there!" "Hello world!" "Hola!" "Halo!"]

(with-open [writer (io/writer file-output)]
  (doseq [line ["Hi there!" "Hello world!" "Hola!" "Halo!"]]
    (.write writer (str line "\n"))))
;; => nil
(slurp file-output)
;; => "Hi there!\nHello world!\nHola!\nHalo!\n"

;; ---
;; File Properties
;; ---

(.exists (io/file file-input))
;; => true

(.setReadable (io/file file-input) false)
;; => true
(.canRead (io/file file-input))
;; => false
(.setReadable (io/file file-input) true)
;; => true
(.canRead (io/file file-input))
;; => true

(.setWritable (io/file file-input) false)
;; => true
(.canWrite (io/file file-input))
;; => false
(.setWritable (io/file file-input) true)
;; => true
(.canWrite (io/file file-input))
;; => true

(sh "chmod" "+x" file-input)
;; => {:exit 0, :out "", :err ""}
(.canExecute (io/file file-input))
;; => true
(sh "chmod" "-x" file-input)
;; => {:exit 0, :out "", :err ""}
(.canExecute (io/file file-input))
;; => false

(sh "chmod" "0644" file-input)
;; => {:exit 0, :out "", :err ""}
(sh "ls" "-l" file-input)
;; => {:exit 0, :out "-rw-r--r--@ 1 abcd  programmer  34 Jun 27 06:53 data_set/file_example_input.txt\n", :err ""}
