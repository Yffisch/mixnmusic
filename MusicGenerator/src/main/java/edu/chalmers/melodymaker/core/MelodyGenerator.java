package edu.chalmers.melodymaker.core;

import edu.chalmers.melodymaker.io.MelodyLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Yff
 */
public class MelodyGenerator {

    private final int MAX;
    private final int MIN;
    private final int ORDER;
    private final String end = "EOM";
    private HashMap<String, MarkovInstance> startTable; //ändra från String till note eller dyl.
    private HashMap<String, MarkovInstance> markovTable; //ändra från String till note eller dyl.

    public MelodyGenerator(int order, int minNrOfNotes, int maxNrOfNotes, String genre, String length, String signature) { //Genre/Length/Signature
        this.MIN = minNrOfNotes;
        this.MAX = maxNrOfNotes;
        if (order < 1) {
            System.err.println("Order has to be at least 1");
        }
        this.ORDER = order;
        initTables();
        ArrayList<Melody> melodies = loadABC(genre, length, signature);
        learnABC(melodies);
    }

    /**
     * Initiate the HashMaps
     */
    private void initTables() {
        startTable = new HashMap<>();
        markovTable = new HashMap<>();
    }

    /**
     * Load the files via MelodyLoader to get a list of Melodies
     *
     * @param genre
     * @param length
     * @param signature
     * @return
     */
    private ArrayList<Melody> loadABC(String genre, String length, String signature) {
        return MelodyLoadeäör.load(genre, length, signature);
    }

    /**
     *
     * @param melodies
     */
    private void learnABC(ArrayList<Melody> melodies) {
        for (Melody melody : melodies) {
            setStartTable(melody.getTune());
            setOrderTable(melody.getTune());
        }
    }

    private void setStartTable(String tune) {
        if (tune.length() < ORDER) {
            System.err.print("Melody is to short!");
        }

        String start = tune.substring(0, ORDER);
        String following = tune.substring(0, 1);
        updateTable(start, following, startTable);
    }

    private void setOrderTable(String tune) {
        int length = tune.length();
        int i = ORDER;
        String current = tune.substring(0, i);
        String following;

        while (i < length) {
            following = tune.substring(i, i + 1);
            updateTable(current, following, markovTable);
            i++;
            // Update the string
            if (ORDER == 1) {
                current = following;
            } else {
                current = current.substring(1, ORDER) + following;
            }
        }
    }

    /**
     * Updating the ordered table. Helper method to addMelody
     *
     * @param seq The history that next should be based on
     * @param next the next char seen from the history (seq)
     * @param hmap the k-order table that should be updated
     */
    private void updateTable(String seq, String next, HashMap<String, MarkovInstance> hmap) {
        if (!hmap.containsKey(seq)) {
            MarkovInstance instance = new MarkovInstance(seq);
            instance.updateMap(next);
            hmap.put(seq, instance);
        } else {
            MarkovInstance existing = hmap.get(seq);
            existing.updateMap(next);
        }
    }

 
}
