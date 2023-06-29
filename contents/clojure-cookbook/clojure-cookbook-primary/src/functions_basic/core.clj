(ns functions-basic.core)

(defn print-hello-world []
  (println "Hello world"))
(print-hello-world)
;; => nil

(defn get-hello [who]
  (str "Hello " who "!"))
(get-hello "world")
;; => "Hello world!"

(defn add [x y]
  (+ x y))
(add 1 2)
;; => 3

(defn print-hello [who]
  (println (get-hello who)))
(print-hello "world")
;; => nil
