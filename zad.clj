
(def myatom (atom 1.0))
(defn atm [x]
  (reset! myatom (* @myatom x)) @myatom)

(defn prop [propose, precision]
  (def result (atom (- propose precision))) @result)

(defn setatom [](reset! myatom 1))
(defn Ex [pow]
  (atm pow)
  (loop [x pow]
    (when (> x 0)
      (when (< x 130)
        (atm (- pow 1))
        ;(println @myatom)
        (println @myatom)
        )(recur (- x 1))))(atm -1))
; the root n nth
;define atom res
(def result (atom 1))
;define propose power of root
(def propose (atom 1))
;reset value atom's
(defn reset_res []
  (reset! result 1))


;define test power
(defn power [pow, res]
  (reset_res)
  (loop [x pow]
    (when (> x 0)
      (reset! result (* @result res))
      (recur (- x 1))
      )
    ) )
;define the n-th root of x
(defn thenrootofx [basis,pow, prec]
  (loop [x (- basis prec)]
    (when (> x 0)
      (power pow x)
      (if (>= @result basis)
        (if (<= @result (+ basis 1))
          (reset! propose x)
          ))
      (if (== @result basis)
        (reset! propose x))
      (recur (- x prec))
      ))@propose)
;Fib
(defn fib [n]
  (case n
    0N 0N
    1N 1N
    (+ (fib (- n 1))
       (fib (- n 2)))))

(defn fib-seq [n]
  ((fn [a b c seq]
     (cond (= 1 n) [1]
           (= c n) seq
           :else (recur b (+ a b) (inc c) (conj seq (+ a b)))))
    1 1 2 [1 1]))

(defn fibo-recur
  ([n]
    (fibo-recur [0N 1N] n)
    )
  ([xs n]
    (if (<= n (count xs))
      xs
      (let [x' (+ (last xs) (nth xs (- (count xs) 2)))
            xs' (conj xs x')]
        (recur xs' n)))))
;nth root
(defn poweri [n pow]
  (if (zero? n)
    (println "basis is zero")
    (if (zero? pow)
                 1N
                 (* n (poweri n (dec pow))))))

(defn thenroot [basis,pow, prec]
  (loop [x (- basis prec)]
    (when (> x 0)
      (poweri x pow)
      (if (>= (poweri x pow) basis)
        (if (<= (poweri x pow) (+ basis (/ prec prec)))
          (reset! propose x)
          ))
      (if (== @result basis)
        (reset! propose x))
      (recur (- x prec))
      ))@propose)

;test factorial
(defn factorial
  ([n]
   (factorial n 1N))
  ([n acc]
   (if  (= n 0N)   acc
                  (recur (dec n) (* acc  n)))))
;two function with one include and second sqrt first
(defn fun-a [n]
  (inc n))
(defn sqrt-fun-a [a] (* (fun-a a) (fun-a a)))