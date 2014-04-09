/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.melodymaker.io;

import abc.midi.BasicMidiConverter;
import abc.midi.MidiConverterAbstract;
import abc.notation.Tune;
import abc.notation.TuneBook;
import abc.parser.TuneBookParser;
import edu.chalmers.melodymaker.core.Melody;
import edu.chalmers.melodymaker.core.MelodyGenerator;
import edu.chalmers.melodymaker.core.MelodyLibrary;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.Sequence;

/**
 *
 * @author Kristofer
 */
public class MelodyExporter {

    MelodyLoader melodyLoader = new MelodyLoader();

    //String[] test = {"hey_jude.abc", "rocky.abc", "supermario.abc"};
    public MelodyExporter(String importFilename, String exportFilename) {
        MelodyLibrary melodyLibrary = MelodyLibrary.getInstance();
        melodyLibrary.makeMelody();
        MelodyGenerator generator = new MelodyGenerator();
        generator.learnABC(melodyLibrary.getMelodies());
        System.out.println("GENERATING TUNE...");
        ArrayList<String> output = generator.generateTune();

        StringBuilder sb = new StringBuilder();
        for (String string : output) {
            sb.append(string);
        }

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("src/main/resources/exportfiles/" + exportFilename));
            out.write(sb.toString());
        } catch (IOException e) {
        }

        System.out.println("\nGENERATED TUNE AFTER MUSIC THEORY HAS BEEN APPLIED...");
        System.out.println(sb.toString());

    }

    public void toMIDI(Melody melody) {
        String filePath = "src/main/resources/stupid.abc";
        File f = new File(filePath);
        try {
            TuneBook abcTB = new TuneBookParser().parse(f);
            Tune tune = abcTB.getTune(10);
            File outMIDI = new File("src/main/resources/exportfiles/test.mid");
            MidiConverterAbstract conv = new BasicMidiConverter();
            Sequence s = conv.toMidiSequence(tune);

        } catch (IOException ex) {
            Logger.getLogger(MelodyExporter.class.getName()).log(Level.SEVERE, null, ex);
        }
            
          //  TunePlayer player = new TunePlayer();
           // player.start();
           // player.play(tune);
            //The midi file result
            //    
            //     
            //       
            //      int[] types = MidiSystem.getMidiFileTypes(s);
            //      try {
            //          MidiSystem.write(s, types[0], file);
            //  } catch (IOException ex) {
            //       Logger.getLogger(MelodyExporter.class.getName()).log(Level.SEVERE, null, ex);
            //    }
            /*              BasicMidiConverter midi = new BasicMidiConverter();
            String key = melody.getKey();
            for (Note note : melody.getNoteList()) {
            new KeySignature
            midi.getNoteOffMessageFor(note, null);
            }
            
            */
       
    }
}
