(ns stacktraces.badges
  (:use [stacktraces.core :only [request] ]))


(defn badges
  "Get the list of badges. See https://api.stackexchange.com/docs/badges.
Site name can be supplied, otherwise defaults to 'stackoverflow'."
  ([& [options]] (request "/badges?site=stackoverflow" options)))

(defn by-ids
  "Get a list of badges by a vector of id's (up to 100).  site can be a string
of the name of sites.  To get a list of sites, see 
  See https://api.stackexchange.com/docs/badges-by-ids for more information"
  ([ids & [options]]
    {:pre [(<= (count ids) 100)]}
    (request (str "/badges/" (apply str (interpose ";" ids))) options)))

(defn by-name
  "Get a list of badges by name. See https://api.stackexchange.com/docs/badges-by-name"
  ([& [options]] (request "/badges/name" options)))

(defn recipients
  "Get a list of badge recipients. See https://api.stackexchange.com/docs/badge-recipients"
  ([& [options]] (request "/badges/recipients" {"site" "stackoverflow"})))

(defn recipients-by-id [ids & [options]]
  "Get a list of badges by recipient ids (up too 100 ids)"
  {:pre [<= (count ids) 100]}
  (request (str "/badges/" (apply str (interpose ";" ids)) "/recipients") options))

(defn by-tag
  "Get badges awarded for specific tags. See https://api.stackexchange.com/docs/badges-by-tag"
  ([& [options]] (request "/badges/tags" {"site" "stackoverflow"})))