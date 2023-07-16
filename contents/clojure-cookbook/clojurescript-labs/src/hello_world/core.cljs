(ns hello-world.core
  (:require react-dom))

(def state (atom {:count 0}))

(defn render []
  (set! (.-innerHTML (.getElementById js/document "app")) (str "Hello! \n count: " (:count @state))))

(defn handle-change [_ _ _ new-value]
  (println (str "The new value is: " new-value))
  (render)
  (js/console.log "The new value is:" new-value))

(add-watch state :main-state handle-change)

(swap! state update :count inc)

(js/console.log (:count @state))

(comment
  (swap! state (fn [_]
                 {:count 0})))