(ns day08
  "https://adventofcode.com/2019/day/8"
  (:require [clojure.java.io :as io]))

(defn split-layers
  [size input]
  ((fn g [input]
     (if (seq input)
       (conj (g (drop size input))
             (take size input))
       '()))
   input))

(defn char-count
  [layer char]
  (->> layer
       (filter #{char})
       (count)))

(defn fewest-zero-layer
  [layers]
  (reduce (fn [acc elem]
            (if (< (char-count elem \0)
                   (char-count acc \0))
              elem
              acc))
          (first layers)
          (rest layers)))

(defn answer
  [layer]
  (* (char-count layer \1)
     (char-count layer \2)))

(defn part1
  [input width height]
  (->> input
       (remove #{\newline})
       (split-layers (* width height))
       (fewest-zero-layer)
       (answer)))

#_
(part1 (util/fstr "day08_input.txt") 25 6)
;; => 2318

;;;;;;;;;;;;
;; PART 2
;; first layer in front. precedence: black 0, white 1, transparent 2
;;;;;;;;;;;;

(defn transpose
  [m]
  (apply mapv vector m))

(defn decode-position
  "earlier positions have priority. remove all leading 2s. "
  [chars]
  (->> chars
       (drop-while #{\2})
       (first)))

(defn shape
  [width coll]
  ((fn g [coll]
     (if (seq coll)
       (conj (g (drop width coll))
             (take width coll))
       '()))
   coll))

(defn part2
  [input width height]
  (->> input
       (remove #{\newline})
       (split-layers (* width height))
       (transpose)
       (map decode-position)
       (shape width)
       (mapv (partial interpose \ ))
       (mapv (partial apply str))))

#_
(part2 (util/fstr "day08_input.txt") 25 6)

;; =>
#_
["0 1 1 0 0 1 0 0 1 0 1 1 1 1 0 0 1 1 0 0 1 1 1 0 0"
 "1 0 0 1 0 1 0 0 1 0 1 0 0 0 0 1 0 0 1 0 1 0 0 1 0"
 "1 0 0 1 0 1 1 1 1 0 1 1 1 0 0 1 0 0 0 0 1 1 1 0 0"
 "1 1 1 1 0 1 0 0 1 0 1 0 0 0 0 1 0 0 0 0 1 0 0 1 0"
 "1 0 0 1 0 1 0 0 1 0 1 0 0 0 0 1 0 0 1 0 1 0 0 1 0"
 "1 0 0 1 0 1 0 0 1 0 1 0 0 0 0 0 1 1 0 0 1 1 1 0 0"]

;; => AHFCB
