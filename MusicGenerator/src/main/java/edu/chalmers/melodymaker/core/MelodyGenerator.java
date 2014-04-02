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
     * For testing purpose
     */
    public MelodyGenerator(){
        MAX = 100;
        MIN = 25;
        ORDER = 4;
        initTables();
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
        return MelodyLoader.load(genre, length, signature);
    }

    /**
     *
     * @param melodies
     */
    private void learnABC(ArrayList<Melody> melodies) {
        for (Melody melody : melodies) {
            setStartTable(melody.getNoteList());
            setOrderTable(melody.getNoteList());
        }
    }

    private void setStartTable(ArrayList<Note> tune) {       //tune should later on be a list of <Note>
        if (tune.size() < ORDER) {
            System.err.print("Melody is to short!");
        }
        String start = "START";
        ArrayList<Note> startList = (ArrayList<Note>) tune.subList(0, ORDER);
        StringBuilder intro = new StringBuilder();
        for (Note note : startList) {
            intro.append(note.getNote());
        }
        updateTable(start, intro.toString(), startTable);
    }

    private void setOrderTable(ArrayList<Note> tune) {
        int length = tune.size();
        int i = ORDER;
        ArrayList<Note> currentNotes = (ArrayList<Note>) tune.subList(0, i);
        StringBuilder current;
        String following;

        while (i < length) {
            current = new StringBuilder();
            following = tune.subList(i, i + 1).get(0).getNote();
            for (Note note : currentNotes) {
                current.append(note.getNote());
            }
            updateTable(current.toString(), following, markovTable);
            i++;
            // Update the string
            currentNotes = (ArrayList<Note>) tune.subList(i-ORDER, i);
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
