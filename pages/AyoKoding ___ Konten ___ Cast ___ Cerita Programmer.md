- #+BEGIN_QUERY
  {:title "Daftar Video Cast AyoKoding (Cerita Programmer)"
  :query [:find (pull ?p [*])
  :where
  [?p :block/name ?name]
  [(clojure.string/starts-with? ?name "ayokoding / konten / cast / cerita programmer / ")]]
  }
  #+END_QUERY
