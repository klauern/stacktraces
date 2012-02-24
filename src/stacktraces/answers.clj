(ns stacktraces.answers
  (:require [stacktraces.core :as core]))


;; https://api.stackexchange.com/docs/answers

(defn answers
  "See https://api.stackexchange.com/docs/answers"
  ([] core/request "/answers"))

;; need to find an abstraction for filtering that won't make every
;; method take a filter.  Something like defpartial? not sure.
(defn answers-with-ids [ids]
  "Given a collection of id's to pull answers for the list of id's (up to 100)"
  {:pre [(<= (count ids) 100)]}
  (core/request "/answers/" (apply str (interpose "," ids))))


(defn answers-with-comments [ids comments]
  "Given a collection of ids, get the comments for the answer ids"
  {:pre [(<= (count ids) 100)]}
  (core/request (str
                 "/answers/"
                 (apply str (interpose "," ids))
                 "/comments")))

