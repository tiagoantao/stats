(ns stats.test-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [stats.test :as t]))


(deftest tests
  (testing "Pearson"
    (is (= (t/pearson [0 1 2] [0 1 2]) 1))
    (is (= (t/pearson [0 1 2 3] [0 1 2 -1]) -0.2))
    (is (= (t/pearson [0 0 1 1] [0 1 0 1]) 0))
    )
  (testing "all-pos"
    (is (= (t/all-pos 0 []) []))
    (is (= (t/all-pos 0 [1 2 2 4]) []))
    (is (= (t/all-pos 1 [1 2 2 4]) [0]))
    (is (= (t/all-pos 2 [1 2 2 4]) [1 2]))
    (is (= (t/all-pos 4 [1 2 2 4]) [3]))
    (is (nil? (t/all-pos 0 '(1 2 2 4))))
    )
  (testing "Rank"
    (is (= (t/rank [0]) '(1)))
    (is (= (t/rank [1 0]) '(2 1)))
    (is (= (t/rank [1 0 0]) '(3 1.5 1.5)))
    )
  )


