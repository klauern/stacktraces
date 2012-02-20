(ns stacktraces.core
  (:require [clj-http.client :as http]
            [cheshire.core :as json]))

(def default-http-parms {:throw-exceptions false :ignore-unknown-host? true :as :json})

(def url "http://api.stackexchange.com/2.0")

(defn get-errors 
  ([] (http/get (str url "/errors"))) 
  ([err-code] (http/get (str url "/errors/" err-code) default-http-parms)))