(defn average [a b]
  (/ (+ a b) 2))

(defn abs[x]
  (if (< x 0) (- x) x))

(defn make-good-enough? [n]
  (fn [guess] (< (abs (- n (* guess guess))) 1e-6)))

(defn make-improver [n]
  (fn [guess] (average guess (/ n guess))))

(defn iterative-improve [x improve good?]
  (if (good? x) x
                (iterative-improve (improve x) improve good?)))

(defn square-root [n]
  (iterative-improve 1.0 (make-improver n) (make-good-enough? n)))
(defn square [x]
  (fn [x] (* x x))
  )