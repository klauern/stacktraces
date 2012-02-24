(ns stacktraces.comments
  (:use [stacktraces.core :only [request]])
  )

(defn comments []
  "Retrieve comments. See https://api.stackexchange.com/docs/comments
  "
  (request "/comments"))

(defn by-id [ids]
  "Retrieve comments by id (up to 100). See https://api.stackexchange.com/docs/comments-by-ids
  "
  {:pre [<= (count ids)]}
  (request "/comments/" (apply str (interpose "," ids))))


