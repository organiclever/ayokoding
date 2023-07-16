(ns hello-world.react-core
  (:require react-dom))

(def state (atom {:count 0}))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn render []
  (.render js/ReactDOM
           (.createElement js/React "h2" nil (str "Hello??? React!!!! \n count: " (:count @state)))
           (.getElementById js/document "app")))

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