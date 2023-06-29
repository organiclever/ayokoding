(ns data-types-basics.core)

;; ---
;; Basic data types
;; ---

;; Integers
42
;; => 42
;; Float
3.14
;; => 3.14
36786883868216818816N
;; => 36786883868216818816N
3.14159265358M
;; => 3.14159265358M
22/7
;; => 22/7

;; Booleans
true
;; => true
false
;; => false

;; Character
\a
;; => \a
\b
;; => \b
\
;; => \space

;; Strings
"abcdef123456"
;; => "abcdef123456"

;; Keywords
:my-keyword
;; => :my-keyword

nil
;; => nil

;; ---
;; Underlying Class
;; ---

(class 42)
;; => java.lang.Long

(class 3.14)
;; => java.lang.Double

(class 36786883868216818816N)
;; => clojure.lang.BigInt

(class 3.14159265358M)
;; => java.math.BigDecimal

(class 22/7)
;; => clojure.lang.Ratio

(class true)
;; => java.lang.Boolean

(class false)
;; => java.lang.Boolean

(class \a)
;; => java.lang.Character

(class "abcdef123456")
;; => java.lang.String

(class :my-keyword)
;; => clojure.lang.Keyword

(class nil)
;; => nil
