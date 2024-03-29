(ns testing-basics.core
  (:require [clojure.test :refer [are deftest is run-all-tests run-tests
                                  testing]]))

;; ---
;; Testing functions
;; ---

;; Basic functions

(defn sum [a b]
  (+ a b))
(deftest sum-test
  (is (= 3 (sum 1 2)))
  (is (= 0 (sum 1 -1))))

(deftest sum-test-with-setup
  (let [a 1]
    (is (= 3 (sum a 2)))
    (is (= 0 (sum a -1)))))

(defn subtract [a b]
  (- a b))
(deftest subtract-test
  (are [x y] (= x y)
    0 (subtract 1 1)
    -1 (subtract 1 2)))

;; Function with multiple arities

(defn greeting
  ([] (greeting "World" "Hello"))
  ([name] (greeting name "Hello"))
  ([name salutation] (str salutation ", " name "!")))
(deftest greeting-test
  (is (= "Hello, World!"
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

(run-tests 'testing-basics.core)
;; => {:test 6, :pass 13, :fail 0, :error 0, :type :summary}

(run-all-tests)
;; => {:test 6, :pass 13, :fail 0, :error 0, :type :summary}

;; ---
;; Organizing the tests
;; ---

(defn divide [a b]
  (if (zero? b)
    (throw (IllegalArgumentException. "Cannot divide by zero"))
    (/ a b)))
(deftest divide-test
  (testing "Positive case"
    (is (= 2 (divide 4 2)))
    (is (= 1/2 (divide 1 2))))
  (testing "Negative case"
    (is (thrown?  IllegalArgumentException
                  (divide 4 0)))))
