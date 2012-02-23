(ns stacktraces.helpers)

(defn map-params [params]
  "maps the keyword-value pair to a query param like \"name=me&age=29\""
  ;; This is where I figure out the Clojure way of mapping the '=' sign
  ;; between a key and value, and then somehow magically append the '&' to
  ;; everything but the last element.
  ;; No great ideas here, but I'm thinking calling (reduce) would be a
  ;; start, or some looping/recursion scheme.  I don't know how to use
  ;; reduce over a map, however, to get the key and value, so that's a
  ;; bit of a stretch to figure out.
  )