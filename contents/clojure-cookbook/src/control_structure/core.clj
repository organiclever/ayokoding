(ns control-structure.core)

(defn demo-if [x]
  (if (> x 0)
    (str "x is positive")
    (str "x is non-positive")))
(demo-if -1)
;; => "x is non-positive"
(demo-if 0)
;; => "x is non-positive"
(demo-if 1)
;; => "x is positive"

(defn demo-if-let [m]
  (if-let [val (m :key)]
    (str "Value found:" val)
    (str "No value found")))
(demo-if-let {:key "A value"})
;; => "Value found:A value"
(demo-if-let {})
;; => "No value found"

(defn demo-when [x]
  (when (= x 0)
    (str "x is zero")))
(demo-when 0)
;; => "x is zero"
(demo-when 1)
;; => nil

(defn demo-when-let [m]
  (when-let [val (m :key)]
    (str "Value found:" val)))
(demo-when-let {:key "Another value"})
;; => "Value found:Another value"
(demo-when-let {})
;; => nil

(defn demo-cond [x]
  (cond
    (< x 0) (str "x is negative")
    (= x 0) (str "x is zero")
    :else   (str "x is positive")))
(demo-cond -1)
;; => "x is negative"
(demo-cond 0)
;; => "x is zero"
(demo-cond 1)
;; => "x is positive"

(defn demo-case [x]
  (case x
    0 (str "x is zero")
    1 (str "x is one")
    (str "x is neither zero nor one")))
(demo-case 0)
;; => "x is zero"
(demo-case 1)
;; => "x is one"
(demo-case 2)
;; => "x is neither zero nor one"

(defn demo-for [x]
  (for [i (range x)]
    (str "i:" i)))
(demo-for 3)
;; => ("i:0" "i:1" "i:2")

(defn demo-loop [x]
  (loop [i 0]
    (when (< i x)
      (println "i:" i)
      (recur (inc i)))))
(demo-loop 3)
;; => nil
