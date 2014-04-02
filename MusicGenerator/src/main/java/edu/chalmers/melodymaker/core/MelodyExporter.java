/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.melodymaker.core;

import edu.chalmers.melodymaker.io.MelodyLoader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Yff
 */
public class MelodyExporter {

    MelodyLoader m = new MelodyLoader();
    
    public MelodyExporter() throws IOException{
        m.LoadMelody();
        m.getFileList();
        try {
            try (BufferedWriter out = new BufferedWriter(new FileWriter("src/main/resources/abc/lala.txt"))) {
                
                    out.write(m.GetTopPart());
                
            }
        } catch (IOException e) {
        }
    }
}
