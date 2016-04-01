(ns ring-ttl-session.performance
  (:require [ring.middleware.session.store :refer :all]
            [ring.middleware.session.memory :refer [memory-store]]
            [ring-ttl-session.core :refer [ttl-memory-store]]
            [criterium.core :refer [bench quick-bench]]))

(defn check-nonexistent-read []
  (let [ttl (ttl-memory-store 10)
        mem (memory-store)]
    (quick-bench (read-session ttl "nonexistent"))
    (quick-bench (read-session mem "nonexistent"))))

(defn check-session-read []
  (let [ttl (ttl-memory-store 10)
        mem (memory-store)
        data {:foo "bar"}
        ttl-key (write-session ttl nil data)
        mem-key (write-session mem nil data)]
    (quick-bench (read-session ttl ttl-key))
    (quick-bench (read-session mem mem-key))))

(defn check-session-create []
  (let [ttl (ttl-memory-store 10)
        mem (memory-store)
        data {:foo "bar"}]
    (quick-bench (write-session ttl nil data))
    (quick-bench (write-session mem nil data))))
