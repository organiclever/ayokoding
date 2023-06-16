(ns interop-java-in-clojure.core)

;; -----
;; Interop basics
;; -----

;; Call instance method

(import 'java.util.ArrayList)

(def my-list (ArrayList.))
my-list
;; => []
(.add my-list "Hello")
;; => true
my-list
;; => ["Hello"]
(.add my-list "World")
;; => true
my-list
;; => ["Hello" "World"]
(.size my-list)
;; => 2

;; Call fields

(import 'java.awt.Dimension)

(def dim (Dimension. 10 20))
dim
;; => #object[java.awt.Dimension 0x48d8fc0 "java.awt.Dimension[width=10,height=20]"]
(.width dim)
;; => 10
(.height dim)
;; => 20

;; Call static method

(import 'java.util.UUID)
(UUID/randomUUID)
;; => #uuid "467c1c23-5a96-4e09-bcbe-497abcb6d73f"