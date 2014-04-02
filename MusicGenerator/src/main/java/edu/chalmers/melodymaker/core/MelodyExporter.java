/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.melodymaker.core;

import edu.chalmers.melodymaker.io.MelodyLoader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Kristofer
 */
public class MelodyExporter {

    MelodyLoader m = new MelodyLoader();

    //String[] test = {"hey_jude.abc", "rocky.abc", "supermario.abc"};
    public MelodyExporter(String importFilename, String exportFilename) throws IOException {
        m.loadFileList();

        for (File fil : MelodyLoader.files) {
            m.loadMelody(fil.getName().toString());
            //getNoteList() för att få dem utan string
           System.out.println(m.getNoteListVisible()); 
        }

        try {
            try (BufferedWriter out = new BufferedWriter(new FileWriter("src/main/resources/abc/" + exportFilename))) {
                //out.write(m.GetTopPart());
               // out.write(m.getNoteListVisible());
            }
        } catch (IOException e) {
        }
    }
}
