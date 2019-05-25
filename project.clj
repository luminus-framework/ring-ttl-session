(defproject luminus/ring-ttl-session "0.3.3"
  :description "Provides an implementation of an in-memory ring's SessionStore with
               TTL."
  :url "https://github.com/luminus-framework/ring-ttl-session"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0-RC1"]
                 [ring/ring-core "1.4.0"]
                 [expiring-map "0.1.9"]]
  :profiles {:dev {:global-vars {*warn-on-reflection* true}}}
  :aliases {"test" ["test" ":only" "ring-ttl-session.core-test"]}
  )
