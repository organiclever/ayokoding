(ns http-server-pedestal.official-tutorial.hello
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]))

(defn respond-hello [_request]
  {:status 200
   :body "Hello, World!"})

(def routes
  (route/expand-routes
   #{["/greet" :get respond-hello :route-name :greet]}))

(route/try-routing-for routes :prefix-tree "/greet" :get)
(route/try-routing-for routes :prefix-tree "/greet" :post)
(route/try-routing-for routes :prefix-tree "/greet" :put)

(defn create-server []
  (http/create-server
   {::http/routes routes
    ::http/type :jetty
    ::http/port 8890}))

(defn start []
  (http/start (create-server)))

(comment
  (start))