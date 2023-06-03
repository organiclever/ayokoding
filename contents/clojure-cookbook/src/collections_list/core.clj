(ns collections-list.core)

;; ---
;; List creation
;; ---

'(1 2 3 4 5)
;; => (1 2 3 4 5)

(list 1 2 3 4 5)
;; => (1 2 3 4 5)

(= '(1 2 3 4 5) (list 1 2 3 4 5))
;; => true

'(1 "b" 3 "d")
;; => (1 "b" 3 "d")

(cons 1 '(2 3 4 5))
;; => (1 2 3 4 5)

(conj '(2 3 4 5) 1)
;; => (1 2 3 4 5)

;; ---
;; Accessing elements
;; ---

(first '(1 2 3 4 5))
;; => 1
(first '())
;; => nil

(second '(1 2 3 4 5))
;; => 2
(second '())
;; => nil

(rest '(1 2 3 4 5))
;; => (2 3 4 5)
(rest '(1))
;; => ()
(rest '())
;; => ()

(nth '(1 2 3 4 5) 0)
;; => 1
(nth '() 0)
;; => Execution error (IndexOutOfBoundsException) at collections-list.core/eval8980 (REPL:48).
;;    null

(last '(1 2 3 4 5))
;; => 5
(last '(1))
;; => nil

;; ---
;; Manipulating lists
;; ---

(def list-a '(1 2 3 4 5))
(def list-b '(6 7 8 9 10))

(concat list-a list-b)
;; => (1 2 3 4 5 6 7 8 9 10)
(concat list-a)
;; => (1 2 3 4 5)
(concat list-a ())
;; => (1 2 3 4 5)

(flatten '((1 2 3) (4 5 6 (7 8 9)) (10 11 12) 13))
;; => (1 2 3 4 5 6 7 8 9 10 11 12 13)

(map (fn [item]  (+ item 1)) list-a)
;; => (2 3 4 5 6)
(map inc list-a)
;; => (2 3 4 5 6)
list-a
;; => (1 2 3 4 5)

(filter (fn [item] ((fn [item] (even? item)) item)) list-a)
;; => (2 4)
(filter (fn [item] (even? item)) list-a)
;; => (2 4)

(reduce (fn [acc item] (+ acc item)) 0 list-a)
;; => 15
(reduce + 0 list-a)
;; => 15

;; ---
;; Predicates
;; ---
(empty? '())
;; => true
(empty? '(1 2))
;; => false

(seq '())
;; => nil
(seq '(1 2 3 4 5))
;; => (1 2 3 4 5)

(.contains '(1 2 3 4 5) 3)
;; => true
(.contains '(1 2 3 4 5) 6)
;; => false

(every? (fn [item] (> item 3)) '(3 4 5 6))
;; => false
(every? (fn [item] (> item 1)) '(3 4 5 6))
;; => true
(every? #(even? %) '(2 4 6 8))
;; => true
(every? #(odd? %) '(2 4 6 8))
;; => false

(some (fn [item] (> item 3)) '(3 4 5 6))
;; => true
(some (fn [item] (> item 10)) '(3 4 5 6))
;; => nil

;; ---
;; Utily functions
;; ---

(count '(1 2 3 4 5))
;; => 5
(count '())
;; => 0

(reverse '(1 2 3 4 5))
;; => (5 4 3 2 1)
(reverse '())
;; => ()

(sort '(5 3 1 2 4))
;; => (1 2 3 4 5)
(sort '())
;; => ()

(distinct '(1 2 3 4 5 1 2 3 4 5))
;; => (1 2 3 4 5)
(distinct '(1 2 3 4 5))
;; => (1 2 3 4 5)
(distinct '())
;; => ()

(partition 2 '(1 2 3 4 5 6))
;; => ((1 2) (3 4) (5 6))
(partition 2 '(1 2 3 4 5))
;; => ((1 2) (3 4))
(partition 2 '())
;; => ()

(take 2 '(1 2 3 4 5))
;; => (1 2)
(take 3 '(1 2 3 4 5))
;; => (1 2 3)
(take 6 '(1 2 3 4 5))
;; => (1 2 3 4 5)
(take 6 '())
;; => ()

;; ---
;; Conversion to other collections
;; ---

(vec '(1 2 3 4 5))
;; => [1 2 3 4 5]

(set '(1 2 3 4 5))
;; => #{1 4 3 2 5}

;; convert clojure list to hash-map
(into {} '({:a 2} {:b 4} {:c 6}))
;; => {:a 2, :b 4, :c 6}
(into {} '([:a 2] [:b 4] [:c 6]))
;; => {:a 2, :b 4, :c 6}
(into {} '((:a 2) (:b 4) (:c 6)))
;; => Execution error (ClassCastException) at collections-list.core/eval14028 (REPL:180).
;;    class clojure.lang.Keyword cannot be cast to class java.util.Map$Entry (clojure.lang.Keyword is in unnamed module of loader 'app'; java.util.Map$Entry is in module java.base of loader 'bootstrap')

(seq '(1 2 3 4 5))
;; => (1 2 3 4 5)

(str '(1 2 3 4 5))
;; => "(1 2 3 4 5)"
