/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.melodymaker.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Kristofer
 */
public class MelodyLoader {

    public MelodyLoader() throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/abc/hey_jude.abc"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
                    System.out.println(everything);

        }
    }
}
