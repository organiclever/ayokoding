(ns collections-maps.core)

;; ---
;; Maps creation
;; ---

{:a 1, :b 2, :c 3, :d 4, :e 5}
;; => {:a 1, :b 2, :c 3, :d 4, :e 5}
{:a 1, :b "b", :c 3, :d "d"}
;; => {:a 1, :b "b", :c 3, :d "d"}
{:a 1, "b" "c", 2 "b", :d "d"}
;; => {:a 1, "b" "c", 2 "b", :d "d"}

(class {:a 1 :b 2 :c 3 :d 4 :e 5})
;; => clojure.lang.PersistentArrayMap

(hash-map :a 1 :b 2 :c 3 :d 4 :e 5)
;; => {:e 5, :c 3, :b 2, :d 4, :a 1}

(into {} [[:a 1] [:b 2] [:c 3] [:d 4] [:e 5]])
;; => {:a 1, :b 2, :c 3, :d 4, :e 5}

(= {:a 1, :b 2, :c 3, :d 4, :e 5} (hash-map :a 1 :b 2 :c 3 :d 4 :e 5))
;; => true

(assoc {:a 1 :b 2 :c 3 :d 4} :e 5)
;; => {:a 1, :b 2, :c 3, :d 4, :e 5}
(assoc {:a 1 :b 2 :c 3 :d 4} :a 5)
;; => {:a 5, :b 2, :c 3, :d 4}
(assoc {} :a 1 :b 2 :c 3 :d 4 :e 5)
;; => {:a 1, :b 2, :c 3, :d 4, :e 5}

(dissoc {:a 1 :b 2 :c 3 :d 4 :e 5} :a)
;; => {:b 2, :c 3, :d 4, :e 5}
(dissoc {:a 1 :b 2 :c 3 :d 4 :e 5} :f)
;; => {:a 1, :b 2, :c 3, :d 4, :e 5}

(conj {:a 1, :b 2, :c 3, :d 4} [:e 5])
;; => {:a 1, :b 2, :c 3, :d 4, :e 5}

;; ---
;; Accessing elements
;; ---

(:a {:a 1, :b 2, :c 3, :d 4, :e 5})
;; => 1
({:a 1, :b 2, :c 3, :d 4, :e 5} :a)
;; => 1
(get {:a 1, :b 2, :c 3, :d 4, :e 5} :a)
;; => 1
(get {} :a)
;; => nil
(get {:a 1, :b 2, :c 3, :d 4, :e 5} :f "Default Value")
;; => "Default Value"

(get-in {:person {:name "John" :age 30}} [:person])
;; => {:name "John", :age 30}
(get-in {:person {:name "John" :age 30}} [:person :name])
;; => "John"
(get-in {:person {:name "John" :age 30}} [:person :address])
;; => nil
(get-in {:person {:name "John" :age 30}} [:person :address] "Default Value")
;; => "Default Value"

(keys {:a 1, :b 2, :c 3, :d 4, :e 5})
;; => (:a :b :c :d :e)
(vals {:a 1, :b 2, :c 3, :d 4, :e 5})

;; ---
;; Manipulating maps
;; ---

(def map-a {:a 1, :b 2, :c 3, :d 4, :e 5})
(def map-b {:f 6, :g 7, :h 8, :i 9, :j 10})

(merge map-a map-b)
;; => {:e 5, :g 7, :c 3, :j 10, :h 8, :b 2, :d 4, :f 6, :i 9, :a 1}

(merge map-a)
;; => {:a 1, :b 2, :c 3, :d 4, :e 5}

(merge map-a {})
;; => {:a 1, :b 2, :c 3, :d 4, :e 5}

;; ---
;; Predicates
;; ---

(empty? {})
;; => true
(empty? {:a 1, :b 2})
;; => false

(seq {})
;; => nil
(seq {:a 1, :b 2, :c 3, :d 4, :e 5})
;; => ([:a 1] [:b 2] [:c 3] [:d 4] [:e 5])

(contains? {:a 1, :b 2, :c 3, :d 4, :e 5} :a)
;; => true
(contains? {:a 1, :b 2, :c 3, :d 4, :e 5} :f)
;; => false

(some #(= (second %) 3) {:a 1, :b 2, :c 3, :d 4, :e 5}) ;; alternative for checking if a map contains a value
;; => true
(some #(= (second %) 6) {:a 1, :b 2, :c 3, :d 4, :e 5})
;; => nil

;; ---
;; Utility functions
;; ---

(count {:a 1, :b 2, :c 3, :d 4, :e 5})
;; => 5
(count {})
;; => 0

;; ---
;; Conversion to other collections
;; ---

(apply list {:a 1, :b 2, :c 3, :d 4, :e 5})
;; => ([:a 1] [:b 2] [:c 3] [:d 4] [:e 5])
(apply vector {:a 1, :b 2, :c 3, :d 4, :e 5})
;; => [[:a 1] [:b 2] [:c 3] [:d 4] [:e 5]]

(apply hash-map [:a 1 :b 2 :c 3 :d 4 :e 5])
;; => {:e 5, :c 3, :b 2, :d 4, :a 1}

(into {:a 1} [[:b 2] [:c 3] [:d 4] [:e 5]])
;; => {:a 1, :b 2, :c 3, :d 4, :e 5}

(seq {:a 1, :b 2, :c 3, :d 4, :e 5})
;; => ([:a 1] [:b 2] [:c 3] [:d 4] [:e 5])

(apply str {:a 1, :b 2, :c 3, :d 4, :e 5})
;; => "[:a 1][:b 2][:c 3][:d 4][:e 5]"
(str {:a 1, :b 2, :c 3, :d 4, :e 5})
;; => "{:a 1, :b 2, :c 3, :d 4, :e 5}"
