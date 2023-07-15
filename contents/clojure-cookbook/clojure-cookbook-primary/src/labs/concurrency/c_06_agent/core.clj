(ns labs.concurrency.c-06-agent.core)

(def sum (agent 0)) ;; create an agent initialized to 0

;; create a vector which contains number 1 to 100
(def numbers (vec (range 1 101)))

(doseq [x numbers]
  (send sum + x)) ;; add x to the current value

(await sum) ;; wait until all sent actions are done

@sum
;; => 5050

;; ---
;; many agents, round-robin
;; ---

;; make 10 agents initialized to zero
(def sums (map agent (repeat 10 0)))

(def numbers-large (range 1000000)) ;; one million numbers

;; loop through all numbers and round-robin the agents
(doseq [[x agnt] (map vector numbers-large (cycle sums))]
  (send agnt + x))

;; wait at most 10 seconds
(apply await-for 10000 sums)

;; sum up the answers in all ten agents
(apply + (map deref sums))
;; => 499999500000

;; ---
;; many agents,
;; ---

;; make 10 agents initialized to zero
(def sums-v2 (map agent (repeat 10 0)))

(def numbers-large-v2 (agent (range 1000000))) ;; one million numbers in an agent

(defn dequeue-and-add [sum-agent]
  (letfn [(add [current-sum x]
            ;; do the addition
            (let [new-sum (+ current-sum x)]
              ;; when we're done, schedule the next dequeue
              (send numbers-large-v2 dequeue)
              ;; return the new value of the Agent
              new-sum))
          (dequeue [xs]
              ;; check if there's more to do
            (when (seq xs)
                ;; send the first number to the Agent
              (send sum-agent add (first xs)))
                ;; return the other numbers for other Agents
            (rest xs))]
    (send numbers-large-v2 dequeue)))

;; start all 10 Agents working
(doseq [sum-agent sums-v2]
  (dequeue-and-add sum-agent))

;; wait for all the numbers to be cleared from the queue
(loop []
  (when (seq @numbers-large-v2)
    (Thread/sleep 1000)
    (recur)))

;; sum up the answers in all ten agents
(apply + (map deref sums-v2))
;; => 499999500000
