(ns stacktraces.core
  (:require [clj-http.client :as http]
            [cheshire.core :as json]
            [stacktraces.helpers :as helper]))

;; I'm not letting it throw exceptions, which I know I should, but I
;; don't know how to wrap it properly (yet).  This is a TODO
(def default-http-params {:throw-exceptions false :ignore-unknown-host? true :as :json})

(def url "http://api.stackexchange.com/2.0")

(defn make-get-request
  "make an HTTP GET request agains the API, passing in any optional query params"
  ([api-method] (http/get (str url api-method) default-http-params))
  ([api-method params]
     (http/get (str url api-method "?") (merge default-http-params {:query-params params}))))

(defn get-errors
  "List all of the error types in the StackExchange world.  If passed an err-code, look it up and return the right value for the error explaining what it means."
  ([] (make-get-request "/errors")) 
  ([err-code] (make-get-request (str url "/errors/" err-code))))

(defn get-sxch-sites
  "Get a list of the StackExchange sites."
  ([] (make-get-request "/sites"))
  ([opts] (make-get-request "/sites" opts))
  ([page per-page] (make-get-request "/sites" {:page page :pagesize per-page})))

(defn site-info [site-name]
  "Get the Site info"
  (make-get-request "info" {:site site-name}))


