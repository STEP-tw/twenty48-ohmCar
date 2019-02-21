(ns twenty48.core
  (:gen-class))

(def remove-zeros (partial remove zero?))

(def apply-addition (partial map (partial apply +)))

(def combinations (comp
                          (partial mapcat (partial partition-all 2))
                          (partial partition-by identity)))

(def add-consecutive-equals (comp apply-addition combinations))

(defn add-subordinate-zeros [row] (take 4 (concat row (repeat 0))))

(def move-left (comp add-subordinate-zeros add-consecutive-equals remove-zeros))

(def invert-grid (partial apply map vector))

; -----------------------------------------------------------------------------------------------------------------------

(def move-grid-left
  "Moves an entire grid to the left"
  (partial map move-left))

(def move-grid-right
  "Moves an entire grid to the right"
  (partial map (comp reverse move-left reverse)))

(defn move-grid-down
  "Moves an entire grid down"
  [grid]
  grid)

(def move-grid-up
  "Moves an entire grid up"
  (comp invert-grid move-grid-left invert-grid))

; -----------------------------------------------------------------------------------------------------------------------
