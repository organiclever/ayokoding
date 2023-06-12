(ns functions-intermediate.core-test
  (:require
   [clojure.test :refer [deftest is]]
   [functions-intermediate.core :as subject]))

(deftest factorial-test
  (is (= 120 (subject/factorial 5))))

(deftest fibonacci-test
  (is (= 55 (subject/fibonacci 10))))

(deftest apply-twice-test
  (is (= 16 (subject/apply-twice subject/square 2))))

(deftest square-test
  (is (= 4 (subject/square 2))))

(deftest add-one-test
  (is (= 4 (subject/add-one 3))))

(deftest triple-test
  (is (= 9 (subject/triple 3))))

(deftest cubic-test
  (is (= 27 (subject/cubic 3))))

(deftest combined-function-test
  (is (= [6 15 125] (subject/combined-function 5))))

(deftest add-test
  (is (= 3 (subject/add 1 2))))

(deftest curried-add-test
  (is (= 8 (subject/curried-add 3))))

(deftest greeting-test
  (is (= "Hello, World!"
         (subject/greeting)))
  (is (= "Hello, John!"
         (subject/greeting "John")))
  (is (= "Good morning, John!"
         (subject/greeting "John" "Good morning"))))

(deftest greeting-v2-test
  (is (= "Hello, World!"
         (subject/greeting-v2)))
  (is (= "Hello, John!"
         (subject/greeting-v2 "John")))
  (is (= "Good morning, John!"
         (subject/greeting-v2 "John" "Good morning"))))

(deftest sum-test
  (is (= 3 (subject/sum 1 2)))
  (is (= 0 (subject/sum 1 -1))))

(deftest recursive-function-test
  (is (= 6 (subject/recursive-function 6))))

(deftest recursive-function-with-recur-test
  (is (= 6 (subject/recursive-function-with-recur 6))))

(deftest factorial-with-recur-test
  (is (= 120 (subject/factorial-with-recur 5))))

(deftest fibonacci-with-recur-test
  (is (= 55 (subject/fibonacci-with-recur 10))))

(deftest triple-2-test
  (is (= 9 (subject/triple-2 3))))

(deftest my-function-test
  (is (= "Executing my-function with argument: 1" (subject/my-function 1))))