(ns sql-working-with.sql-sqlite
  (:require [next.jdbc :as jdbc]))

(def db {:dbtype " sqlite " :dbname " data_set/next_jdbc_sqlite_example.db "})

(def ds (jdbc/get-datasource db))

(jdbc/execute! ds [" CREATE TABLE IF NOT EXISTS address (id INTEGER PRIMARY KEY AUTOINCREMENT,
                                                            name varchar (32),
                                                            email varchar (255)) "])

(jdbc/execute! ds [" INSERT INTO address (name, email) VALUES ('Sean Corfield', 'sean @corfield.org') "])
(jdbc/execute! ds [" INSERT INTO address (name, email) VALUES ('Someone Else', 'some @eleswhere.com') "] {:return-keys true})

(jdbc/execute! ds [" SELECT * FROM address "])

(jdbc/execute-one! ds [" SELECT * FROM address WHERE id = ? " 1])

;; (jdbc/execute! ds [" DELETE FROM address WHERE name = 'Sean Corfield' "])"