(ns concurreny-threads.core)

;; contents:
;; introduction to java thread
;; problem: race condition
;;

(defn do-something-in-a-thread []
  (println "Hello from the thread")
  (println "Goodbye from the thread"))

(.start (Thread. do-something-in-a-thread))

(defn do-something-else []
  (println "Hello from the thread")
  (println "Goodbye from the thread"))

;; (.start (Thread. do-something-else))

(defn -main []
  (println "Coming to you live from the main thread")
  (.start (Thread. do-something-else))
  (Thread/sleep 3000)
  (println "Goodbye from the main thread"))

(def fav-book "Jaws")

(defn make-emma-favorite [] (def fav-book "Emma"))
(defn make-2001-favorite []
  (println "2001 is my favorite book")
  (def fav-book "2001"))

(make-emma-favorite)
(make-2001-favorite)

(.start (Thread. make-emma-favorite))
(.start (Thread. make-2001-favorite))

fav-book

(comment
  (-main))

;;

(def ^:dynamic *favorite-book* "Oliver Twist")

(def thread-1
  (Thread.
   #(binding [*favorite-book* "2001"]
      (println "My favorite book is" *favorite-book*))))

(def thread-2
  (Thread.
   #(binding [*favorite-book* "Emma"]
      (println "My favorite book is" *favorite-book*))))

(.start thread-1)
(.start thread-2)

*favorite-book*

;; Joining thread

(def del-thread (Thread. #(Thread/sleep 2000)))

(.start del-thread)

(.join del-thread)

(println "Thread is done")

;; Promise

(def the-result (promise))
(deliver the-result "Emma")

(str "The value of my promise is: " @the-result)

(def the-result-2 (promise))
(deliver the-result-2 "Emma")
(str "The value of my promise is: " (deref the-result-2))

(def inventory [{:title "Emma" :sold 51 :revenue 255}
                {:title "Sense and Sensibility" :sold 25 :revenue 125}
                {:title "Pride and Prejudice" :sold 40 :revenue 200}])

;; parallel computation with promise

(defn sum-copies-sold [inventory]
  (reduce + (map :sold inventory)))
(defn sum-revenue [inventory]
  (reduce + (map :revenue inventory)))

(let [copies-promise (promise)
      revenue-promise (promise)]

  (.start (Thread. #(deliver copies-promise (sum-copies-sold inventory))))
  (.start (Thread. #(deliver revenue-promise (sum-revenue inventory))))

  [(str "Total copies sold: " @copies-promise)
   (str "Total revenue: " @revenue-promise)])
;; => ["Total copies sold:116" "Total revenue:580"]

;; future
;; future is a promise that is computed in a separate thread

(def revenue-future
  (future (apply + (map :revenue inventory))))
(str "The total revenue is: " @revenue-future)
;; => "The total revenue is: 580"

;; running multiple future

(defn long-running-operation [id]
  (let [time-to-sleep (* 1000 (rand-int 10))]
    (Thread/sleep time-to-sleep)
    (str "Operation: " id "; Sleep time: " time-to-sleep " ms")))

(defn perform-operations []
  (let [futures (mapv #(future (long-running-operation %)) (range 1 10))
        results {:start (java.time.LocalTime/now)
                 :results (doall (map deref futures))}]
    results))

(assoc (perform-operations) :end (java.time.LocalTime/now))
;; => {:start #object[java.time.LocalTime 0x1c6622f3 "09:00:09.985509"],
;;     :results
;;     ("Operation: 1; Sleep time: 9000 ms"
;;      "Operation: 2; Sleep time: 4000 ms"
;;      "Operation: 3; Sleep time: 2000 ms"
;;      "Operation: 4; Sleep time: 7000 ms"
;;      "Operation: 5; Sleep time: 6000 ms"
;;      "Operation: 6; Sleep time: 7000 ms"
;;      "Operation: 7; Sleep time: 4000 ms"
;;      "Operation: 8; Sleep time: 0 ms"
;;      "Operation: 9; Sleep time: 7000 ms"),
;;     :end #object[java.time.LocalTime 0x5287b8cf "09:00:18.987226"]}

;; thread pool

(import java.util.concurrent.Executors)

(def fixed-pool (Executors/newFixedThreadPool 3))

(defn a-lot-of-work [i]
  (println (str "! Starting work " i))
  (Thread/sleep (* 1000 (rand-int 5)))
  (println (str "> Finish work " i)))

(doseq
 [i (range 10)]
  (.execute fixed-pool #(a-lot-of-work i)))

(.shutdown fixed-pool)

;; don't wait forever for the promise

(def revenue-promise (promise))
(deref revenue-promise 500 :timeout)
;; => :timeout

;; ---------------