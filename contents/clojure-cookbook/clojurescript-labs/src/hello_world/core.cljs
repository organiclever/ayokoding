(ns hello-world.core)

(def state (atom {:count 0}))

(defn render [app-state]
  (set! (.-innerHTML (.getElementById js/document "app")) (str "Hello! \n count: " (:count app-state))))

(defn handle-state-change [_ _ _ new-state]
  (render new-state))

(add-watch state :main-state handle-state-change)

(swap! state update :count inc)

(.getElementById js/document "app")
(set! (.-innerHTML (.getElementById js/document "app")) (str "Hello! \n count: "))

(comment
  (swap! state (fn [_]
                 {:count 0})))