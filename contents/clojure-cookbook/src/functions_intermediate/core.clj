(ns functions-intermediate.core)

;; ---
;; Playing with Function
;; ---

;; Anonymous function
((fn [x] (* x 2)) 5)
;; => 10

(#(* % 2) 5)
;; => 10

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

;; Partial application and currying
((partial * 3) 4)
;; => 12

(defn add [x y]
  (+ x y))
(def curried-add (partial add 5))
(curried-add 3)
;; => 8

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
