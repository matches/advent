(ns advent.1
  (:require
    [clojure.string :as string]
    ))

(defn go [path]
    (let [input (.trim (slurp path))
          part-1 (get-final-floor input 0)
          part-2 (get-first-basement input 0)]
      (println part-1)
      (println part-2)))

(defn get-final-floor [in floor]
  (loop [i in f floor]
    (let [c (subs i 0 1)
          r (subs i 1)
          nf (cond
              (= c "(") (+ f 1)
              (= c ")") (- f 1))]
      (if (empty? r) nf
        (recur r nf)))))

(defn get-first-basement [in floor]
  (loop [i in f floor num 0]
    (let [c (subs i 0 1)
          r (subs i 1)
          num (inc num)
          nf (cond
              (= c "(") (+ f 1)
              (= c ")") (- f 1))]
      (if (= -1 nf) num
        (recur r nf num)))))

(comment
  (def path "/Users/ericmartin/Git/advent/resources/1.txt" )
  (get-final-floor (slurp path) 1)
  (go path)
  (empty? (subs "1" 1))
    )
