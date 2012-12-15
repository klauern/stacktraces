(ns stacktraces.tags
  (:use [stacktraces.core :only [request]]))

;; https://api.stackexchange.com/docs/tags

(defn tags [& [options]]
  "See https://api.stackexchange.com/docs/tags"
  (request (str "/tags") options))

(defn by-name [tags & [options]]
  "See https://api.stackexchange.com/docs/tags-by-name"
  (request (str "/tags/" tags "/info") options))

(defn moderator-only [& [options]]
  "See https://api.stackexchange.com/docs/moderator-only-tags"
  (request (str "/tags/moderator-only") options))

(defn required [& [options]]
  "See https://api.stackexchange.com/docs/required-tags"
  (request (str "/tags/required") options))

(defn synonyms [& [options]]
  "See https://api.stackexchange.com/docs/tag-synonyms"
  (request (str "/tags/synonyms") options))

(defn faqs-by [tags & [options]]
  "See https://api.stackexchange.com/docs/faqs-by-tags"
  (request (str "/tags/" tags "/faq") options))

(defn related [tags & [options]]
  "See https://api.stackexchange.com/docs/related-tags"
  (request (str "/tags/" tags "/related") options))

(defn synonyms-by [tags & [options]]
  "See https://api.stackexchange.com/docs/synonyms-by-tags"
  (request (str "/tags/" tags "/synonyms") options))

(defn top-answers-on [tag period & [options]]
  "See https://api.stackexchange.com/docs/top-answerers-on-tags"
  (request (str "/tags/" tag "/top-answers/" period) options))

(defn top-askers-on [tag period & [options]]
  "See https://api.stackexchange.com/docs/top-askers-on-tags"
  (request (str "/tags/" tags "/top-askers/" period) options))

(defn wikis-by [tags & [options]]
  "See https://api.stackexchange.com/docs/wikis-by-tags"
  (request (str "/tags/" tags "/wikis") options))
