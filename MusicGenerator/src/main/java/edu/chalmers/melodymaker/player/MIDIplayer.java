package edu.chalmers.melodymaker.player;

import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;
import javax.swing.JFrame;

/**
 *
 * @author Emma
 */
public class MIDIplayer extends JFrame{

    private static int midiLength = 0;
    private static Sequencer sm_sequencer = null;
    private static Synthesizer sm_synthesizer = null;
    private static Sequence sequence = null;
    MIDIplayer m = new MIDIplayer();
    public static int tempo = 1;
    public static MidiChannel channel;
    
    public static void MIDIplayer(String filename) {
        
        File midiFile = new File(filename);
 
        //Check that the file is not empty
        if (!midiFile.exists() || midiFile.length() == 0) {
            printUsageAndExit();
        }
        try {
            sequence = MidiSystem.getSequence(midiFile);
            midiLength =(int) sequence.getMicrosecondLength();
            System.out.println("Length of midi:  " + midiLength);
        } catch (InvalidMidiDataException e) {
            System.exit(0);
        } catch (IOException e) {
            System.exit(0);
        }

        try {
            sm_sequencer = MidiSystem.getSequencer();
        } catch (MidiUnavailableException e) {
            System.exit(0);
        }
        if (sm_sequencer == null) {
            System.out.println("SimpleMidiPlayer.main(): can't get a Sequencer");
            System.exit(0);
        }

        sm_sequencer.addMetaEventListener(new MetaEventListener() {
            @Override
            public void meta(MetaMessage event) {
                if (event.getType() == 47) {
                    sm_sequencer.close();
                    if (sm_synthesizer != null) {
                        sm_synthesizer.close();
                    }
                   // System.exit(0);
                }
            }
        });

        try {
            sm_sequencer.open();
        } catch (MidiUnavailableException e) {
            System.exit(0);
        }


        try {
            sm_sequencer.setSequence(sequence);
        } catch (InvalidMidiDataException e) {
            System.exit(0);
        }

        if (!(sm_sequencer instanceof Synthesizer)) {

            try {
                sm_synthesizer = MidiSystem.getSynthesizer();
                sm_synthesizer.open();
                Receiver synthReceiver = sm_synthesizer.getReceiver();
                Transmitter seqTransmitter = sm_sequencer.getTransmitter();
                seqTransmitter.setReceiver(synthReceiver);
            } catch (MidiUnavailableException e) {
                e.printStackTrace();
            }
        }

      
        
        // 	Now, we can start over.
         
        sm_sequencer.start();
    }

    private static void printUsageAndExit() {
        System.out.println("SimpleMidiPlayer: usage:");
        System.out.println("\tjava SimpleMidiPlayer <midifile>");
        System.exit(0);
    }
    public static void reset(){
    midiLength = 0;
    sm_sequencer.stop();
    sm_synthesizer.close();
    sequence = null;
    }
    
    public static void lowerTempo(){
        sm_sequencer.setTempoInBPM(50);
    }
    
    public static void higherTempo(){
        sm_sequencer.setTempoInBPM(500);
        
    }
    
     public static void lowerVolume() throws MidiUnavailableException{
       //channel.controlChange(100, (int)200);
       //sm_synthesizer.getReceiver().send(null, -1);
    }
    
    public static void higherVolume(){
       //channel.controlChange(100, (int)200);
       //channel.
    }

}
