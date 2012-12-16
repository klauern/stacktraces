(defproject com.klauer/stacktraces "0.1.0"
  :description "http REST client for the v2.0 StackExchange API (http://api.stackoverflow.com)"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [clj-http "0.6.2"]
                 [cheshire "5.0.1"]
                 [midje "1.5-alpha2" :scope "test"]
                 [com.stuartsierra/lazytest "1.2.3" :scope "test"]
                 ]
  :repositories {"stuart" "http://stuartsierra.com/maven2"}
  :plugins [[lein-midje "2.0.1"]
            [codox "0.6.1"]])
