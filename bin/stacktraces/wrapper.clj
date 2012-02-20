(ns stacktraces.wrapper)

(defrecord ResponseWrapper [backoff error_id error_message error_name 
                            has_more items page page_size quota_max
                            quota_remaining total type])