content-origin:: external
content-status:: wip
content-authors:: [[Russ Olsen]]
lang:: en
type:: content

- Topics
  - [[Clojure]]
- Tags
  - [[Book]]
- Publishers
  - [[Pragmatic Bookshelf]]
- #target-audience
  - [[Entry Level Programmer]]
- Read on
  - [[O'Reilly Book]]
    - https://www.oreilly.com/library/view/automating-workflows-with/9781800560406
- Table of Contents
  - Part 1: Basics
    - Chapter 1 - Hello, Clojure
    - Chapter 2 - Vectors and Lists
    - Chapter 3 - Maps, Keywords, and Sets
    - Chapter 4 - Logic
    - Chapter 5 - More Capable Functions
    - Chapter 6 - Functional Things
    - Chapter 7 - Let
    - Chapter 8 - Def, Symbols, Vars
    - Chapter 9 - Namespaces
  - Part 2: Intermediate
    - Chapter 10 - Sequences
    - Chapter 11 - Lazy Sequences
    - Chapter 12 - Destructuring
    - Chapter 13 - Records and Protocols
    - Chapter 14 - Tests
    - Chapter 15 - Spec
  - Part 3: Advanced
    - Chapter 16 - Interoperating with Java
    - Chapter 17 - Threads, Promises, and Futures
    - Chapter 18 - State
    - Chapter 19 - Read and Eval
    - Chapter 20 - Macros
    - Chapter 21 - Conclusion
- Chapter 1 - Hello, [[Clojure]]
  - Code snippets
    - ```clojure
      (ns follow-along.c01-hello-clojure)

      ;; DO two semiconlons add up to a whole colon?

      (println "Hello, world!")

      (str "Clo" "jure")
      ;; => "Clojure"

      (str "Hello," " " "world" "!")
      ;; => "Hello, world!"

      (str 3 " " 2 " " "Blast off!")
      ;; => "3 2 Blast off!"


      (count "Hello, world")
      ;; => 12

      (count "Hello")
      ;; => 5

      (count "")
      ;; => 0

      (println true)
      (println false)
      (println "Nobody's home:" nil)
      (println "we can print many things:" true false nil)

      ;; Arithmetic

      (+ 1 2)
      ;; => 3

      (* 16 124)
      ;; => 1984

      (- 2000 16)
      ;; => 1984

      (/ 25792 13)
      ;; => 1984

      (/ (+ 1984 2010) 2)
      ;; => 1997

      (/ (+ 1984.0 2010) 2)
      ;; => 1997.0

      ;; Not variable assignment but close
      (def first-name "Russ")
      first-name
      ;; => "Russ"

      (def the-average (/ (+ 20 40.0) 2.0))
      the-average
      ;; => 30.0

      ;; a function of your own

      (defn hello-world []
        (println "Hello, world!"))
      (hello-world)

      (defn say-welcome [what]
        (println "Welcome to" what))
      (say-welcome "Clojure")

      (defn average [a b]
        (/ (+ a b) 2.0))
      (average 5.0 10.0)
      ;; => 7.5

      (/ 100 0)
      ;; => Execution error (ArithmeticException) at follow-along.c01/eval8056 (form-init14787553069179530715.clj:75).
      ;;    Divide by zero

      (.toUpperCase "test")
      ;; => "TEST"
      (.getName String)
      ;; => "java.lang.String"
      ```
- Chapter 2 - Vectors and Lists
  - Code snippets
    - ```clojure
      (ns follow-along.c02-vectors-and-lists)


      ;; one thing after another


      [1 2 3 4]
      ;; => [1 2 3 4]
      [1 "two" 3 "four" true]
      ;; => [1 "two" 3 "four" true]
      [[1 true 3 "four" 5] 6]
      ;; => [[1 true 3 "four" 5] 6]


      ;; A toolkit of functions


      (vector true 3 "four" 5)
      ;; => [true 3 "four" 5]

      (def novels ["Emma" "Coma" "War and Peace"])
      (count novels)
      ;; => 3
      (first novels)
      ;; => "Emma"
      (rest novels)
      ;; => ("Coma" "War and Peace")
      (into [] (rest novels))
      ;; => ["Coma" "War and Peace"]
      (rest (rest novels))
      ;; => ("War and Peace")

      (def year-books ["1491","April 1865","1984","2001"])
      (def third-book (first (rest (rest year-books))))

      year-books
      ;; => ["1491" "April 1865" "1984" "2001"]
      third-book
      ;; => "1984"
      (nth year-books 2)
      ;; => "1984"
      (year-books 2)
      ;; => "1984"

      ;; Growing your vectors
      novels
      ;; => ["Emma" "Coma" "War and Peace"]
      (conj novels "Carrie")
      ;; => ["Emma" "Coma" "War and Peace" "Carrie"]
      (cons "Carrie" novels)
      ;; => ("Carrie" "Emma" "Coma" "War and Peace")


      ;; Lists


      '(1 2 3)
      ;; => (1 2 3)
      '(1 2 3 "four" 5 "six")
      ;; => (1 2 3 "four" 5 "six")
      '([1 2 ("A" "list" "inside a" "vector")] "inside" "a" "list")
      ;; => ([1 2 ("A" "list" "inside a" "vector")] "inside" "a" "list")
      (list 1 2 3 "four" 5 "six")
      ;; => (1 2 3 "four" 5 "six")

      (def poems `("Iliad" "Odyssey" "Now we are six"))
      (count poems)
      ;; => 3
      (first poems)
      ;; => "Illiad"
      (rest poems)
      ;; => ("Odyssey" "Now we are six")
      (nth poems 2)
      ;; => "Now we are six"
      (conj poems "Jabberwocky")
      ;; => ("Jabberwocky" "Illiad" "Odyssey" "Now we are six")

      (def vector-poems ["Iliad" "Odyssey" "Now we are six"])
      (conj vector-poems "Jabberwocky")
      ;; => ["Iliad" "Odyssey" "Now we are six"]


      ;; Staying out of trouble
      novels
      ;; => ["Emma" "Coma" "War and Peace"]
      (conj novels "Jaws")
      ;; => ["Emma" "Coma" "War and Peace" "Jaws"]
      novels
      ;; => ["Emma" "Coma" "War and Peace"]

      (def more-novels (conj novels "Jaws"))
      more-novels
      ;; => ["Emma" "Coma" "War and Peace" "Jaws"]
      ```
- Chapter 3 - Maps, Keywords, and Sets
