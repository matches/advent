(ns advent.6
  (:require
    [clojure.string :as string]
    ))

(defn get-input [path]
  (string/split-lines (slurp path)))

(defn generate-lights []
  ; I feel like this is a hack
  (vec (map (fn [_] (vec (replicate 10 0))) (range 10))))

(defn apply-command [func grid sx sy ex ey]

)

(defn exec-command [string grid]
  (let [[command sx sy ex ey] (rest (re-find #"(toggle|turn off|turn on) (\d+),(\d+) through (\d+),(\d+)" string))]
    (cond (= command "turn off") (apply-command (fn [] 0) grid sx sy ex ey)
          (= command "turn on" (apply-command (fn [] 1) grid sx sy ex ey))
          (= command "toggle" (apply-command (fn [n] (if (= n 1) 0 1)) grid sx sy ex ey)))))

(defn follow-instructions [input lights]
  (loop [in input grid lights]
    (if (empty? in) grid
      (recur (rest in) (exec-command (first in) grid)))))

(defn go [path]
  (let [input (get-input path)
        lights (generate-lights)]
    (follow-instructions input lights)))

(comment
  (def path "/Users/ericmartin/Git/advent/resources/6.txt" )
  (go path)
  (print (generate-lights))
  (rest (re-find #"(toggle|turn off|turn on) (\d+),(\d+) through (\d+),(\d+)" "turn off 1,2 through 3,4"))
  (print (into [] (replicate 5 0)))
  (def a #(-> 1))
  (a)
)

