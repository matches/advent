(ns advent.5
  (:require
    [clojure.string :as string]
    ))

(defn get-input [path]
  (string/split-lines (slurp path)))

(defn check-rules [string]
  (let [vowels? (>= (count (re-seq #"([aeiou])" string)) 3)
        repeat? (some? (re-find #"(.)\1" string))
        no-taboo? (nil? (re-find #"(ab|cd|pq|xy)" string))]
    (and vowels? repeat? no-taboo?)))

(defn check-new-rules [string]
 (let [repeat? (some? (re-find #"(..).*\1" string))
       sandwich? (some? (re-find #"(.).\1" string))]
   (and repeat? sandwich?)))

(defn go [path]
  (let [input (get-input path)]
    (println (reduce (fn [count i] (if (check-rules i) (inc count) count)) 0 input))
    (println  (reduce (fn [count i] (if (check-new-rules i) (inc count) count)) 0 input))
    ))

(comment
  (def path "/Users/ericmartin/Git/advent/resources/5.txt" )
  (def single (first (get-input path)))
  (check-rules "urrvucyrzzzooxhx")
  (check-new-rules "xxyx")
  (go path)
)

