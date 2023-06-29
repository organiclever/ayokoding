(ns collections-set.core
  (:require [clojure.set :as set]))

;; ---
;; Set creation
;; ---

#{1 2 3 4 5}
;; => #{1 4 3 2 5}
#{1 "b" 3 "d"}
;; => #{"d" 1 3 "b"}

(set [1 2 3 4 5 5 4 3 2 1])
;; => #{1 4 3 2 5}
(set '(1 2 3 4 5 5 4 3 2 1))
;; => #{1 4 3 2 5}

(class #{1 2 3 4 5})
;; => clojure.lang.PersistentHashSet

(= #{1 2 3 4 5} (set [1 2 3 4 5]))
;; => true

(conj #{1 2 3 4} 5)
;; => #{1 4 3 2 5}
(conj #{1 2 3 4} 4)
;; => #{1 4 3 2}
(disj #{1 2 3 4} 5)
;; => #{1 4 3 2}
(disj #{1 2 3 4} 4)
;; => #{1 3 2}

(cons 5 #{1 2 3 4})
;; => (5 1 4 3 2)

;; ---
;; Accessing elements
;; ---

(first #{1 2 3 4 5})
;; => 1 (order is not guaranteed in sets)
(first #{})
;; => nil
(second #{1 2 3 4 5})
;; => 4 (order is not guaranteed in sets)

(last #{1 2 3 4 5})
;; => 5 (order is not guaranteed in sets)
(last #{1})
;; => 1
(last #{})
;; => nil

;; ---
;; Manipulating sets
;; ---

(merge-with #{3 4 5} #{1 4 3 2 5})
;; => #{1 4 3 2 5}

(set/union #{1 4 3 2 5} #{7 6 9 10 8})
;; => #{7 1 4 6 3 2 9 5 10 8}
(set/intersection #{1 4 3 2 5} #{3 4 5 6 7})
;; => #{4 3 5}
(set/difference #{1 4 3 2 5} #{3 4 5})
;; => #{1 2}

;; ---
;; Predicates
;; ---

(empty? #{})
;; => true
(empty? #{1 2})
;; => false

(contains? #{1 2 3 4 5} 3)
;; => true
(contains? #{1 2 3 4 5} 6)
;; => false

(set/superset? #{1 4 3 2 5} #{3 4 5})
;; => true
(set/subset? #{3 4 5} #{1 4 3 2 5})
;; => true

;; ---
;; Utility functions
;; ---

(count #{1 2 3 4 5})
;; => 5
(count #{})
;; => 0

(reverse #{1 2 3 4 5})
;; => (5 4 3 2 1) (order is not guaranteed in sets)
(reverse #{})
;; => ()

(sort #{5 3 1 2 4})
;; => (1 2 3 4 5)
(sort #{})
;; => ()

;; ---
;; Conversion to other collections
;; ---

(apply list #{1 2 3 4 5})
;; => (1 2 3 4 5)
(apply vector #{1 2 3 4 5})
;; => [1 4 3 2 5]
(seq #{1 2 3 4 5})
;; => (1 2 3 4 5)
(apply str #{1 2 3 4 5})
;; => "14325"
(str #{1 2 3 4 5})
;; => "#{1 4 3 2 5}"