(ns stacktraces.core
  (:require [clj-http.client :as http]
            [cheshire.core :as json]
            [stacktraces.helpers :as helper]))

(def request-quota-left (atom 0))

;; I'm not letting it throw exceptions, which I know I should, but I
;; don't know how to wrap it properly (yet).  This is a TODO
(def default-http-params {:throw-exceptions false :ignore-unknown-host? true :as :json})

(def url "http://api.stackexchange.com/2.0")

(defn request
  "make an HTTP GET request agains the API, passing in any optional query params"
  ([api-method] 
    (http/get (str url api-method) default-http-params))
  ([api-method params]
     (http/get (str url api-method "?") (merge default-http-params {:query-params params}))))

(defn get-errors
  "List all of the error types in the StackExchange world.  If passed an err-code, look it up and return the right value for the error explaining what it means."
  ([] (request "/errors")) 
  ([err-code] (request (str url "/errors/" err-code))))

(defn get-sxch-sites
  "Get a list of the StackExchange sites."
  ([] (request "/sites"))
  ([opts] (request "/sites" opts))
  ([page per-page] (request "/sites" {:page page :pagesize per-page})))

(defn site-info [& site-name]
  "Get the Site info"
  ([site-name] request "/info" {"site" site-name}))

(defn get-sxch-names []
  "Gets a seq of StackExchange site names"
  (map :name (:items (:body (get-sxch-sites)))))

(defn get-sxch-api-names []
  "Gets a seq of StackExchange API site names.  This is
   for use when calling the many sites that require a site=? tag"
  (map :api_site_parameter (:items (:body (get-sxch-sites)))))

;; Have to find a better way to do this, but don't know how to 
;; wrap an atom post-setting in the 'request call.
;; Currently, this is a hack by way of actually wasting an HTTP request,
;; and thereby decreasing your quota just by asking.  This is available
;; on every request, but need to find out how to store the result of
;; a request with this in it on every request.
(defn quota-remaining []
  "Gets the quota remaining"
  (:quota_remaining (:body (request "/info" {"site" "stackoverflow"}))))