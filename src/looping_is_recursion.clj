(ns looping-is-recursion)

(defn power [base exp] (let [h (fn [n result] (if (zero? n)
                                                    result
                                                    (recur (dec n) (* result base))))]
                        (h exp 1)))

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
  ":(")

(defn avg [a-seq]
  -1)

(defn parity [a-seq]
  ":(")

(defn fast-fibo [n]
  ":(")

(defn cut-at-repetition [a-seq]
  [":("])
