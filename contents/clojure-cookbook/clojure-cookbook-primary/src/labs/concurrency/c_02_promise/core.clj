(ns labs.concurrency.c-02-promise.core)

;; make a Promise
(def the-answer (promise))

;; start working on the promise in a new thread
(doto (Thread. (fn []
                 ;;; do a lot of work
                 ;;; ...
                 ;;; then deliver on your promise
                 (Thread/sleep 3000)
                 (deliver the-answer 42)))
  .start)

;; in the original thread, do your own work
;; ...
;; then get the answer
;; (this will block if it's not there)
(str "The answer: " (deref the-answer))
;; => "The answer: 42"

;; Promises are a simple way to communicate between threads. One Thread calculates the answer. The other waits for it. (We'll look at how to create Threads later.)
;; You can create as many Promises as you want. But each one can only get one answer. Once the answer is delivered, it can't be delivered again.

