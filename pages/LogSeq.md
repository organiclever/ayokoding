- #cheatsheet
  - How to do simple query
    - ```clojure
      {{query (and (page-property type "content") (page-property content-series "Cerita Programmer"))}}
      ```
  - Advanced query with "simple" query
    - ```clojure
      #+BEGIN_QUERY
      {
      :title "Content"
      :query (and (page-property type "content") (page-property content-series "Jam Kantor"))}
      #+END_QUERY
      ```
  - Advanced query with clojure function
    - ```clojure
      #+BEGIN_QUERY
      {
      	:title 	"Daftar konten yang ada di ayokoding"
      	:query 	[:find (pull ?p [*])
      	:where
            [?p :block/name ?name]
      			[(clojure.string/starts-with? ?name "ayokoding / konten /")]]}
      #+END_QUERY
      ```
  - Advanced query with multiple filter
    - ```clojure
      #+BEGIN_QUERY
        {
        :title "Content"
        :query [
          :find (pull ?p [*])
          :in $ ?search-term
          :where
            [?p :block/properties ?props]
            [(get ?props :type) ?pt]
            [(= ?pt "content")]
            [(get ?props :content-series) ?cs]
            [(= ?cs ?search-term)]]
        :inputs ["jam-kantor"]}
      #+END_QUERY
      ```
