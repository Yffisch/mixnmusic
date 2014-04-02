/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chalmers.melodymaker.core;



import edu.chalmers.melodymaker.io.MelodyLoader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Emma Nyborg
 */
public class MelodyModel {
    
    ArrayList<Melody> melObj = new ArrayList<>(); 
    
    
    
    public void makeMelody() throws IOException{
        
        MelodyLoader m = new MelodyLoader();
        m.loadFileList();
        if (!MelodyLoader.files.isEmpty()){
            //String genre, String signature, String key, String length)
            for(File f: MelodyLoader.files){
                m.loadMelody(f.getName());
                ArrayList<Note> notes = m.getNoteList();
                Melody mel = new Melody(notes);
                melObj.add(mel);
            }
            
        }

    }
    
    public ArrayList<Melody> getMelodies(){
        return melObj;
    }
    
}
