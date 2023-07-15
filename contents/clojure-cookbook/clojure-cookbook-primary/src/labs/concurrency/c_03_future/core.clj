(ns labs.concurrency.c-03-future.core)
(def the-answer (future
                   ;; do a lot of work in a new thread
                   ;; ...
                   ;; then deliver the answer
                   ;; the value of the last expression is delivered
                  (Thread/sleep 3000)
                  42))

;; in the main thread, do some work
;; ...
;; then get the answer (which blocks until the answer is done)
(println (deref the-answer))

;; One thing that trips up people new to Futures is that they swallow exceptions. If the code you run in the Future throws an exception, you won't hear about it until you deref it. When you deref it, the exception will be thrown again in the current thread.

;; the Exception gets thrown but stored in the Future
(def f (future
         (Thread/sleep 3000)
         (throw (Exception. "Hello from the future!"))))

(realized? f)
;; => false

(try
  ;; deref the Future
  (deref f)
  (catch Exception e
    (str "Caught exception from future: " (.getMessage e))))
;; => "Caught exception from future: java.lang.Exception: Hello from the future!"

(realized? f)
;; => true

(def f2 (future
          (Thread/sleep 5000)
          42))
(deref f2 3000 :cheeseburger)
;; => :cheeseburger
;; 3000 is the time limit
;; deref accept: [ref timeout-ms timeout-val]
