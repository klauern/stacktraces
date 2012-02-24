(ns stacktraces.badges
  (:use [stacktraces.core :only [request] ]))


(defn badges []
  "Get the list of badges. See https://api.stackexchange.com/docs/badges"
  (request "/badges"))

(defn by-ids [ids]
  "Get a list of badges by a vector of id's (up to 100)
  See https://api.stackexchange.com/docs/badges-by-ids for more information"
  {:pre [<= (count ids) 100]}
  (request "/badges/" (apply str (interpose "," ids))))

(defn by-name []
  "Get a list of badges by name. See https://api.stackexchange.com/docs/badges-by-name"
  (request "/badges/name"))

(defn recipients []
  "Get a list of badge recipients. See https://api.stackexchange.com/docs/badge-recipients"
  (request "/badges/recipients"))

(defn recipients-by-id [ids]
  "Get a list of badges by recipient ids (up too 100 ids)"
  {:pre [<= (count ids) 100]}
  (request (str "/badges/" (apply str (interpose "," ids)) "/recipients")))

(defn by-tag []
  "Get badges awarded for specific tags. See https://api.stackexchange.com/docs/badges-by-tag"
  (request "/badges/tag"))


