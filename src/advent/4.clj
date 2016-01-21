(ns advent.4
  (:require
    [clojure.string :as string]
    ))

(defn md5 [s]
  (let [algorithm (java.security.MessageDigest/getInstance "MD5")
        size (* 2 (.getDigestLength algorithm))
        raw (.digest algorithm (.getBytes s))
        sig (.toString (java.math.BigInteger. 1 raw) 16)
        padding (apply str (repeat (- size (count sig)) "0"))]
    (str padding sig)))

(defn find-hash [input value length]
  (loop [v input n value]
    (let [md5 (md5 (str v n))]
      (if (= (apply str (take length (repeat "0"))) (subs md5 0 length)) n
        (recur v (inc n))))))

(defn go [path]
    (let [input (.trim (slurp path))
          part-1 (find-hash input 1 5)
          part-2 (find-hash input 1 6)]
      (println part-1)
      (println part-2)))
(comment
  (def path "/Users/ericmartin/Git/advent/resources/4.txt" )
  (find-hash "bgvyzdsv" 1)
  (go path)
  (println (apply str (take 3 (repeat "0"))))
)
