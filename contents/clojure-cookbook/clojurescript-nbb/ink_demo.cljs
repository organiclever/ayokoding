(ns ink-demo
  (:require ["ink" :refer [render Text]]
            [reagent.core :as r]))

(defonce state (r/atom 0))

(doseq [n (range 1 1000)]
  (js/setTimeout #(swap! state inc) (* n 500)))

(defn hello []
  [:> Text {:color "green"} "Hello, world! " @state])

(render (r/as-element [hello]))