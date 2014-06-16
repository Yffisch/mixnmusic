package edu.chalmers.melodymaker.controller;

import edu.chalmers.melodymaker.core.Melody;
import edu.chalmers.melodymaker.core.MelodyConverter;
import edu.chalmers.melodymaker.core.MelodyGenerator;
import edu.chalmers.melodymaker.core.MelodyLibrary;
import edu.chalmers.melodymaker.io.IMelodyIO;
import edu.chalmers.melodymaker.io.MelodyIOFactory;
import edu.chalmers.melodymaker.player.MIDIplayer;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class is the connection between the UI and the model. It directs
 * commands to the correct classes.
 *
 * @author Emma
 */
public class MelodyController {
    
    private static MelodyController instance = null;
    public static Melody activeMelody;
    public static Melody tempGeneratedMelody;
    
    
    protected MelodyController() {
    }
    
    public static MelodyController getInstance() {
        if (instance == null) {
            instance = new MelodyController();
        }
        return instance;
    }
    
    public void sendGenerator(String title, String genre, String signature, String key, String length) {
        
        System.out.print("genre: " + genre + "\nsignature: " + signature);
        System.out.print("\nkey: " + key + "\nlength: " + length);
        
        int order = 2; //Maybe let the user decide order in the UI
        
        MelodyGenerator generator = new MelodyGenerator(order, 40, 100, title, genre, length, signature, key);
        generator.learnABC(MelodyLibrary.getInstance().getMelodies());
        System.out.println("GENERATING TUNE...");
        Melody melody = generator.generateTune();
        tempGeneratedMelody = melody;
        //System.out.println("Här är den!!" + melody.getNoteList());
        System.out.println("APPLYING FILTERS...");
        melody.setFilteredNotes(generator.applyFilter(melody.getNoteList()));
       
        activeMelody = melody;
        
        
        exporting();
        
        
    }
    
    public static void exporting(){
        IMelodyIO exporter = MelodyIOFactory.getExporter();
        String abcMelody = MelodyConverter.getInstance().convertMelody(getActiveMelody());
        exporter.exportTune("temp", abcMelody, getActiveMelody().getID());
    }
    
    public static Melody getActiveMelody(){
        return activeMelody;
    }
    
     public static Melody getTempMelody(){
        return tempGeneratedMelody;
    }
    
    public static void setActiveMelody(Melody melody){
        activeMelody = melody;
    }
    
    public void sendSave(){
        
        IMelodyIO exporter = MelodyIOFactory.getExporter();
        String abcMelody = MelodyConverter.getInstance().convertMelody(activeMelody);
        exporter.exportTune(activeMelody.getTitle(), abcMelody, activeMelody.getID());
    }
    
    
    public void sendPlay(){
        
        MIDIplayer.MIDIplayer("src/main/resources/exportfiles/temp.mid");
    }
    
    public void sendStop(){
        MIDIplayer.reset();
    }
    

    /**
     * Loads all abc-files within the import directory (abc) and fills the
     * MelodyLibrary
     */
    public void fillLibrary() {
        IMelodyIO melodyLoader = MelodyIOFactory.getLoader();
        List<File> files = melodyLoader.loadFileList();
        
        if (!files.isEmpty()) {
            for (File file : files) {
                Melody melody = melodyLoader.loadMelody(file.getName());
                MelodyLibrary.getInstance().addMelody(melody);
            }
        }
    }

    /**
     * Used to fill the MainFrames comboBox about genres
     *
     * @return
     */
    public Set<String> getGenres() {
        List<Melody> mMelodies = MelodyLibrary.getInstance().getMelodies();
        Set<String> genres = new HashSet<>();
        for (Melody m : mMelodies) {
            genres.add(m.getGenre());
        }
        System.out.println("\nThis is our genres  " + genres.toString());
        return genres;
    }
    
    public String getTheTitle(){
        String title = activeMelody.getTitle();
        return title;
    }
}
