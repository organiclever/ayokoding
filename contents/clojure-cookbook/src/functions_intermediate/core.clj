(ns functions-intermediate.core)

;; Higher-order function
(defn apply-twice [f x]
  (f (f x)))
(defn square [x]
  (* x x))

(apply-twice square 2)
;; => 16

;; Anonymous function
(fn [x] (* x 2))
((fn [x] (* x 2)) 5)
;; => 10

;; Recursive function
(defn factorial [n]
  (if (<= n 1)
    1
    (* n (factorial (dec n)))))
(factorial 5)
;; => 120

;; Function composition
(defn add-one [x]
  (+ x 1))
(defn triple [x]
  (* x 3))
(defn cubic [x]
  (* x x x))
((comp add-one triple cubic) 3)
;; => 82

;; Partial application using the `partial` function
((partial * 3) 4)
;; => 12

(defn add [x y]
  (+ x y))
(def curried-add (partial add 5))
(curried-add 3)
;; => 8
