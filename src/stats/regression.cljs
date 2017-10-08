(ns stats.regression
  "Regression analysis
  "
  {:author "Tiago Antao"}
  (:require [stats.stats :refer [mean std]]
            [stats.test :refer [pearson]])
  )

(defn sse
  "Sum of squared errors of prediction"
  [y ye]
  (reduce + (map #(.pow js/Math (- %1 %2) 2) y ye ))
  )

(defn linear [x y]
  (let [mx (mean x)
        my (mean y)
        r (pearson x y)
        b (* r (/ (std x) (std y)))
        a (- (mean y) (* b (mean x)))
        mx2 (mean (map #(* % %) x))
        my2 (mean (map #(* % %) y))
        mxy (mean (map #(* %1 %2) x y))
        rxy (/ (- mxy (* mx my))
               (.sqrt js/Math (* (- mx2 (* mx mx))
                                 (- my2 (* my my)))))
        sse (sse y (map #(+ (*) b) x))]
    {:a a :b b :sse sse :rxy rxy}
  ))

(prn 1111 (mean [0 1]))
(prn 1111 (linear [0 1] [0 1]))

