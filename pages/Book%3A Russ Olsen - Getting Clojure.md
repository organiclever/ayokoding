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
- Chapter 5 - More Capable Functions
- Chapter 6 - Functional Things
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
