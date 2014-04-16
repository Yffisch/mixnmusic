package edu.chalmers.melodymaker.io;

import abc.midi.BasicMidiConverter;
import abc.midi.MidiConverterAbstract;
import abc.midi.TunePlayer;
import abc.notation.Tune;
import abc.notation.TuneBook;
import abc.parser.TuneBookParser;
import edu.chalmers.melodymaker.core.Melody;
import edu.chalmers.melodymaker.core.MelodyGenerator;
import edu.chalmers.melodymaker.core.MelodyLibrary;
import edu.chalmers.melodymaker.core.MelodyTheory;
import edu.chalmers.melodymaker.core.Note;
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
 *
 * @author Kristofer
 */
public class MelodyExporter {

    MelodyLoader melodyLoader = new MelodyLoader();

    public void exportTune(String exportFilename) {
        MelodyGenerator generator = new MelodyGenerator();
        generator.learnABC(MelodyLibrary.getInstance().getMelodies());
        System.out.println("GENERATING TUNE...");
        Melody melody = generator.generateTune();
        List<Note> output = melody.getNoteList();
        StringBuilder sb = new StringBuilder();
        //Build ABC
        sb.append("X:");
        sb.append(melody.getID());
        sb.append("\nT:");
        sb.append(melody.getTitle());
        sb.append("\nR:");
        sb.append(melody.getGenre());
        sb.append("\nM:");
        sb.append(melody.getSignature());
        sb.append("\nL:");
        sb.append(melody.getNoteLength());
        sb.append("\nK:");
        sb.append(melody.getKey());
        sb.append("\n");
        output = MelodyTheory.applyMusicTheory(output);
        for (Note note : output) {
            sb.append(note);
        }

        try {
            FileWriter writer = new FileWriter("src/main/resources/exportfiles/" + exportFilename);
            BufferedWriter out = new BufferedWriter(writer);
            out.write(sb.toString());
            out.close();
        } catch (IOException e) {
        }

  //      toMIDI(melody, "test");
        System.out.println("\nGENERATED TUNE AFTER MUSIC THEORY HAS BEEN APPLIED...");
        System.out.println(sb.toString());
    }

    private void toMIDI(Melody melody, String midiName) {
        String filePath = "src/main/resources/stupid.abc";
        File f = new File(filePath);
        try {
            TuneBook abcTB = new TuneBookParser().parse(f);
            Tune tune = abcTB.getTune(57);
            File outMIDI = new File("src/main/resources/exportfiles/" + midiName + ".mid");
            MidiConverterAbstract conv = new BasicMidiConverter();
            Sequence s = conv.toMidiSequence(tune);

            TunePlayer player = new TunePlayer();
            player.start();
            player.play(tune);
            //The midi file result

            int[] types = MidiSystem.getMidiFileTypes(s);

            MidiSystem.write(s, types[0], outMIDI);
        } catch (IOException ex) {
            Logger.getLogger(MelodyExporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}