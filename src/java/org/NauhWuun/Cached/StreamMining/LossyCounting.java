package org.NauhWuun.Cached.StreamMining;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LossyCounting 
{
    private double fraction;
    private double error;

    private long cardinality;
    private long bucket;

    private Map<Object, Counter> heavyHitters;

    public LossyCounting(double fraction, double error) {
        this.fraction       = fraction;
        this.error          = error;

        this.cardinality    = 0;
        this.bucket         = 0;

        this.heavyHitters   = new HashMap<Object, Counter>();
    }

    public void addObject(Object o) {
        cardinality += 1;

        if (heavyHitters.containsKey(o)) {
            heavyHitters.get(o).updateLowerBound(1);
        } else {
            heavyHitters.put(o, new Counter(1, bucket));
        }

        if (cardinality % (long) Math.ceil(1 / error) == 0) {
            bucket += 1;
            updateHeavyHitters();
        }
    }

    public void updateHeavyHitters() {
        heavyHitters.entrySet().removeIf(o -> o.getValue().getUpperBound() < bucket);
    }

    public void merge(LossyCounting toMerge) throws Exception {
        try {
            if (this.fraction != toMerge.fraction) {
                throw new Exception("Both heavy hitter structures must be identical");
            }

            this.cardinality += toMerge.cardinality;
            this.bucket = (long) Math.floor(cardinality * error);

            for (Map.Entry<Object, Counter> entry : toMerge.heavyHitters.entrySet()) {
                Counter counter = this.heavyHitters.get(entry.getKey());

                if (counter == null) {
                    this.heavyHitters.put(entry.getKey(), entry.getValue());
                }
                else
                {
                    Counter mergingCounter = entry.getValue();

                    this.heavyHitters.put(entry.getKey(), new Counter(
                            mergingCounter.lowerBound + counter.lowerBound,
                            mergingCounter.frequencyError
                                    + counter.frequencyError));
                }
            }
            updateHeavyHitters();
        } catch (ClassCastException ex) {
            throw new Exception("Both heavy hitter structures must be identical");
        }
    }

    public HashMap<Object, Long> getHeavyHitters() {
        HashMap<Object, Long> heavyHitterLowerBounds = new HashMap<Object, Long>();
        long minFrequency = (long) Math.ceil(cardinality * (fraction - error));

        for (Map.Entry<Object, Counter> entry : heavyHitters.entrySet()) {
            if (entry.getValue().lowerBound >= minFrequency) {
                heavyHitterLowerBounds.put(entry.getKey(),
                        entry.getValue().lowerBound);
            }
        }

        return heavyHitterLowerBounds;
    }

    @Override
    public String toString() {
        String out = "";
        long minFrequency = (long) Math.ceil(cardinality * (fraction - error));

        for (Map.Entry<Object, Counter> entry : heavyHitters.entrySet()) {
            if (entry.getValue().lowerBound >= minFrequency) {
                out += entry.getKey().toString() + " -> lower bound " + entry.getValue().lowerBound + "\n";
            }
        }

        return out;
    }

    private class Counter
    {
        long lowerBound;
        long frequencyError;

        private Counter(long lowerBound, long frequencyError) {
            this.lowerBound = lowerBound;
            this.frequencyError = frequencyError;
        }

        private void updateLowerBound(long count) {
            lowerBound += count;
        }

        private long getUpperBound() {
            return lowerBound + frequencyError;
        }
    }
}
