(ns labs.concurrency.core)

;; This module is a follow along of Eric Normand's Clojure concurrency
;; https://ericnormand.me/guide/clojure-concurrency

;; ---
;; I - Catalog of primitives
;; ---

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

;; ---
;; Promise - I'll check back here for the answer
;; ---

;; ---
;; Future - Please calculate this in another thread
;; ---

;; ---
;; A word about deref - What's in the box?
;; ---

;; ---
;; Atom - Keeping a single value consistent over time
;; ---

;; ---
;; Ref - Keep multiple values in a consistent relationship
;; ---

;; ---
;; Var - Redefine stuff as you program
;; ---

;; Agent - Queue up work to aggregate a value
;; ---

;; ---
;; Volatile - Lightweight mutable state
;; ---

;; ---
;; Lock - Keep others out while you're in
;; ---

;; ---
;; core.async - Workers with conveyor belts
;; ---

;; ---
;; Threads - Use your cores
;; ---

;; ---
;; Executor Service - Run lots of tasks in a thread pool
;; ---

;; ---
;; Manifold - Abstractions for data sources
;; ---

;; ---
;; pmap - Simple parallelism with one more letter
;; ---

;; ---
;; Reducers - Transformation pipelines in parallel
;; ---

;; ---
;; Fork/Join - Break your work into chunks, do the chunks on your cores, put them back together
;; ---

;; ---
;; II - Concurrency vs parallelism
;; ---

;; ---
;; III - JVM Thread model
;; ---

;; ---
;; IV - Immutable data structures
;; ---

;; ---
;; V - Pure Functions
;; ---

;; ---
;; VI - Independence
;; ---


