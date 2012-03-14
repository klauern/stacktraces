(ns stacktraces.comments
  (:use [stacktraces.core :only [request]])
  )

(defn comments
  "Retrieve comments. See https://api.stackexchange.com/docs/comments.  Default site is
   Stackoverflow, but can be supplied as a string, e.g. \"superuser\""
  ([] (request "/comments" {"site" "stackoverflow"}))
  ([site] (request "/comments" {"site" site})))

(defn by-id [ids]
  "Retrieve comments by id (up to 100). See https://api.stackexchange.com/docs/comments-by-ids
  "
  {:pre [<= (count ids)]}
  (request "/comments/" (apply str (interpose ";" ids))))


