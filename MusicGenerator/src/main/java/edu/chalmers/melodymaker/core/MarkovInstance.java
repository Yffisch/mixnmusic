package edu.chalmers.melodymaker.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author David
 */
public class MarkovInstance {

    private int total;
    private final String history;
    private final HashMap<String, Integer> following;

    public MarkovInstance(String history) {
        following = new HashMap<>();
        this.history = history;
    }

    /**
     * Updates the HashMap with a note that follows the current history
     *
     * @param follows
     */
    public void updateMap(String follows) {
        total++;
        if (!following.containsKey(follows)) {
            following.put(follows, 1);
        } else {
            following.put(follows, following.get(follows) + 1);
        }
    }

    public String getHistory() {
        return history;
    }

    /**
     * Ineffective and ugly way to calculate fair probabilities. Takes
     * the following notes and fills an array list with each notes
     * percentage*10000
     *
     * @return an array list with following notes occurring according to their %
     */
    public ArrayList<String> toProbabilities() {
        Set<String> keySet = following.keySet();
        ArrayList<String> probList = new ArrayList<>();
        for (String key : keySet) {
            double value = (float) following.get(key) / total;
            value *= 10000;
            while (value > 0) {
                probList.add(key);
                value--;
            }
        }
        return probList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The sequence \"");
        sb.append(getHistory());
        sb.append("\" has ");
        sb.append(total);
        sb.append(" following notes spread over ");
        sb.append(following.keySet().size());
        sb.append(" unique instances\n");
        return sb.toString();
    }
}
