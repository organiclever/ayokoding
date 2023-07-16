(ns hello-world.core
  (:require react-dom))

(defn average [x y]
  (/ (+ x y) 2))

(def state (atom {:count 0}))

(defn render []
  (.render js/ReactDOM
           (.createElement js/React "h2" nil (str "Hello??? React!!!! \n count: " (:count @state)))
           (.getElementById js/document "app")))

(defn print-change [_ _ _ new-value]
  (println (str "The new value is: " new-value))
  (render)
  (js/console.log "The new value is:" new-value))

(add-watch state :main-state print-change)

(swap! state update :count inc)

(js/console.log (:count @state))

(comment
  (swap! state (fn [_]
                 {:count 0})))