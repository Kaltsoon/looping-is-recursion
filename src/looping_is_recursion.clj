(ns looping-is-recursion)

(defn power [base exp] (let [help (fn [i result] (if (zero? i)
                                                    result
                                                    (recur (dec i) (* result base))))]
                        (help exp 1)))

(defn last-element [a-seq] (if (or (= 1 (count a-seq)) (= 0 (count a-seq)))
                            (first a-seq)
                            (recur (rest a-seq))))

(defn seq= [seq1 seq2] (if (or (empty? seq1) (empty? seq2))
                          (if (and (empty? seq1) (empty? seq2))
                            true
                            false)
                          (if (= (first seq1) (first seq2))
                            (recur (rest seq1) (rest seq2))
                            false)))

(defn find-first-index [pred a-seq]
(loop [acc 0 seq a-seq]
  (cond
  (empty? seq)
    nil
  (pred (first seq))
    acc
  :else
  (recur (inc acc) (rest seq)))))

(defn avg [a-seq]
  (loop [acc 0 sum 0 seq a-seq]
    (cond
    (empty? seq)
      (/ sum acc)
    :else
    (recur (inc acc) (+ sum (first seq)) (rest seq)))))

(defn toggle [a-set elem]
  (if (contains? a-set elem)
    (disj a-set elem)
    (conj a-set elem)))

(defn parity [a-seq]
  (loop [l-seq a-seq
        b-set #{}]
    (if (empty? l-seq)
      b-set
      (recur (rest l-seq) (toggle b-set (first l-seq))))))

(defn fast-fibo [n]
  (loop [acc 0
        fN 0
        fN1 1]
    (if (== acc n)
      fN
      (recur (inc acc) (+ fN fN1) fN))))

(defn cut-at-repetition [a-seq]
  (loop [loop-seq a-seq
        a-set #{}
        return-seq ()]
    (if (empty? loop-seq)
      (reverse return-seq)
    (if (contains? a-set (first loop-seq))
      (reverse return-seq)
      (recur (rest loop-seq) (conj a-set (first loop-seq)) (conj return-seq (first loop-seq)))))))
