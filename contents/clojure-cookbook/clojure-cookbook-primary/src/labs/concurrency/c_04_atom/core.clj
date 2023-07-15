(ns labs.concurrency.c-04-atom.core)

;; create an Atom with initially no money
(def donation-count (atom 0))

;; start 9 people collecting money (9 threads)
(dotimes [_ 9]
  (doto (Thread. (fn []
                   ;; wait three seconds
                   (Thread/sleep 1000)
                   ;; go collect $1
                   (swap! donation-count inc)
                   ;; do it again
                   ))
    .start))

;; start one person tweeting
(doto (Thread. (fn []
                 ;; wait 100 seconds
                 (Thread/sleep 10000)
                 (println (str "We collected $" @donation-count " total!"))))
  .start)
;; => We collected $ 9 total!

@donation-count
;; => 9