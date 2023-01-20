- #+BEGIN_QUERY
  {:title "Daftar konten yang ada di ayokoding"
  :query [:find (pull ?p [*])
  :where
  [?p :block/name ?name]
  [(clojure.string/starts-with? ?name "ayokoding / konten /")]]
  }
  #+END_QUERY
