(ns date-and-time.core
  (:import java.time.format.DateTimeFormatter
           java.time.LocalDate
           java.time.LocalDateTime
           java.time.LocalTime
           java.time.ZoneId
           java.time.ZoneOffset))

;; ---
;; get current time and date
;; ---

(def now (LocalDateTime/now))
(def today (LocalDate/now))
(def current-time (LocalTime/now))

now
;; => #object[java.time.LocalDateTime 0x1d4bb3cb "2023-06-16T17:06:16.866955"]
(str now)
;; => "2023-06-16T17:06:16.866955"
today
;; => #object[java.time.LocalDate 0x6ed8521a "2023-06-16"]
(str today)
;; => "2023-06-16"
current-time
;; => #object[java.time.LocalTime 0x4811ab65 "17:06:24.039461"]
(str current-time)
;; => "17:06:24.039461"

;; ---
;; Playing with date and time format
;; ---

(-> now (.format (DateTimeFormatter/ofPattern "yyyy-MM-dd HH:mm:ss")))
;; => "2023-06-16 17:06:16"
(-> today (.format DateTimeFormatter/ISO_LOCAL_DATE))
;; => "2023-06-16"
(-> current-time (.format DateTimeFormatter/ISO_LOCAL_TIME))
;; => "17:06:24.039461"

(def formatter (DateTimeFormatter/ofPattern "yyyy-MM-dd HH:mm:ss"))
(def formatted-date-time (.format formatter now))

formatted-date-time
;; => "2023-06-16 17:06:16"

(def parsed-as-local-date-time (LocalDateTime/parse formatted-date-time formatter))
(def parsed-as-local-date (LocalDate/parse formatted-date-time formatter))
(def parsed-as-local-time (LocalTime/parse formatted-date-time formatter))

(class parsed-as-local-date-time)
;; => java.time.LocalDateTime
(str parsed-as-local-date-time)
;; => "2023-06-16T17:06:16"
(class parsed-as-local-date)
;; => java.time.LocalDate
(str parsed-as-local-date)
;; => "2023-06-16"
(class parsed-as-local-time)
;; => java.time.LocalTime
(str parsed-as-local-time)
;; => "17:06:16"

;; ---
;; manipulating date and time
;; ---

(def tomorrow (-> today (.plusDays 1)))
(def future-date-time (-> now (.plusHours 2) (.plusMinutes 30)))
(def future-date (-> today (.plusDays 2)))
(def future-time (-> current-time (.plusHours 2) (.plusMinutes 30)))

(str now)
;; => "2023-06-16T17:06:16.866955"
(str tomorrow)
;; => "2023-06-17"
(str future-date-time)
;; => "2023-06-16T19:36:16.866955"
(str future-date)
;; => "2023-06-18"
(str future-time)
;; => "19:36:24.039461"

(def yesterday (-> today (.minusDays 1)))
(def past-date-time (-> now (.minusHours 2) (.minusMinutes 30)))
(def past-date (-> today (.minusDays 2)))
(def past-time (-> current-time (.minusHours 2) (.minusMinutes 30)))

(str now)
;; => "2023-06-16T17:06:16.866955"
(str yesterday)
;; => "2023-06-15"
(str past-date-time)
;; => "2023-06-16T14:36:16.866955"
(str past-date)
;; => "2023-06-14"
(str past-time)
;; => "14:36:24.039461"

;; ---
;; Comparing two times
;; ---

(-> today (.compareTo tomorrow))
;; => -1
(-> today (.compareTo yesterday))
;; => 1
(-> tomorrow (.compareTo yesterday))
;; => 2

(-> future-date (.compareTo past-date))
;; => 4
(-> future-date-time (.compareTo past-date-time))
;; => 1
(-> future-time (.compareTo past-time))
;; => 1

;; ---
;; Working with timezone
;; ---

(def zone-id (java.time.ZoneId/of "America/Sao_Paulo"))
(def zone-offset (java.time.ZoneOffset/ofHours -3))
(def zone-offset-id (java.time.ZoneOffset/ofHoursMinutesSeconds -3 0 0))