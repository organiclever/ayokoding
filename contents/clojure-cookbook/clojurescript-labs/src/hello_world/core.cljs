(ns hello-world.core
  (:require react-dom))

(defn average [x y]
  (/ (+ x y) 2))

(def state (atom {:count 0}))

(.render js/ReactDOM
         (.createElement js/React "h2" nil (str "Hello??? React!!!! " (average 20 (:count @state))))
         (.getElementById js/document "app"))

(swap! state update :count inc)

(js/console.log (:count @state))
