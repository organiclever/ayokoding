(ns labs.concurrency.c-delay.core)

;; ---
;; Delay - I may not need to calculate this
;; ---

;; make a delay that does some calculation
(defn- long-calculation [arg]
  (println "Starting long calculation")
  (Thread/sleep 2000)
  arg)
(def the-answer (delay (* 100 (long-calculation 45))))

;; that long calculation has not been done at this point

(when true
  ;; the thread will block until the answer is calculated
  (println (str "the answer is: " (deref the-answer)))
  (deref the-answer))
;; => 4500

;; if you don't need the answer, it was never run

;; ------

;; delays also useful for a shared resource between threads

;; https://danlebrero.com/2017/06/12/delay-clojure-forgotten-concurrency-primitive/

;; make a delay that initializes a shared resource
;; if we don't put it in a Delay, the resource will be initialized during compilation

(defn- initialize-shared-resource [arg]
  (println "Starting long calculation")
  (Thread/sleep 2000)
  arg)
(def resource (delay (initialize-shared-resource 10)))

;; start 100 threads that use the resource
(defn -main []
  (dotimes [x 100]
    (doto (Thread. (fn []
                     (let [resource @resource]
                       ;; use the resource here ...
                       (println x resource))))
      .start)))

(-main)