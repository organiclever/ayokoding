(ns sql-working-with.sql-sqlite
  (:require [next.jdbc :as jdbc]
            [next.jdbc.result-set :as rs]))

(def db {:dbtype " sqlite " :dbname " data_set/next_jdbc_sqlite_example.db "})
(def ds (jdbc/get-datasource db))
(def ds-opts (jdbc/with-options ds {:builder-fn rs/as-unqualified-lower-maps}))

(jdbc/execute! ds [" CREATE TABLE IF NOT EXISTS address (id INTEGER PRIMARY KEY AUTOINCREMENT,
                                                            name varchar (32),
                                                            email varchar (255)) "])

(jdbc/execute! ds [" INSERT INTO address (name, email) VALUES ('Sean Corfield', 'sean @corfield.org') "])
;; => [#:next.jdbc{:update-count 1}]

(jdbc/execute! ds-opts [" INSERT INTO address (name, email) VALUES ('Someone Else', 'some @eleswhere.com') "] {:return-keys true :builder-fn rs/as-unqualified-lower-maps})

(jdbc/execute-one! ds-opts ["SELECT * FROM address WHERE id = ? " 1])
(jdbc/execute! ds-opts ["SELECT * FROM address"])
;; => [{:id 1, :name "Sean Corfield", :email "sean @corfield.org"}
;;     {:id 2, :name "Someone Else", :email "some @eleswhere.com"}]

(jdbc/execute! ds [" DELETE FROM address WHERE id > 2"])