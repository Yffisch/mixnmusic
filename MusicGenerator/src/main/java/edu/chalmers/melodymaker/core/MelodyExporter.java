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
 * @author Yff
 */
public class MelodyExporter {

    MelodyLoader m = new MelodyLoader();

    public MelodyExporter(String importFilename, String exportFilename) throws IOException {
        
        m.LoadMelody(importFilename);
        m.getFileList();
       // for (File fil : MelodyLoader.files) {

            
            try {
                try (BufferedWriter out = new BufferedWriter(new FileWriter("src/main/resources/abc/" + exportFilename))) {
                    //out.write(m.GetTopPart());
                    out.write(m.getNoteListVisible());
                }
            } catch (IOException e) {
            }
      //  }
    }
}
