(ns collections-working-with.core)

;; map

(map (fn [x] (+ x 1)) '(1 2 3 4 5))
;; => (2 3 4 5 6)
(map #(+ % 1) [1 2 3 4 5])
;; => (2 3 4 5 6)
(map inc #{1 2 3 4 5})
;; => (2 5 4 3 6)
(map (fn [x] (val x)) {:a 1 :b 2 :c 3 :d 4 :e 5})
;; => (1 2 3 4 5)

;; filter

(filter (fn [x] (even? x)) '(1 2 3 4 5))
;; => (2 4)
(filter #(even? %) [1 2 3 4 5])
;; => (2 4)
(filter even? #{1 2 3 4 5})
;; => (4 2)
(filter (fn [x] (even? (val x))) {:a 1 :b 2 :c 3})
;; => ([:b 2])

;; reduce

(reduce (fn [acc x] (str acc x)) "" ["a" "b" "c"])
;; => "abc"
(reduce #(str %1 %2) "" ["a" "b" "c"])
;; => "abc"
(reduce str "" #{"a" "b" "c" "d"})
;; => "dabc"
(reduce (fn [x y] (str x (val y))) "" {:a "a" :b "b" :c "c"})
;; => "abc"

;; side effects

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
