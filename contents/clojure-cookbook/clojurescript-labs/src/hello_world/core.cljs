(ns hello-world.core)

(println "Hello world!")

;; ADDED
(defn average [a b]
  (/ (+ a b) 2.0))
(average 20 13)

(js/console.log average 20 13);