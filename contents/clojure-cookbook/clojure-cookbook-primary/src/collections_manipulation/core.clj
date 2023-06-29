(ns collections-manipulation.core)

;; Map

(map (fn [x] (+ x 1)) '(1 2 3 4 5))
;; => (2 3 4 5 6)
(map #(+ % 1) [1 2 3 4 5])
;; => (2 3 4 5 6)
(map inc #{1 2 3 4 5})
;; => (2 5 4 3 6)
(map (fn [x] (val x)) {:a 1 :b 2 :c 3 :d 4 :e 5})
;; => (1 2 3 4 5)

;; Filter

(filter (fn [x] (even? x)) '(1 2 3 4 5))
;; => (2 4)
(filter #(even? %) [1 2 3 4 5])
;; => (2 4)
(filter even? #{1 2 3 4 5})
;; => (4 2)
(filter (fn [x] (even? (val x))) {:a 1 :b 2 :c 3})
;; => ([:b 2])

;; Reduce

(reduce (fn [acc x] (str acc x)) "" ["a" "b" "c"])
;; => "abc"
(reduce #(str %1 %2) "" ["a" "b" "c"])
;; => "abc"
(reduce str "" #{"a" "b" "c" "d"})
;; => "dabc"
(reduce (fn [x y] (str x (val y))) "" {:a "a" :b "b" :c "c"})
;; => "abc"

;; Side effects

(run! println [1 2 3 4 5])
;; => nil
(run! println '(1 2 3 4 5))
;; => nil
(run! println #{1 2 3 4 5})
;; => nil
(run! #(println (val %)) {:a 1 :b 2 :c 3 :d 4 :e 5})
;; => nil

(doseq [x [1 2 3 4 5]]
  (println x))
;; => nil
(doseq [x '(1 2 3 4 5)]
  (println x))
;; => nil
(doseq [x #{1 2 3 4 5}]
  (println x))
;; => nil
(doseq [x {:a 1 :b 2 :c 3 :d 4 :e 5}]
  (println (val x)))
;; => nil

;; Immutability

(def a-vector [1 2 3 4 5])
(def a-list '(1 2 3 4 5))
(def a-set #{1 2 3 4 5})
(def a-map {:a 1 :b 2 :c 3 :d 4 :e 5})

(map inc a-vector)
;; => (2 3 4 5 6)
a-vector
;; => [1 2 3 4 5]

(filter even? a-list)
;; => (2 4)
a-list
;; => (1 2 3 4 5)

a-set
;; => #{1 4 3 2 5}
(reduce str "" a-set)
;; => "14325"
a-set
;; => #{1 4 3 2 5}

(run! #(println (val %)) a-map)
;; => nil
a-map
;; => {:a 1, :b 2, :c 3, :d 4, :e 5}
(doseq [x a-map]
  (println (val x)))
;; => nil
a-map
;; => {:a 1, :b 2, :c 3, :d 4, :e 5}
