(ns stacktraces.core
  (:require [clj-http.client :as http]
            [cheshire.core :as json]
            [stacktraces.helpers :as helper]))

;; I'm not letting it throw exceptions, which I know I should, but I
;; don't know how to wrap it properly (yet).  This is a TODO
(def default-http-parms {:throw-exceptions false :ignore-unknown-host? true :as :json})

(def url "http://api.stackexchange.com/2.0")

(defn get-errors 
  ([] (http/get (str url "/errors"))) 
  ([err-code] (http/get (str url "/errors/" err-code) default-http-parms)))

(defn get-sxch-sites 
  ([] (http/get (str url "/sites")))
  ([opts] (http/get ()))
  ([page per-page] (http/get (str url "/sites/" ))))

(defn site-info [site-name]
  (make-get-request "info" {:site site-name}))


(defn make-get-request [api-method params]
  (http/get (str url api-method "?" (helper/map-params params))))