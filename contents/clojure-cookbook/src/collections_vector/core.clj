(ns collections-vector.core)

;; ---
;; Vector creation
;; ---

[1 2 3 4 5]
;; => [1 2 3 4 5]

(vector 1 2 3 4 5)
;; => [1 2 3 4 5]

(vec '(1 2 3 4 5))
;; => [1 2 3 4 5]

(class [1 2 3 4 5])
;; => clojure.lang.PersistentVector

(= [1 2 3 4 5] (vector 1 2 3 4 5))
;; => true

[1 "b" 3 "d"]
;; => [1 "b" 3 "d"]

(cons 1 [2 3 4 5])
;; => (1 2 3 4 5)

(conj [1 2 3 4] 5)
;; => [1 2 3 4 5]

;; ---
;; Accessing elements
;; ---

(first [1 2 3 4 5])
;; => 1
(first [])
;; => nil

(second [1 2 3 4 5])
;; => 2
(second [])
;; => nil

(subvec [1 2 3 4 5] 1 3)
;; => [2 3]
(subvec [1 2 3 4 5] 1)
;; => [2 3 4 5]
(subvec [1] 1)
;; => []
(try
  (subvec [1] 2)
  (catch Exception _e "IndexOutOfBoundsException"))
;; => "IndexOutOfBoundsException"

(nth [1 2 3 4 5] 0)
;; => 1
(try
  (nth [] 0)
  (catch Exception _e "IndexOutOfBoundsException"))
;; => "IndexOutOfBoundsException"

(last [1 2 3 4 5])
;; => 5
(last [1])
;; => 1
(last [])
;; => nil

;; ---
;; Manipulating vectors
;; ---

(def vector-a [1 2 3 4 5])
(def vector-b [6 7 8 9 10])

(concat vector-a vector-b)
;; => (1 2 3 4 5 6 7 8 9 10)
(concat vector-a)
;; => (1 2 3 4 5)
(concat vector-a [])
;; => (1 2 3 4 5)

(flatten [[1 2 3] [4 5 6 [7 8 9]] [10 11 12] 13])
;; => (1 2 3 4 5 6 7 8 9 10 11 12 13)

(map (fn [item]  (+ item 1)) vector-a)
;; => (2 3 4 5 6)
(map inc vector-a)
;; => (2 3 4 5 6)
vector-a
;; => [1 2 3 4 5]

(filter (fn [item] ((fn [item] (even? item)) item)) vector-a)
;; => (2 4)
(filter (fn [item] (even? item)) vector-a)
;; => (2 4)

(reduce (fn [acc item] (+ acc item)) 0 vector-a)
;; => 15
(reduce + 0 vector-a)
;; => 15

;; ---
;; Predicates
;; ---

(empty? [])
;; => true
(empty? [1 2])
;; => false

(seq [])
;; => nil
(seq [1 2 3 4 5])
;; => (1 2 3 4 5)

(contains? [1 2 3 4 5] 3)
;; => true (contains? operates on index for vectors)
(contains? [1 2 3 4 5] 6)
;; => false (contains? operates on index for vectors)

(some #(= % 3) [1 2 3 4 5]) ;; alternative for checking if a vector contains a value
;; => true
(some #(= % 6) [1 2 3 4 5])
;; => nil

(every? (fn [item] (> item 3)) [3 4 5 6])
;; => false
(every? (fn [item] (> item 1)) [3 4 5 6])
;; => true
(every? #(even? %) [2 4 6 8])
;; => true
(every? #(odd? %) [2 4 6 8])
;; => false

(some (fn [item] (> item 3)) [3 4 5 6])
;; => true
(some (fn [item] (> item 10)) [3 4 5 6])
;; => nil

;; ---
;; Utily functions
;; ---

(count [1 2 3 4 5])
;; => 5
(count [])
;; => 0

(reverse [1 2 3 4 5])
;; => (5 4 3 2 1)
(reverse [])
;; => ()

(sort [5 3 1 2 4])
;; => (1 2 3 4 5)
(sort [])
;; => ()

(distinct [1 2 3 4 5 1 2 3 4 5])
;; => (1 2 3 4 5)
(distinct [1 2 3 4 5])
;; => (1 2 3 4 5)
(distinct [])
;; => ()

(partition 2 [1 2 3 4 5 6])
;; => ((1 2) (3 4) (5 6))
(partition 2 [1 2 3 4 5])
;; => ((1 2) (3 4))
(partition 2 [])
;; => ()

(take 2 [1 2 3 4 5])
;; => (1 2)
(take 3 [1 2 3 4 5])
;; => (1 2 3)
(take 6 [1 2 3 4 5])
;; => (1 2 3 4 5)
(take 6 [])
;; => ()

;; ---
;; Conversion to other collections
;; ---

(apply list [1 2 3 4 5])
;; => (1 2 3 4 5)
(set [1 2 3 4 5])
;; => #{1 2 3 4 5}
(seq [1 2 3 4 5])
;; => (1 2 3 4 5)

;; convert clojure vector to hash-map
(into {} [{:a 2} {:b 4} {:c 6}])
;; => {:a 2, :b 4, :c 6}
(into {} [[:a 2] [:b 4] [:c 6]])
;; => {:a 2, :b 4, :c 6}

(apply str [1 2 3 4 5])
;; => "12345"
(str [1 2 3 4 5])
;; => "[1 2 3 4 5]"