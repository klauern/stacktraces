(defproject org.clojars.bruz/stacktraces "0.1.0"
  :description "http REST client for the v2.0 StackExchange API (http://api.stackoverflow.com)"
  :url "http://github.com/bruz/stacktraces"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [clj-http "0.3.3"]
                 [cheshire "2.2.0"]]
  :dev-dependencies [[marginalia "0.7.0-SNAPSHOT"]
                     [midje "1.3.1" :exclusions [org.clojure/clojure]]
                     [lein-midje "1.0.8"]])
