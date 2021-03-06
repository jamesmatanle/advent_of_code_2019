(ns day03-test
  (:require [day03 :as sut]
            [clojure.test :as t]))

#_
(sut/matches #{[0 0] [0 1] [0 2]} #{[2 1] [1 1] [0 1] [0 2]})

#_
(-> "R8,U5,L5,D3"
    (sut/parse)
    (first)
    (sut/all-coordinates))
;; => ([0 0] [1 0] [2 0] [3 0] [4 0] [5 0] [6 0] [7 0] [8 0] [8 1] [8 2] [8 3] [8 4] [8 5] [7 5] [6 5] [5 5] [4 5] [3 5] [3 4] [3 3] [3 2])

#_
(sut/part1 "R75,D30,R83,U83,L12,D49,R71,U7,L72
U62,R66,U55,R34,D71,R55,D58,R83") ; => 159

#_
(sut/part1 "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51
U98,R91,D20,R16,D67,R40,U7,R15,U6,R7") ; => 135


#_
(sut/part2 "R8,U5,L5,D3
U7,R6,D4,L4") ; => 30

#_
(sut/part2 "R75,D30,R83,U83,L12,D49,R71,U7,L72
U62,R66,U55,R34,D71,R55,D58,R83") ; => 610 steps

#_
(sut/part2 "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51
U98,R91,D20,R16,D67,R40,U7,R15,U6,R7") ; => 410 steps

#_
(sut/convert [[0 1] [0 2] [0 1]])

#_
(sut/intersection-delays {[0 1] 1 [0 2] 3}
                         {[0 1] 2 [1 1] 2 [0 2] 5})
