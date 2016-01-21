(ns advent.2
  (:require
    [clojure.string :as string]
    ))

(defn get-input [path]
  (string/split-lines (slurp path)))

(defn area-for-box [[l w h]]
  (let [side-1 (* l w)
        side-2 (* l h)
        side-3 (* w h)
        extra (min side-1 side-2 side-3)]
    (+ (* 2 side-1) (* 2 side-2) (* 2 side-3) extra)))

(defn ribbon-for-box [[l w h]]
  (+ (min (+ l l h h)
          (+ l l w w)
          (+ w w h h))
     (* l w h)))

(defn get-area [input]
  (reduce (fn [sum item]
              (+ sum (area-for-box (map read-string (string/split item #"x"))))) 0 input))

(defn get-ribbon [input]
  (reduce (fn [sum item]
              (+ sum (ribbon-for-box (map read-string (string/split item #"x"))))) 0 input))


(defn go [path]
    (let [input (get-input path)
          part-1 (get-area input)
          part-2 (get-ribbon input)]
      (println part-1)
      (println part-2)))
(comment
  (def path "/Users/ericmartin/Git/advent/resources/2.txt" )
  (go path)
  (reduce (fn [sum v] (+ sum (* 2 v))) 0 [1 2])
  (remove (fn [x] (= 4 x)) '(1 2 3 4) )
  (println "dims" [1 2 3 4])
)
