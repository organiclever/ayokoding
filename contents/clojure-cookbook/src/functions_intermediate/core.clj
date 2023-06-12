(ns functions-intermediate.core
  (:require [clojure.repl :refer [doc]]))

;; ---
;; Playing with Function
;; ---

;; Anonymous function

((fn [x] (* x 2)) 5)
;; => 10

(#(* % 2) 5)
;; => 10

;; Recursion

(defn factorial [n]
  (if (<= n 1)
    1
    (* n (factorial (dec n)))))
(factorial 5)
;; => 120

(defn fibonacci [n]
  (if (<= n 2)
    1
    (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))
(fibonacci 10)
;; => 55

;; Higher-order function

(defn apply-twice [f x]
  (f (f x)))
(defn square [x]
  (* x x))

(apply-twice square 2)
;; => 16

;; Function composition

(defn add-one [x]
  (+ x 1))
(defn triple [x]
  (* x 3))
(defn cubic [x]
  (* x x x))
((comp add-one) 3)
;; => 4
((comp add-one triple) 3)
;; => 10
((comp add-one triple cubic) 3)
;; => 82

;; juxt

(def combined-function (juxt add-one triple cubic))
(combined-function 5)
;; => [6 15 125]

;; Partial application and currying

((partial * 3) 4)
;; => 12

(defn add [x y]
  (+ x y))
(def curried-add (partial add 5))
(curried-add 3)
;; => 8

;; ---
;; Multiple arities and variadic functions
;; ---

(defn greeting
  ([] "Hello, World!")
  ([name] (str "Hello, " name "!"))
  ([name salutation] (str salutation ", " name "!")))
(greeting)
;; => "Hello, World!"
(greeting "John")
;; => "Hello, John!"
(greeting "John" "Hi")
;; => "Hi, John!"

(defn greeting-v2
  ([] (greeting-v2 "World" "Hello"))
  ([name] (greeting-v2 name "Hello"))
  ([name salutation] (str salutation ", " name "!")))
(greeting-v2)
;; => "Hello, World!"
(greeting-v2 "John")
;; => "Hello, John!"
(greeting-v2 "John" "Hi")
;; => "Hi, John!"

(defn sum [& nums]
  (apply + nums))
(sum 1 2 3 4)
;; => 10

;; ---
;; More on recursion and tail recursion
;; ---

(defn recursive-function [n]
  (if (zero? n)
    0
    (inc (recursive-function (dec n)))))
(recursive-function 100000)
;; => this will most-likely cause stack overflow.
;; You might need to restart your REPL

(defn recursive-function-with-recur [n]
  (loop [n n]
    (if (zero? n)
      0
      (recur (dec n)))))
(recursive-function-with-recur 10000)
;; => 0

(defn factorial-with-recur [n]
  (loop [acc 1 n n]
    (if (<= n 1)
      acc
      (recur (* acc n) (dec n)))))
(factorial-with-recur 5)
;; => 120

(defn fibonacci-with-recur [n]
  (loop [a 1 b 1 n n]
    (if (<= n 2)
      b
      (recur b (+ a b) (dec n)))))
(fibonacci-with-recur 10)
;; => 55

;; ---
;; Other utilities
;; ---

;; Documentation

(doc partial)
;; => print:
;; (doc partial)
;; -------------------------
;; clojure.core/partial
;; ([f] [f arg1] [f arg1 arg2] [f arg1 arg2 arg3] [f arg1 arg2 arg3 & more])
;; Takes a function f and fewer than the normal arguments to f, and
;; returns a fn that takes a variable number of additional args. When
;; called, the returned function calls f with args + additional args.

(defn triple-2
  "Calculates the triple of a number."
  [x]
  (* x 3))

(doc triple-2)
;; => print:
;; -------------------------
;; functions-intermediate.core/triple-2
;; ([x])
;; Calculates the tripe of a number.

;; Metadata

(defn ^{:author "John Doe" :date "2023-06-11"} my-function [x]
  (str "Executing my-function with argument: " x))

(:author (meta #'my-function))
;; => "John Doe"
(:date (meta #'my-function))
;; => "2023-06-11"
