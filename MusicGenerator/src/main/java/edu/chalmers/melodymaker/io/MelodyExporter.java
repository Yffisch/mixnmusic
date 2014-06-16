package edu.chalmers.melodymaker.io;

import abc.midi.BasicMidiConverter;
import abc.midi.MidiConverterAbstract;
import abc.notation.Tune;
import abc.notation.TuneBook;
import abc.parser.TuneBookParser;
import edu.chalmers.melodymaker.core.Melody;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;

/**
 * Handles writing of abc-files and midi-files from Melody-objects.
 * 
 * @author Kristofer
 */
public class MelodyExporter implements IMelodyIO {

    public MelodyExporter() {
    }

    /**
     * Takes a Melody-object and writes it to an abc-file. It also creates a
     * midi-file through the helper method toMidi
     *
     * @param exportName
     * @param melody
     * @param id
     */
    static String testMelody;
    @Override
    public void exportTune(String exportName, String melody, int id) {

        try {
            FileWriter writer = new FileWriter("src/main/resources/exportfiles/" + exportName + ".abc");
            BufferedWriter out = new BufferedWriter(writer);
            testMelody = melody;
            out.write(testMelody);
            out.close();
        } catch (IOException e) {
        }
        toMIDI(id, exportName);
        System.out.println("\nGENERATED TUNE AFTER MUSIC THEORY HAS BEEN APPLIED...");
        System.out.println(melody);
    }

     public static String getMelodyInfoForTextField(){
        return testMelody;
    }
    
    private void toMIDI(int melodyID, String exportName) {
        String filePath = "src/main/resources/exportfiles/" + exportName + ".abc";
        File f = new File(filePath);
        try {
            TuneBook abcTB = new TuneBookParser().parse(f);
            Tune tune = abcTB.getTune(melodyID);
            File outMIDI = new File("src/main/resources/exportfiles/" + exportName + ".mid");
            MidiConverterAbstract conv = new BasicMidiConverter();
            Sequence s = conv.toMidiSequence(tune);

 //           TunePlayer player = new TunePlayer();
 //           player.start();
 //           player.play(tune);
            //The midi file result

            int[] types = MidiSystem.getMidiFileTypes(s);

            MidiSystem.write(s, types[0], outMIDI);
        } catch (IOException ex) {
            Logger.getLogger(MelodyExporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Melody loadMelody(String filename) {
        throw new UnsupportedOperationException("Use the MelodyIOFactory to get the loader to load a melody");
    }

    @Override
    public List<File> loadFileList() {
        throw new UnsupportedOperationException("Use the MelodyIOFactory to get the loader to load the filelist");
    }
}
