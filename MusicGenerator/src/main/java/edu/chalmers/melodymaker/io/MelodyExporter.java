/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.melodymaker.io;

import edu.chalmers.melodymaker.core.MelodyGenerator;
import edu.chalmers.melodymaker.core.MelodyLibrary;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kristofer
 */
public class MelodyExporter {

    MelodyLoader melodyLoader = new MelodyLoader();

    //String[] test = {"hey_jude.abc", "rocky.abc", "supermario.abc"};
    public MelodyExporter(String importFilename, String exportFilename){
        MelodyLibrary melodyLibrary = MelodyLibrary.getInstance();
        melodyLibrary.makeMelody();
        MelodyGenerator generator = new MelodyGenerator();
        generator.learnABC(melodyLibrary.getMelodies());
        ArrayList<String> output = generator.generateTune();
        
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("src/main/resources/exportfiles/" + exportFilename));
                //out.write(m.GetTopPart());
            StringBuilder sb = new StringBuilder();
            for (String string : output) {
                sb.append(string);
            }
                out.write(sb.toString());
                System.out.println(sb.toString());
        } catch (IOException e) {
        }
    }
}
