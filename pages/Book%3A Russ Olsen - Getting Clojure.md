public:: true
content-origin:: external
content-status:: wip
content-authors:: [[Russ Olsen]]
lang:: en
type:: content

- Topics
  - [[Clojure]]tt
- Tags
  - [[Book]]
- Publishers
  - [[Pragmatic Bookshelf]]
- #target-audience
  - [[Entry Level Programmer]]
- Read on
  - [[O'Reilly Book]]
    - https://www.oreilly.com/library/view/automating-workflows-with/9781800560406
- #wkf-personal-remarks
  - Pros
    - Easy to follow
    - There are "In the Wild" sections
      - Explain to us about the recently explained stuff in the "real" codebase.
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
      ```
- Chapter 2 - Vectors and Lists
  - Vectors and Lists are immutable
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
  - Maps
    - [[Hash-map]]
    - Maps is also immutable
    - Associative Vectors
      - Vectors and maps have a lot in common. They both associate keys with values, the difference being that with vectors the keys are limited to integers while in maps the keys can be more or less anything. That is, in fact, how Clojure looks at vectors—which means that many of the functions that work with maps will also work with vectors. For example, assoc and dissoc work fine on vectors. Thus `(assoc [:title :by :published] 1 :author)` will give you `[:title :author :published]`.
    - The maps that you create with the literal `{}` or the `hash-map` function make no promises about the order of their keys.
    - Clojure treats commas as whitespace.
  - Keywords
    - Technically, keywords are interned strings, similar to symbols in Ruby and distant cousins to the individual items that go into enumerated types in other languages.
  - Sets
    - Clojure Sets are all about membership
    - Sets have their own ideas about the order of their elements
  - Keep in mind that in expressions like `(:author book)` or `(:sci-fi genres)`, the keywords `:author` and `:sci-fi` aren’t just pretending to be functions. They are functions—functions that look themselves up in a map or a set. It is very common, if a bit confusing to beginners, to see a keyword like `:title` in a context where a function is clearly called for. In those situations, you can bet that there is either a map or a set involved.
  - Wrapping up
    - We are now done with Clojure's basic data structures!
  - Code snippets
    - ```clojure
      (ns follow-along.c03-maps-keywords-and-sets)

      ;; This goes with that

      {"title" "Oliver Twist" "author" "Dickens" "published" 1838}
      ;; => {"title" "Oliver Twist", "author" "Dickens", "published" 1838}

      (hash-map "title" "Oliver Twist"
                "author" "Dickens"
                "published" 1838)

      (def book-arc
        {"title" "Oliver Twist" "author" "Dickens" "published" 1838})
      (get book-arc "published")
      ;; => 1838
      (book-arc "published")
      ;; => 1838
      (get book-arc "published?")
      ;; => nil
      (book-arc "published?")
      ;; => nil


      ;; Keywords


      :title
      ;; => :title
      :author
      ;; => :author
      :published
      ;; => :published
      :word-count
      ;; => :word-count
      :preface&introduction
      ;; => :preface&introduction
      :chapter-1-and-2
      ;; => :chapter-1-and-2


      (def book
        {:title "Oliver Twist"
         :author "Dickens"
         :published 1838})
      (str "Title: " (book :title))
      ;; => "Title: Oliver Twist"
      (str "By: " (book :author))
      ;; => "By: Dickens"
      (str "Published: " (book :published))
      ;; => "Published: 1838"
      (str "Published: " (:published book))
      ;; => "Published: 1838"


      ;; Changing your map without changing it


      (assoc book :page-count 362)
      ;; => {:title "Oliver Twist", :author "Dickens", :published 1838, :page-count 362}
      book
      ;; => {:title "Oliver Twist", :author "Dickens", :published 1838}
      (= book book)
      ;; => true
      (= book (assoc book :page-count 362))
      ;; => false

      (assoc book :page-count 362 :title "War & Peace")
      ;; => {:title "War & Peace", :author "Dickens", :published 1838, :page-count 362}
      (dissoc book :published)
      ;; => {:title "Oliver Twist", :author "Dickens"}
      (dissoc book :paperback :illustrator :favorite-zoo-animal)
      ;; => {:title "Oliver Twist", :author "Dickens", :published 1838}
      (= book (dissoc book :paperback :illustrator :favorite-zoo-animal))
      ;; => true

      ;; Assoc works on vectors too
      (assoc [:title :by :published] 1 :author)
      ;; => [:title :author :published]


      ;; Other handy map functions


      (keys book)
      ;; => (:title :author :published)
      (vals book)
      ;; => ("Oliver Twist" "Dickens" 1838)


      ;; Sets



      (def genres #{:sci-fi :romance :mystery})
      (def authors #{"Dickens" "Austen" "King"})

      (contains? authors "Austen")
      ;; => true
      (contains? genres "Austen")
      ;; => false

      (authors "Austen")
      ;; => "Austen"
      (genres :historical)
      ;; => nil

      (:sci-fi genres)
      ;; => :sci-fi
      (:historical genres)
      ;; => nil

      (def more-authors (conj authors "Clarke"))
      more-authors
      ;; => #{"King" "Dickens" "Clarke" "Austen"}
      (disj more-authors "King")
      ;; => #{"Dickens" "Clarke" "Austen"}


      ;; Staying out of trouble


      (= :title "title")
      ;; => false
      (= (book "title") (book :title))
      ;; => false
      (assoc book "title" "Pride and Prejudice")
      ;; => {:title "Oliver Twist", :author "Dickens", :published 1838, "title" "Pride and Prejudice"}


      (book :some-key-that-is-clearly-not-there)
      ;; => nil


      (def anonymous-book {:title "The Arabian Nights" :author nil})
      (anonymous-book :author)
      ;; => nil
      (contains? anonymous-book :title)
      ;; => true
      (contains? anonymous-book :author)
      ;; => true
      (contains? anonymous-book :favorite-color)
      ;; => false


      (def possible-authors #{"Austen" "Dickens" nil})
      (contains? possible-authors "Austen")
      ;; => true
      (contains? possible-authors "King")
      ;; => false
      (contains? possible-authors nil)
      ;; => true

      book
      ;; => {:title "Oliver Twist", :author "Dickens", :published 1838}
      (first book)
      ;; => [:title "Oliver Twist"]
      (rest book)
      ;; => ([:author "Dickens"] [:published 1838])
      (count book)
      ;; => 3

      ```
- Chapter 4 - Logic
  - Note that the `=` function is built on the idea of structural equality: roughly, two values are equal according to `=` if they have the same value. Under the hood, `=` is identical to the Java equals method.
  - One issue with having a more or less infinite collection of true things along with two different false things is the terminology. When we say something is `true`, do we mean the specific value `true` or just true in the sense of not being `false` or `nil`? To avoid confusion, Clojurists sometimes refer to the values treated as accurate in the more general sense as being "truthy". Thus, while only `true` is `true`, `"hello"`, `1.0`, and `"Russ"` is all truthy. Similarly, we can use "falsy" to describe the metaphysical quality shared by `nil` and `false`. In Clojure, there are precisely two "falsy"s things—`false` and `nil`—and an infinite number of "truthy" things.
  - Code snippets
    - ```clojure
      (ns follow-along.c04-logic)

      ;; The fundamental if


      (defn print-greeting [preffered-customer]
        (if preffered-customer
          "Welcome back to Blotts Books!"
          "Welcome to Blotts Books!"))

      (print-greeting true)
      ;; => "Welcome back to Blotts Books!"
      (print-greeting false)
      ;; => "Welcome to Blotts Books!"


      ;; Asking questions


      (= 1 1)
      ;; => true
      (= 1 2)
      ;; => false
      (= 1 1 1 1 1 1 1)
      ;; => true
      (= 1 1 1 1 2 1 1)
      ;; => false

      (not= 1 1)
      ;; => false
      (not= 1 2)
      ;; => true
      (not= 1 1 1 1 1 1 1)
      ;; => false
      (not= 1 1 1 1 2 1 1)
      ;; => true

      (> 1 2)
      ;; => false
      (> 1 2)
      ;; => false

      (number? 1984)
      ;; => true
      (string? "123")
      ;; => true
      (keyword? :test)
      ;; => true
      (map? {:title 1984})
      ;; => true
      (vector? [1984])
      ;; => true

      ;; Charge extra if it's an express order or oversized
      ;; and they are not a preferred customer.
      (defn shipping-surcharge? [preferred-customer express oversized]
        (and (not preferred-customer) (or express oversized)))
      (shipping-surcharge? false true true)
      ;; => true


      ;; Truthy and Falsy


      (if 1 true false)
      ;; => true
      (if "hello" true false)
      ;; => true
      (if [1 2 3] true false)
      ;; => true
      (if "" true false)
      ;; => true
      (if 0 true false)
      ;; => true
      (if -1 true false)
      ;; => true

      ;; only these 2 are falsy
      (if false true false)
      ;; => false
      (if nil true false)
      ;; => false


      ;; Do and when


      (do
        (println "This is four expressions")
        (println "All grouped together as one")
        (println "That prints some stuff and then evaluates to 44")
        44)
      ;; => 44

      (let [preffered-customer true]
        #_{:clj-kondo/ignore [:unused-value]}
        (when preffered-customer
          "Hello returncing customer!"
          "Welcome back to Blotts Books!"))
      ;; => "Welcome back to Blotts Books!"

      ;; else is just a normal keyword which evaluated as a truthy value
      (defn shipping-charge [preffered-customer order-amount]
        (cond
          preffered-customer 0.0
          (< order-amount 50.0) 5.0
          (< order-amount 100.0) 10.0
          :else (* 0.1 order-amount)))
      (shipping-charge false 101)
      ;; => 10.100000000000001

      (defn customer-greeting [status]
        (case status
          :gold "Welcome, welcome, welcome back!!!"
          :preffered "Welcome back!"
          "Welcome to Blotts Books"))
      (customer-greeting :gold)
      ;; => "Welcome, welcome, welcome back!!!"
      (customer-greeting :preffered)
      ;; => "Welcome back!"
      (customer-greeting nil)
      ;; => "Welcome to Blotts Books"


      ;; Throwing and catching

      ;; (/ 0 0)
      ;; => Execution error (ArithmeticException) at follow-along.c04-logic/eval15484 (form-init4924825596685870731.clj:127).
      ;;    Divide by zero

      1
      ;; => 1

      (try
        (/ 1 0)
        (catch ArithmeticException _ (println "Math problem."))
        (catch StackOverflowError _ (println "Unable to publish..")))
      ;; => nil


      (defn publish-book [book]
        (when (not (:title book))
          (throw (ex-info "A book needs a title!" {:book book})))
        ;; Lots of publishing stuff..
        )
      (publish-book {:title "Teletubbies"})
      ;; => nil
      ;; (publish-book {:author "super author"})
      ;; => Execution error (ExceptionInfo) at follow-along.c04-logic/publish-book (form-init4924825596685870731.clj:143).
      ;;    A book needs a title!


      (try (publish-book {:author "Hurra!"})
           (catch clojure.lang.ExceptionInfo _  "Exception successfully catched!"))
      ;; => "Exception successfully catched!"


      ;; In the wild


      (defn ensure-task-is-a-vector [task]
        (if (vector? task)
          task
          [task]))
      (ensure-task-is-a-vector [1 2 3])
      ;; => [1 2 3]
      (ensure-task-is-a-vector '(1 2 3))
      ;; => [(1 2 3)]


      ;; Staying out of trouble


      (and true 1984)
      ;; => 1984
      (and 2001 "Emma")
      ;; => "Emma"
      (and 2001 nil "Emma")
      ;; => nil

      ```
- Chapter 5 - More Capable Functions
  - Multimethod addition does not have to appear in the same file or be written by the same programmer as the originals. And this means Multimethods provide a great extension point for your code.
  - Loop and recur
    - ```clojure
      (def books
        [{:title  "Jaws"   :copies-sold 2000000}
         {:title  "Emma"   :copies-sold 3000000}
         {:title  "2001"   :copies-sold 4000000}])

      (defn sum-copies
        ([books] (sum-copies books 0))
        ([books total]
         (if (empty? books)
           total
           (sum-copies
            (rest books)
            (+ total (:copies-sold (first books)))))))
      (sum-copies books)
      ;; => 9000000

      (defn better-sum-copies [books]
        (loop [books books total 0]
          (if (empty? books)
            total
            (recur
             (rest books)
             (+ total (:copies-sold (first books)))))))
      (better-sum-copies books)
      ;; => 9000000
      ```

    - The way to understand loop is to think of it as a blend of a phantom function and a call to that function. In our example, the “function” has two parameters, books and total, which initially get bound to the original book collection and 0. With books and total bound, we evaluate the body, in this case the if expression. The trick is that loop works with recur. When it hits a recur inside the body of a loop, Clojure will reset the values bound to the symbols to values passed into recur and then recursively reevaluate the loop body.
    - The second thing is that recur is a reasonably low-level tool. Chances are there is a better—and easier—way to get your task done. If, for example, you need to add up all those book sales, you would probably say something like this:
      - ```clojure
        (defn even-better-sum-copies [books] (apply + (map :copies-sold books)))
        (even-better-sum-copies books)
        ;; => 9000000
        ```
  - Code snippets
    - ```clojure
      (ns follow-along.c05-more-capable-functions
        (:require [clojure.repl :refer [doc]]))

      ;; One function, different parameters


      (defn greet1
        ([to-whom] (str "Welcome to Blotts Books" " " to-whom))
        ([message to-whom] (str message " " to-whom)))
      (greet1 "it may concern")
      ;; => "Welcome to Blotts Books it may concern"
      (greet1 "hola" "it may concern")
      ;; => "hola it may concern"

      (defn greet
        ([to-whom] (greet "Welcome to Blotts Books" to-whom))
        ([message to-whom] (str message " " to-whom)))

      (greet "it may concern")
      ;; => "Welcome to Blotts Books it may concern"
      (greet "hola" "it may concern")
      ;; => "hola it may concern"


      ;; Arguments with wild abandon


      (defn print-any-args [& args]
        (str "My arguments are:" " " args))
      (print-any-args 7 true nil)
      ;; => "My arguments are: (7 true nil)"

      (defn first-argument [& args]
        (first args))
      (first-argument 1 2 3 4)
      ;; => 1

      (defn new-first-argument [x & _] x)
      (new-first-argument 4 3 2 1)
      ;; => 4


      ;; Multimethods

      (def book ["War and Peace"  "Tolstoy"])
      (defn normalize-book-1 [book]
        (if (vector? book)
          {:title (first book) :author (second book)}
          (if (contains? book :title)
            book
            {:title (:book book) :author (:by book)})))
      (normalize-book-1 book)
      ;; => {:title "War and Peace", :author "Tolstoy"}

      (defn dispatch-book-format [book]
        (cond
          (vector? book) :vector-book
          (contains? book :title) :standard-map
          (contains? book :book) :alternative-map))
      (defmulti normalize-book dispatch-book-format)
      (defmethod normalize-book :vector-book [book]
        {:title (first book) :author (second book)})
      (defmethod normalize-book :standard-map [book]
        book)
      (defmethod normalize-book :alternative-map [book]
        {:title (:book book) :author (:by book)})
      (normalize-book {:title "War and Peace" :author "Tolstoy"})
      ;; => {:title "War and Peace", :author "Tolstoy"}
      (normalize-book {:book "War and Peace" :by "Tolstoy"})
      ;; => {:title "War and Peace", :author "Tolstoy"}
      (normalize-book ["War and Peace" "Tolstoy"])
      ;; => {:title "War and Peace", :author "Tolstoy"}


      (def books-1 [{:title  "Pride and Prejudice"  :author  "Austen"  :genre :romance}
                    {:title  "World War Z"  :author  "Brooks"  :genre :zombie}])
       	;; Remember you can use keys like :genre like functions on maps.
      (defmulti book-description :genre)
      (defmethod book-description :romance [book]
        (str  "The heart warming new romance by "  (:author book)))
      (defmethod book-description :zombie [book]
        (str  "The heart consuming new zombie adventure by "  (:author book)))
      (book-description (first books-1))
      ;; => "The heart warming new romance by Austen"
      (book-description (second books-1))
      ;; => "The heart consuming new zombie adventure by Brooks"
      (def ppz {:title  "Pride and Prejudice and Zombies"
                :author "Grahame-Smith"
                :genre :zombie-romance})
      (defmethod book-description :zombie-romance [book]
        (str  "The heart warming and consuming new romance by "  (:author book)))
      (book-description ppz)
      ;; => "The heart warming and consuming new romance by Grahame-Smith"


      ;; Deeply recursive


      (def books
        [{:title  "Jaws"   :copies-sold 2000000}
         {:title  "Emma"   :copies-sold 3000000}
         {:title  "2001"   :copies-sold 4000000}])
      (defn sum-copies
        ([books] (sum-copies books 0))
        ([books total]
         (if (empty? books)
           total
           (sum-copies
            (rest books)
            (+ total (:copies-sold (first books)))))))
      (sum-copies books)
      ;; => 9000000

      (defn better-sum-copies [books]
        (loop [books books total 0]
          (if (empty? books)
            total
            (recur
             (rest books)
             (+ total (:copies-sold (first books)))))))
      (better-sum-copies books)
      ;; => 9000000

      (defn even-better-sum-copies [books] (apply + (map :copies-sold books)))
      (even-better-sum-copies books)
      ;; => 9000000


      ;; Docstring

      (defn average
        "Return the average of the two parameters"
        [a b]
        (/ (+ a b) 2.0))
      (average 10 20)
      ;; => 15.0

      (defn multi-average
        "return the average of 2 or 3 numbers"
        ([a b]
         (/ (+ a b) 2.0))
        ([a b c]
         (/ (+ a b c) 3.0)))
      (multi-average 10 20)
      ;; => 15.0
      (multi-average 10 20 30)
      ;; => 20.0

      (doc multi-average)

      (defn- print-book [_])
      (defn- ship-book [_])

      #_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
      (defn publish-book-old [book]
        (when-not (contains? book :title)
          (throw (ex-info "Books must contain :title" {:book book})))
        (print-book book)
        (ship-book book))

      #_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
      (defn publish-book-with-pre [book]
        {:pre [(:title book)]}
        (print-book book)
        (ship-book book))
      ;; the value should be vector-expression for :pre condition

      (defn publish-book [book]
        {:pre [(:title book) (:author book)]
         :post [(boolean? %)]}
        (print-book book)
        (ship-book book)
        (boolean? book))

      ;; (publish-book {:title "Yo"})
      ;; => Execution error (AssertionError) at follow-along.c05-more-capable-functions/publish-book (c05_more_capable_functions.clj:168).
      ;;    Assert failed: (:author book)

      (publish-book {:title "Yo" :author 122})
      ;; => false
      ```
- Chapter 6 - Functional Things
  - Code snippets
    - ```clojure
      (ns follow-along.c06-functional-things)

      ;; Functions are values


      (def dracula {:title "Dracula"
                    :author "Stoker"
                    :price 1.99
                    :genre :horror})
      (defn cheap? [book]
        (when (<= (:price book) 9.99)
          book))
      (defn pricey? [book]
        (when (> (:price book) 9.99)
          book))
      (cheap? dracula)
      ;; => {:title "Dracula", :author "Stoker", :price 1.99, :genre :horror}
      (pricey? dracula)
      ;; => nil

      (defn horror? [book]
        (when (= (:genre book) :horror)
          book))
      (defn adventure? [book]
        (when (= (:genre book) :adventure)
          book))
      (horror? dracula)
      ;; => {:title "Dracula", :author "Stoker", :price 1.99, :genre :horror}
      (adventure? dracula)
      ;; => nil

      (defn cheap-horror? [book]
        (when (and (cheap? book)
                   (horror? book))
          book))
      (defn pricy-adventure? [book]
        (when (and (pricey? book)
                   (adventure? book))
          book))
      (cheap-horror? dracula)
      ;; => {:title "Dracula", :author "Stoker", :price 1.99, :genre :horror}
      (pricy-adventure? dracula)
      ;; => nil

      (def reasonably-priced? cheap?)
      (reasonably-priced? dracula)
      ;; => {:title "Dracula", :author "Stoker", :price 1.99, :genre :horror}

      (defn run-with-dracula [f]
        (f dracula))
      (run-with-dracula pricey?)
      ;; => nil
      (run-with-dracula horror?)
      ;; => {:title "Dracula", :author "Stoker", :price 1.99, :genre :horror}

      (defn both? [first-predicate-f second-predicate-f book]
        (when (and (first-predicate-f book)
                   (second-predicate-f book))
          book))
      (both? cheap? horror? dracula)
      ;; => {:title "Dracula", :author "Stoker", :price 1.99, :genre :horror}
      (both? pricey? adventure? dracula)
      ;; => nil


      ;; Functions on the fly

      (fn [n] (* 2 n))
      (str "A function:" (fn [n] (* 2 n)))
      ;; => "A function:follow_along.c06_functional_things$eval7991$fn__7992@d5cc0de"
      (def double-it (fn [n] (* 2 n)))
      (double-it 10)
      ;; => 20
      ((fn [n] (* 2 n)) 10)
      ;; => 20

      (defn cheaper-f [max-price]
        (fn [book]
          (when (<= (:price book) max-price)
            book)))
      ;; define some helpful functions.
      (def real-cheap? (cheaper-f 1.00))
      (def kind-of-cheap? (cheaper-f 1.99))
      (def marginally-cheap? (cheaper-f 5.99))
      (real-cheap? dracula)
      ;; => nil
      (kind-of-cheap? dracula)
      ;; => {:title "Dracula", :author "Stoker", :price 1.99, :genre :horror}
      (marginally-cheap? dracula)
      ;; => {:title "Dracula", :author "Stoker", :price 1.99, :genre :horror}

      (defn both-f [first-predicate-f second-predicate-f]
        (fn [book]
          (when (and (first-predicate-f book)
                     (second-predicate-f book))
            book)))
      (def cheap-horror-1? (both-f cheap? horror?))
      (def real-cheap-adventure? (both-f real-cheap? adventure?))
      (def real-cheap-horror? (both-f real-cheap? horror?))
      (cheap-horror-1? dracula)
      ;; => {:title "Dracula", :author "Stoker", :price 1.99, :genre :horror}
      (real-cheap-adventure? dracula)
      ;; => nil
      (real-cheap-horror? dracula)
      ;; => nil

      (def cheap-horror-possession?
        (both-f cheap-horror?
                (fn [book] (= (:title book) "Possession"))))
      (cheap-horror-possession? dracula)
      ;; => nil


      ;; A functional toolkit

      (+ 1 2 3 4)
      ;; => 10

      (def the-function +)
      (def args [1 2 3 4])
      (apply the-function args)
      ;; => 10

      (def v ["The number " 2 " best selling " "book."])
      (apply str v)
      ;; => "The number 2 best selling book."
      (apply list v)
      ;; => ("The number " 2 " best selling " "book.")
      (apply vector (apply list v))
      ;; => ["The number " 2 " best selling " "book."]

      (defn my-inc [n] (+ 1 n))
      (def my-inc-p (partial + 1))
      (my-inc 2)
      ;; => 3
      (my-inc-p 2)
      ;; => 3


      (defn cheaper-than [max-price book]
        (when (<= (:price book) max-price)
          book))
      (def real-cheap-p? (partial cheaper-than 1.00))
      (def kind-of-cheap-p? (partial cheaper-than 1.99))
      (def marginally-cheap-p? (partial cheaper-than 5.99))
      (real-cheap-p? dracula)
      ;; => nil
      (kind-of-cheap-p? dracula)
      ;; => {:title "Dracula", :author "Stoker", :price 1.99, :genre :horror}
      (marginally-cheap-p? dracula)
      ;; => {:title "Dracula", :author "Stoker", :price 1.99, :genre :horror}

      (defn adventure-p? [book]
        (when (= (:genre book) :adventure)
          book))
      (defn not-adventure? [book] (not (adventure-p? book)))
      (def not-adventure-c? (complement adventure-p?))
      (not-adventure? dracula)
      ;; => true
      (not-adventure-c? dracula)
      ;; => true

      ;; (def cheap-horror-2? (every-pred cheap? horror?))
      (def cheap-horror-possession-e?
        (every-pred
         cheap?
         horror?
         (fn [book] (= (:title book) "Possession"))))
      (cheap-horror-possession-e? dracula)
      ;; => false

      ```
- Chapter 7 - Let
- Chapter 8 - Def, Symbols, Vars
- Chapter 9 - Namespaces
- Chapter 10 - Sequences
- Chapter 11 - Lazy Sequences
- Chapter 12 - Destructuring
- Chapter 13 - Records and Protocols
- Chapter 14 - Tests
- Chapter 15 - Spec
- Chapter 16 - Interoperating with Java
- Chapter 17 - Threads, Promises, and Futures
- Chapter 18 - State
- Chapter 19 - Read and Eval
- Chapter 20 - Macros
- Chapter 21 - Conclusion
