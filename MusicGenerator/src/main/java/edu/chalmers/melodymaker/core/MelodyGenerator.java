package edu.chalmers.melodymaker.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Yff
 */
public class MelodyGenerator {

    private final int MAX;
    private final int MIN;
    private final int ORDER;
    private final Note end = new Note("EOM");
    private HashMap<List<Note>, Integer> startTable;
    private HashMap<List<Note>, MarkovInstance> markovTable;
    private String genre;
    private String toneLength;
    private String signature;

    public MelodyGenerator(int order, int minNrOfNotes, int maxNrOfNotes, String genre, String length, String signature) { //Genre/Length/Signature
        this.MIN = minNrOfNotes;
        this.MAX = maxNrOfNotes;
        if (order < 1) {
            System.err.println("Order has to be at least 1");
        }
        this.ORDER = order;
        this.genre = genre;
        toneLength = length;
        this.signature = signature;
        initTables();
    }

    /**
     * For testing purpose
     */
    public MelodyGenerator() {
        //ORDER,MIN,MAX,Genre,Length,Signature
        this(1, 5, 100, null, null, null);
    }

    /**
     * Initiate the HashMaps
     */
    private void initTables() {
        startTable = new HashMap<>();
        markovTable = new HashMap<>();
    }
    
    /**
     *
     * @param melodies
     */
    public void learnABC(List<Melody> melodies) {
        for (Melody melody : melodies) {
            setStartTable(melody.getNoteList());
            setOrderTable(melody.getNoteList());
        }
    }

    private void setStartTable(List<Note> tune) {
        if (tune.size() < ORDER)
            System.err.print("Melody is to short!");
        List<Note> startList = tune.subList(0, ORDER);
        
        if (!startTable.containsKey(startList)) {
            startTable.put(startList, 1);
        } else {
            startTable.put(startList, startTable.get(startList) + 1);
        }
    }

    private void setOrderTable(List<Note> tune) {
        int length = tune.size();
        int i = ORDER;
        List<Note> currentNotes = tune.subList(0, i);
        Note following;

        while (i < length) {
            following = tune.get(i);
            updateTable(currentNotes, following);
            i++;
            // Update the current note list
            currentNotes = tune.subList(i - ORDER, i);
        }
        updateTable(currentNotes, end);
    }

    /**
     * Updating the ordered table. Helper method to the table methods
     *
     * @param seq The history that next should be based on
     * @param next the next note seen from the history (seq)
     * @param hmap the table that should be updated
     */
    private void updateTable(List<Note> seq, Note next) {
        if (!markovTable.containsKey(seq)) {
            MarkovInstance instance = new MarkovInstance(seq);
            instance.updateMap(next);
            markovTable.put(seq, instance);
        } else {
            MarkovInstance existing = markovTable.get(seq);
            existing.updateMap(next);
        }
    }

    /**
     * Returns a generated tune from Markov probabilities
     *
     * @return a Markov chain presented as a String
     */
    public List<Note> generateTune() {

        List<Note> noteList = new ArrayList<>();
        int length = ORDER;

        List<List<Note>> startList = startProbabilities();
        int random = new Random().nextInt(startList.size());
        List<Note> current = startList.get(random);
        for (Note note : current) {
            noteList.add(note);
        }
        Note keyToRemove = end;

        while (true) {
            if (length >= MIN) {
                keyToRemove = new Note("RANDOM_WORD");
            }
            MarkovInstance history = markovTable.get(current);
            List<Note> nextProb = history.toProbabilities(keyToRemove);
            random = new Random().nextInt(nextProb.size());
            Note next = nextProb.get(random);
            if (next.equals(end)) {
                break;
            }
        
            noteList.add(next);
            length++;
            if (ORDER == 1){
                current = new ArrayList<>();
            } else {
                current = current.subList(1, ORDER + 1);
            }
            current.add(next);
            System.out.println("Current is : " + current);
            if (length > MAX) {
                break;
            }
        }
        
        System.out.println("\nGENERATED NOTES BEFORE ANY MUSIC THEORY...");
        for (Note note : noteList){
            System.out.print(note);
        }
        System.out.println();
        return MelodyTheory.applyMusicTheory(noteList);
        //   return noteList;
    }
    
    private List<List<Note>> startProbabilities() {
        Set<List<Note>> keySet = startTable.keySet();
        List<List<Note>> probList = new ArrayList<>();
        for (List<Note> key : keySet) {
                int occurence = startTable.get(key);
                while (occurence > 0) {
                    probList.add(key);
                    occurence--;
                }
        }
        return probList;
    }
}