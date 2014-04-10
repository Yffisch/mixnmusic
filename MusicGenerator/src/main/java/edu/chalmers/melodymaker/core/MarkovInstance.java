package edu.chalmers.melodymaker.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author David
 */
public class MarkovInstance {

    private int total;
    private final List<Note> history;
    private final HashMap<Note, Integer> following;

    public MarkovInstance(List<Note> history) {
        following = new HashMap<>();
        this.history = history;
    }

    /**
     * Updates the HashMap with a note that follows the current history
     *
     * @param follows
     */
    public void updateMap(Note follows) {
        total++;
        if (!following.containsKey(follows)) {
            following.put(follows, 1);
        } else {
            following.put(follows, following.get(follows) + 1);
        }
    }

    public List<Note> getHistory() {
        return history;
    }

    /**
     * Ineffective and ugly way to calculate fair probabilities. Takes the
     * following notes and fills an array list with each notes percentage*10000
     *
     * @param keyToRemove
     * @return an array list with following notes occurring according to their %
     */
    public List<Note> toProbabilities(Note keyToRemove) {
        Set<Note> keySet = following.keySet();
        List<Note> probList = new ArrayList<>();
        for (Note key : keySet) {
            if (!key.toString().equals(keyToRemove.toString())) {
                double value = (float) following.get(key) / total;
                value *= 10000;
                while (value > 0) {
                    probList.add(key);
                    value--;
                }
            }
        }
        return probList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The sequence \"");
        for(Note note : getHistory()){
            sb.append(note.toString());
        }
        sb.append("\" has ");
        sb.append(total);
        sb.append(" following notes spread over ");
        sb.append(following.keySet().size());
        sb.append(" unique instances\n");
        return sb.toString();
    }
}