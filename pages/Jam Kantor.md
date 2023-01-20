- #+BEGIN_QUERY
  {
  :title "Seri Jam Kantor"
  :query (and (page-property type "content")(page-property content-series "Jam Kantor"))
  }
  #+END_QUERY
  query-sort-by:: page
  query-sort-desc:: false
  query-properties:: [:page :updated-at]
