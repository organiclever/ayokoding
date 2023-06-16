(ns interop-java-in-clojure.core
  (:require
   [clojure.reflect :as reflect]))

;; ---
;; Interop basics
;; ---

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

;; ---
;; Java data types
;; ---

(int 42)
;; => 42
(double 3.14)
;; => 3.14
(+ (int 42) (double 3.14))
;; => 45.14

(def java-array (to-array [1 2 3]))
(class java-array)
;; => [Ljava.lang.Object;
(seq java-array)
;; => (1 2 3)

(def java-string (String. "Hello"))
;; => #'interop-java-in-clojure.core/java-string
(class java-string)
;; => java.lang.String
(.length java-string)
;; => 5
(str java-string " World")
;; => "Hello World"

;; ---
;; Java exception handling
;; ---

(try (/ (int 42) (int 0))
     (catch ArithmeticException e
       (str "Exception name: " e " >>> Message: "  (.getMessage e))))
;; => "Exception name: java.lang.ArithmeticException: Divide by zero >>> Message: Divide by zero"

;; ---
;; Java external libraries
;; ---

(import 'com.google.common.base.Strings)
(Strings/repeat "Hello" 3)
;; => "HelloHelloHello"
(Strings/titleCase "hello world")

(import 'com.google.common.base.Preconditions)

(defn divide [numerator denominator]
  (Preconditions/checkArgument (not= denominator 0) "Denominator must be non-zero")
  (/ numerator denominator))

(try
  (divide 42 0)
  (catch IllegalArgumentException e
    (str "Exception name: " e " >>> Message: "  (.getMessage e))))
;; => "Exception name: java.lang.IllegalArgumentException: Denominator must be non-zero >>> Message: Denominator must be non-zero"

(keys (reflect/reflect Strings))
;; => (:bases :flags :members)

;; ---
;; Local Java file
;; ---

;; Assume that Calculator.class is in the correct folder/package
;; and has a superAdd method that adds two numbers
;; See the repository

(import 'interop_java_in_clojure.Calculator)

(def calculator (Calculator.))
;; => #'interop-java-in-clojure.core/calculator
(class calculator)
;; => interop_java_in_clojure.Calculator
(.superAdd calculator 1 2)
;; => 3
