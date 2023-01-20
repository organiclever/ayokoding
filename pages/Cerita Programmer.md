- #+BEGIN_QUERY
  {
  :title "Seri Cerita Programmer"
  :query (and (page-property type "content")(page-property content-series "Cerita Programmer"))
  }
  #+END_QUERY
  query-sort-by:: page
  query-sort-desc:: true
  query-properties:: [:page :updated-at]
