(ns labs.concurrency.c-05-ref.core)

(def total-donations (ref 0))

(def count-donations (ref 0))

;; start 9 people collecting money
(dotimes [_ 9]
  (doto (Thread. (fn []
                   ;; go collect $10
                   ;; ...
                   (dosync
                     ;; record $10
                    (alter total-donations + 10)
                     ;; record one donation
                    (alter count-donations inc))
                   ;; do it again
                   ))
    .start))

;; start one person tweeting the total
(doto (Thread. (fn []
                 ;; wait 100 seconds
                 (Thread/sleep 5000)
                 (println (str "We collected " @count-donations " donations, which sum up to $"  @total-donations " total!"))
                 (println (str "We collected $" @count-donations " total!"))))
  .start)
;; => We collected 9 donations, which sum up to $90 total!

;; start one person tweeting the average
(doto (Thread. (fn []
                 ;; wait 100 seconds
                 (Thread/sleep 6000)
                 (when (pos? @count-donations)
                   (println (str "Average donation: $" (double (dosync (/ @total-donations @count-donations))))))))
  .start)
;; => Average donation: $10.0
