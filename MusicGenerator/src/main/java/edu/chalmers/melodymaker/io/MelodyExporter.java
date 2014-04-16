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

    public MelodyExporter(String importFilename, String exportFilename) {
        MelodyGenerator generator = new MelodyGenerator();
        generator.learnABC(MelodyLibrary.getInstance().getMelodies());
        System.out.println("GENERATING TUNE...");
        List<Note> output = generator.generateTune();

        StringBuilder sb = new StringBuilder();
        for (Note note : output) {
            sb.append(note.toString());
        }

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("src/main/resources/exportfiles/" + exportFilename));
            out.write(sb.toString());
        } catch (IOException e) {
        }

        System.out.println("\nGENERATED TUNE AFTER MUSIC THEORY HAS BEEN APPLIED...");
        System.out.println(sb.toString());

    }

    public void toMIDI(Melody melody, String midiName) {
        String filePath = "src/main/resources/stupid.abc";
        File f = new File(filePath);
        try {
            TuneBook abcTB = new TuneBookParser().parse(f);
            Tune tune = abcTB.getTune(10);
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