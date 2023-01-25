public:: true

- Original Content
  <!-- - Lang: [[English]]
    - query-sort-by:: updated-at
      query-sort-desc:: true
      query-properties:: [:page]
      query-table:: true
      #+BEGIN_QUERY
      {:title "List"
      :query (and
      (page-property type "content")
      (page-property lang "en")
      (page-property content-origin "internal"))
      :result-transform (fn [result]
      (->> result
      (sort-by (fn [h]
      (get-in h [:block/created-at])))
      (take 20))
      )}
      #+END_QUERY -->
  - Lang: [[Bahasa]]
    - query-sort-by:: updated-at
      query-sort-desc:: true
      query-properties:: [:page :created-at]
      query-table:: true
      #+BEGIN_QUERY
      {:title "List"
      :query (and
      (page-property type "content")
      (page-property lang "id")
      (page-property content-origin "internal"))
      :result-transform (fn [result]
      (->> result
      (sort-by (fn [h]
      (get-in h [:block/created-at])))
      (take 20))
      )}
      #+END_QUERY
- External Content (English)
  - query-sort-by:: updated-at
    query-sort-desc:: true
    query-properties:: [:page]
    query-table:: true
    #+BEGIN_QUERY
    {:title "List"
    :query (and
    (page-property type "content")
    (page-property content-origin "external"))
    :result-transform (fn [result]
    (->> result
    (sort-by (fn [h]
    (get-in h [:block/created-at])))
    (take 20))
    )}
    #+END_QUERY
- Misc
  - [[About AyoKoding]]
