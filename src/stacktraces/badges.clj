(ns stacktraces.badges
  (:use [stacktraces.core :only [request] ]))


(defn badges
  "Get the list of badges. See https://api.stackexchange.com/docs/badges.
Site name can be supplied, otherwise defaults to 'stackoverflow'."
  ([] (request "/badges?site=stackoverflow"))
  ([site] (request (str "/badges?site=" site))))

(defn by-ids
  "Get a list of badges by a vector of id's (up to 100).  site can be a string
of the name of sites.  To get a list of sites, see 
  See https://api.stackexchange.com/docs/badges-by-ids for more information"
  ([ids]
    {:pre [(<= (count ids) 100)]}
    (request (str "/badges/" (apply str (interpose ";" ids))) {"site" "stackoverflow"}))
  ([ids site] 
    {:pre [(<= (count ids) 100)]}
    (request (str "/badges/" (apply str (interpose ";" ids))) {"site" site})))

(defn by-name
  "Get a list of badges by name. See https://api.stackexchange.com/docs/badges-by-name"
  ([] (request "/badges/name" {"site" "stackoverflow"}))
  ([site] (request "/badges/name" {"site" site})))

(defn recipients
  "Get a list of badge recipients. See https://api.stackexchange.com/docs/badge-recipients"
  ([] (request "/badges/recipients" {"site" "stackoverflow"}))
  ([site] (request "/badges/recipients" {"site" site})))

(defn recipients-by-id [ids]
  "Get a list of badges by recipient ids (up too 100 ids)"
  {:pre [<= (count ids) 100]}
  (request (str "/badges/" (apply str (interpose ";" ids)) "/recipients")))

(defn by-tag
  "Get badges awarded for specific tags. See https://api.stackexchange.com/docs/badges-by-tag"
  ([] (request "/badges/tags" {"site" "stackoverflow"}))
  ([site] (request "/badges/tags" {"site" site})))