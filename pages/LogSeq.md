- #cheatsheet
  - How to do simple query
    - ```clojure
      {{query (and (page-property type "content") (page-property content-series "Cerita Programmer")) }}
      ```
  - How to do advanced query
    - ```clojure
      #+BEGIN_QUERY
      {
      	:title 	"Daftar konten yang ada di ayokoding"
      	:query 	[:find (pull ?p [*])
      	:where
                  [?p :block/name ?name]
      			[(clojure.string/starts-with? ?name "ayokoding / konten /")]]
      }
      #+END_QUERY
      ```
-
-
