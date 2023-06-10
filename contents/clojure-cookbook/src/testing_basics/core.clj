(ns testing-basics.core
  (:require [clojure.test :refer [are deftest is run-tests]]))

;; Basic functions

(defn sum [a b]
  (+ a b))
(deftest sum-test
  (is (= 3 (sum 1 2)))
  (is (= 0 (sum 1 -1))))

(defn subtract [a b]
  (- a b))
(deftest subtract-test
  (are [x y] (= x y)
    0 (subtract 1 1)
    -1 (subtract 1 2)))

;; Function with multiple arities

(defn greeting
  ([] "Hello!")
  ([name] (str "Hello, " name "!"))
  ([name salutation] (str salutation ", " name "!")))
(deftest greeting-test
  (is (= "Hello!"
         (greeting)))
  (is (= "Hello, John!"
         (greeting "John")))
  (is (= "Good morning, John!"
         (greeting "John" "Good morning"))))

;; Function that throws an exception

(defn throws-exception []
  (throw (Exception. "This function throws an exception")))
(deftest throws-exception-test
  (is (thrown?  Exception
                (throws-exception))))

(defn divide [a b]
  (if (zero? b)
    (throw (IllegalArgumentException "Cannot divide by zero"))
    (/ a b)))
(deftest divide-test
  (is (= 2 (divide 4 2)))
  (is (thrown?  IllegalArgumentException
                (divide 4 0))))

(run-tests 'testing-basics.core)
;; => {:test 4, :pass 8, :fail 0, :error 0, :type :summary}
