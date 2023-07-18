(ns hello-world.core)

(def state (atom {:count 0}))

(defn restart-app []
  (swap! state (fn [x] x)))

(defn render [app-state]
  (set! (.-innerHTML (.getElementById js/document "app"))
        (str "Hello! \n Current count: " (:count app-state))))

(defn handle-state-change [_ _ _ new-state]
  (render new-state))

(add-watch state :main-state handle-state-change)

(swap! state update :count inc)

(comment
  (swap! state (fn [{:keys [count]}]
                 {:count count}))
  (restart-app)
  (js/alert "hello"))