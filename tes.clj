
(defn factorial [x]
  (with-local-vars [acc 1, cnt x]
    (while (<= @cnt 3)
      (var-set acc (* x @cnt))
      (var-set cnt (dec @cnt))
      (println "test"))
    @acc
    ))
