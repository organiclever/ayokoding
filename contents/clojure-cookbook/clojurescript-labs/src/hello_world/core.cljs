(ns hello-world.core
  (:require react-dom))

(defn average [x y]
  (/ (+ x y) 2))

(.render js/ReactDOM
         (.createElement js/React "h2" nil (str "Hello??? React!" (average 20 13)))
         (.getElementById js/document "app"))
