(ns advent.core
  (:require
    [clojure.java.io :as io]
    )
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn slurpee [filename]
    (slurp (io/resource filename)))

(comment
  (println ) (slurpee "7.txt")
  )
