/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.melodymaker.io;

import edu.chalmers.melodymaker.core.Alphabet;
import edu.chalmers.melodymaker.core.Note;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kristofer
 */
public class MelodyLoader {

    ArrayList<Note> noteList = new ArrayList();

    public MelodyLoader() {

    }

    public String getNoteListVisible() {
        StringBuilder sb = new StringBuilder();

        for (Note n : noteList) {
            sb.append(n.getNote());

        }
        return sb.toString();
        ///System.out.println(sb);
    }

    public String LoadMelody() throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/abc/hey_jude.abc"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String fullString = sb.toString();
            //Ska vara i annan kod
            String[] parts = fullString.split("-");
            String topPart = parts[0];
            String botPart = parts[1];

            for (int i = 0; i < fullString.length(); i++) {
                if (Alphabet.isLetterInAlphabet(fullString.charAt(i) + "") == true) //Måste göra så att eventuellt tecken efteråt läggs till
                {
                    noteList.add(new Note(fullString.charAt(i) + ""));
                }

            }

           
            System.out.println(noteList.size());
            return fullString;

        }

    }
}
