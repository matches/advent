(ns advent.7
  (:require
    [clojure.string :as string]
    ))

(defn get-input [path]
  (string/split-lines (slurp path)))

(defn parse-graph [input]
  (into {}
    (map (fn [item]
      (cond
        (= 3 (count item)) [(get item 2) (read-string (get item 1))] ; 123 -> x
        (= 4 (count item)) [(get item 3) {:arg1 (get item 2) :op (get item 1)}] ; NOT a -> b
        (= 5 (count item)) [(get item 4) {:arg1 (get item 1) :op (get item 2) :arg2 (get item 3)}] ; a OR|AND|etc b -> c
        ))
         input)))
(defn evaluate-wires [values expr]
  (into {} (for (fn [[k v] m]
         (case (:op e)
           "NOT" 
           "OR" (if )
           )
         ) expr))
  )

(defn eval-graph [graph]
  (loop [g graph]
    (let [values (filter integer? g)
          expr (filter map? graph)]
      (if (empty? expr) graph
        (recur (evaluate-wires values expr))))))

(defn go [path]
  (let [input (get-input path)
        split-input (vec (map #(vec ( remove nil? (re-find #"^(\d+) -> (\w+)|^(\w+) ?(NOT|LSHIFT|RSHIFT|AND|OR)? (\w+) -> (\w+)$" %))) input))
        parsed (parse-graph split-input)]
    (eval-graph parsed)))

(comment
  (get-input)
  (remove nil? ["a" "b" "c" nil nil])
  (filter #(contains? % :v) {"a" {}})
  (go "/Users/ericmartin/Git/advent/resources/7tiny.txt")
  )
