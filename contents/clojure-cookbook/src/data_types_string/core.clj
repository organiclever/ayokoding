(ns data-types-string.core
  (:require [clojure.string :as str]))

;; ---
;; Basic String Functions
;; ---

"abcdef123456"
;; => "abcdef123456"

(class "abcdef123456")
;; => java.lang.String

(string? "abc")
;; => true

(str "abc" "def")
;; => "abcdef"
(str "abc" "def" 123 "456")
;; => "abcdef123456"

(subs "abcdef123456" 0 3)
;; => "abc"
(subs "abcdef123456" 3 7)
;; => "def1"
(subs "abcdef123456" 0)
;; => "abcdef123456"
(try (subs "abcdef123456" 13)
     (catch Exception _e "StringIndexOutOfBoundsException"))
;; => "StringIndexOutOfBoundsException"
(try #_{:clj-kondo/ignore [:type-mismatch]}
 (subs "abcdef123456" -1 3)
     (catch Exception _e "StringIndexOutOfBoundsException"))

(.contains "abcdef123456" "def")

(count "abcdef123456")
;; => 12

(format "Hello %s" "World")
;; => "Hello World"

;; ---
;; clojure.string functions
;; ---

(str/join ["abc" "def" "123456"])
;; => "abcdef123456"
(str/split "abcdef123456" #"def")
;; => ["abc" "123456"]
(str/replace "Hello World" "World" "Clojure")
;; => "Hello Clojure"

(str/trim "  abc  ")
;; => "abc"
(str/triml "  abc  ")
;; => "abc  "
(str/trimr "  abc  ")
;; => "  abc"

(str/upper-case "hello world")
;; => "HELLO WORLD"
(str/lower-case "HELLO WORLD")
;; => "hello world"
(str/capitalize "hello world")
;; => "Hello world"

(str/starts-with? "abcdef123456" "abc")
;; => true
(str/ends-with? "abcdef123456" "456")
;; => true

(str/blank? "")
;; => true
(str/blank? nil)
;; => true
(str/blank? "abcdef123456")
;; => false
