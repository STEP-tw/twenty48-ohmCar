(ns twenty48.core
  (:gen-class))

(def remove-zeros (partial remove zero?))

(def apply-addition (partial map (partial apply +)))

(def combinations (comp
                          (partial mapcat (partial partition-all 2))
                          (partial partition-by identity)))

(def add-consecutive-equals (comp apply-addition combinations))

(def add-subordinate-zeros (comp (partial take 4) (partial flatten) (partial conj (repeat 4 0))))

(def move-left (comp add-subordinate-zeros add-consecutive-equals remove-zeros))

(def invert-grid (partial apply map vector))

; -----------------------------------------------------------------------------------------------------------------------

(def move-grid-left
  "Moves an entire grid to the left"
  (partial map move-left))

(def move-grid-right
  "Moves an entire grid to the right"
  (partial map (comp reverse move-left reverse)))

(def move-grid-down
  "Moves an entire grid down"
  (comp invert-grid move-grid-right invert-grid))

(def move-grid-up
  "Moves an entire grid up"
  (comp invert-grid move-grid-left invert-grid))

; -----------------------------------------------------------------------------------------------------------------------
