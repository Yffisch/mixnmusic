package edu.chalmers.melodymaker.core;

import edu.chalmers.melodymaker.io.MelodyLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
   //     ArrayList<Melody> melodies = loadABC(genre, length, signature);
    //    learnABC(melodies);
    }

    /**
     * For testing purpose
     */
    public MelodyGenerator() {
        MAX = 100;
        MIN = 5;
        ORDER = 2;
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
//    private ArrayList<Melody> loadABC(String genre, String length, String signature) {
 //       return MelodyLoader.loadMelody(genre, length, signature);
  //  }

    /**
     *
     * @param melodies
     */
    public void learnABC(ArrayList<Melody> melodies) {
        System.out.println("Amount of melodies: " + melodies.size());
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
        List<Note> startList = tune.subList(0, ORDER);
        StringBuilder intro = new StringBuilder();
        for (Note note : startList) {
            intro.append(note.getNote());
        }
        updateTable(start, intro.toString(), startTable);
    }

    private void setOrderTable(ArrayList<Note> tune) {
        int length = tune.size();
        int i = ORDER;
        List<Note> currentNotes = tune.subList(0, i);
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
            currentNotes = tune.subList(i - ORDER, i);
        }
        current = new StringBuilder();
        for (Note note : currentNotes) {
            current.append(note.getNote());
        }
        updateTable(current.toString(), end, markovTable);
    }

    /**
     * Updating the ordered table. Helper method to the table methods
     *
     * @param seq The history that next should be based on
     * @param next the next note seen from the history (seq)
     * @param hmap the table that should be updated
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

    /**
     * Returns a generated tune from Markov probabilities
     *
     * @return a Markov chain presented as a String
     */
    public String generateTune() {

        StringBuilder tuneBuilder = new StringBuilder();
        int length = ORDER;

        System.out.println("Starting table: " + startTable.size() + " " + startTable.toString());
        System.out.println("Markov table: " + markovTable.size() + " " + markovTable.toString());
        MarkovInstance start = startTable.get("START");
        ArrayList<String> list = start.toProbabilities("RANDOM_WORD");
        int random = (int) Math.random() * list.size();
        String current = list.get(random);
        tuneBuilder.append(current);
        String keyToRemove = end;

        while (true) {
            if (length >= MIN) {
                keyToRemove = "RANDOM_WORD";
            }
            MarkovInstance history = markovTable.get(current);
            ArrayList<String> nextProb = history.toProbabilities(keyToRemove);
            random = (int) Math.random() * nextProb.size();
            String next = nextProb.get(random);
            tuneBuilder.append(next);
            length++;
            if (ORDER == 1)
                current = next;
            else
                current = current.substring(1) + next;
            if (length > MAX) {
                break;
            }
            System.out.println(tuneBuilder.toString());
        }
        return tuneBuilder.toString();
    }
}
