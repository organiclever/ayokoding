(ns date-and-time.core
  (:import java.time.Duration
           java.time.format.DateTimeFormatter
           java.time.LocalDate
           java.time.LocalDateTime
           java.time.LocalTime
           java.time.Period
           java.time.ZonedDateTime
           java.time.ZoneId
           java.time.ZoneOffset))

;; ---
;; Working with LocalTime, LocalDate, LocalDateTime
;; ---

;; get current time and date

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

;; Playing with date and time format

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
;; Date Time manipulation and comparison
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

;; Comparing two temporal

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
;; Duration between two temporal
;; ---

(def duration-datetime (Duration/between
                        (LocalDateTime/now)
                        (-> (LocalDateTime/now) (.plusDays 1) (.plusHours 12))))
(str duration-datetime)
;; => "PT36H0.000017S"
(.toSeconds duration-datetime)
;; => 129600
(.toHours duration-datetime)
;; => 36
(.toDays duration-datetime)
;; => 1

(def duration-date (Period/between
                    (LocalDate/now)
                    (-> (LocalDate/now) (.plusDays 33))))
(str duration-date)
;; => "P1M3D"
(.getDays duration-date)
;; => 3
(.getMonths duration-date)
;; => 1
(.toTotalMonths duration-date)
;; => 1

(def duration-time (Duration/between
                    (LocalTime/now)
                    (-> (LocalTime/now) (.plusHours 36))))
(str duration-time)
;; => "PT12H0.000013S"
(.toSeconds duration-time)
;; => 43200
(.toHours duration-time)
;; => 12
(.toDays duration-time)
;; => 0

;; ---
;; Working with timezone - get current-time
;; ---

;; Get current time with timezone

(def now-with-zone (ZonedDateTime/now))
(class now-with-zone)
;; => java.time.ZonedDateTime
(str now-with-zone)
;; => "2023-06-16T18:12:34.375243+07:00[Asia/Jakarta]"

;; Get current time with timezone in a place

(def now-in-berlin (-> now-with-zone (.withZoneSameInstant (ZoneId/of "Europe/Berlin"))))
(class now-in-berlin)
;; => java.time.ZonedDateTime
(str now-in-berlin)
;; => "2023-06-16T13:12:34.375243+02:00[Europe/Berlin]"

(class (ZoneId/getAvailableZoneIds))
;; => java.util.HashSet
(count (ZoneId/getAvailableZoneIds))
;; => 603
(filter #(.contains % "Jakarta") (ZoneId/getAvailableZoneIds))
;; => ("Asia/Jakarta")

;; ---
;; Working with timezone - manipulation
;; ---

;; Convert to GMT+ something

(def now-in-zone-offset (-> now-with-zone (.withZoneSameInstant (ZoneOffset/ofHours 5))))
(class now-in-zone-offset)
;; => java.time.ZonedDateTime
(str now-in-zone-offset)
;; => "2023-06-16T16:12:34.375243+05:00"

;; Convert to Local

(class (LocalDateTime/from now-in-berlin))
;; => java.time.LocalDateTime
(str (LocalDateTime/from now-in-berlin))
;; => "2023-06-16T13:12:34.375243"
(class (LocalDate/from now-in-berlin))
;; => java.time.LocalDate
(str (LocalDate/from now-in-berlin))
;; => "2023-06-16"
(class (LocalTime/from now-in-berlin))
;; => java.time.LocalTime
(str (LocalTime/from now-in-berlin))
;; => "13:12:34.375243"

(.format (DateTimeFormatter/ofPattern "yyyy-MM-dd HH:mm:ss z") now-with-zone)
;; => "2023-06-16 18:12:34 WIB"
(.format DateTimeFormatter/ISO_LOCAL_DATE now-with-zone)
;; => "2023-06-16"
(.format DateTimeFormatter/ISO_LOCAL_TIME now-with-zone)
;; => "18:12:34.375243"
(try (.format (DateTimeFormatter/ofPattern "yyyy-MM-dd HH:mm:ss z") now)
     (catch Exception e (.getMessage e)))
;; => "Unable to extract ZoneId from temporal 2023-06-16T13:12:34.375243"
