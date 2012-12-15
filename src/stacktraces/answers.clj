(ns stacktraces.answers
  (:use [stacktraces.core :only [request]]))


;; https://api.stackexchange.com/docs/answers

(defn answers
  "See https://api.stackexchange.com/docs/answers"
  ([& [options]] (request "/answers" options)))

;; need to find an abstraction for filtering that won't make every
;; method take a filter.  Something like defpartial? not sure.
(defn answers-with-ids
  [ids & [options]]
  "Given a collection of id's to pull answers for the list of id's (up to 100)"
  {:pre [(<= (count ids) 100)]}
  (request (str
             "/answers/"
             (apply str (interpose ";" ids))) options))


(defn answers-with-comments
  [ids comments & [options]]
  "Given a collection of ids, get the comments for the answer ids"
  {:pre [(<= (count ids) 100)]}
  (request (str
             "/answers/"
             (apply str (interpose ";" ids))
             "/comments") options))

