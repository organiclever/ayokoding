(ns hello
  (:require [hello-time :as ht]))

(defn run [_opts]
  (println "Hello world, the time is" (ht/time-str (ht/now))))

(def ab 123)
