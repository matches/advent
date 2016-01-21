(ns advent.3
  (:require
    [clojure.string :as string]
    ))

(defn count-houses [houses]
  (reduce-kv (fn [sum k v] (+ sum (count v))) 0 houses))

(defn get-present-houses [input houses]
    (loop [path input x 0 y 0 h houses]
      (let [move (first path)
            path (rest path)
            h (update-in h [x y] (fnil inc 0))
            y (if (= move \^) (inc y) (if (= move \v) (dec y) y))
            x (if (= move \>) (inc x) (if (= move \<) (dec x) x))]
        (if (empty? path) h
          (recur path x y h)))))

(defn robot-bullshit [input]
  (let [santa (take-nth 2 input)
        robo-santa (take-nth 2 (rest input))
        santa-results (get-present-houses santa {})
        robo-results (get-present-houses robo-santa santa-results)]
    robo-results))

(defn go [path]
    (let [input (.trim (slurp path))
          part-1 (count-houses (get-present-houses input {}))
         part-2 (count-houses (robot-bullshit input))]
      (println part-1)
      (println part-2)))

(comment
  (def path "/Users/ericmartin/Git/advent/resources/3.txt" )
  (go path)
  (count {1 1 2 2 3 3 4 4 5 4}))
