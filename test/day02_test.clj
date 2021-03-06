(ns day02-test
  (:require [day02 :as sut]
            [clojure.test :as t]))

(sut/part1 "1,0,0,0,99") ;; => 2,0,0,0,99 (1 + 1 = 2).
(sut/part1 "2,3,0,3,99") ;; => 2,3,0,6,99 (3 * 2 = 6).
(sut/part1 "2,4,4,5,99,0") ;; => 2,4,4,5,99,9801 (99 * 99 = 9801).
(sut/part1 "1,1,1,4,99,5,6,0,99") ;; => 30,1,1,4,2,5,6,0,99.
