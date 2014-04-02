/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.melodymaker.io;

import edu.chalmers.melodymaker.core.Alphabet;
import edu.chalmers.melodymaker.core.Note;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kristofer
 */
public class MelodyLoader {

    public ArrayList<Note> noteList = new ArrayList();
    public static ArrayList<File> files = new ArrayList();
    String[] parts;
    String topPart;
    String botPart;
    String fullString;

    public MelodyLoader() {

    }

    public String getBotPart() {
        return botPart;
    }

    public String getTopPart() {
        return topPart;
    }
    
// Shows list of all files in the folder
    public void loadFileList() {
        File folder = new File("src/main/resources/abc/");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                //System.out.println(file.getName());
                files.add(file);
            }
        }
                        //System.out.println(files.size());

    }
// Get all the filtered notes in the note list to a string
    public ArrayList<Note> getNoteList(){
        return noteList;
    }
    
    public String getNoteListVisible() {
        StringBuilder sb = new StringBuilder();

        for (Note n : noteList) {
            sb.append(n.getNote());
        }
        return sb.toString();
    }
// Load melody from file and pick top and bot part
    public String loadMelody(String filename) throws FileNotFoundException, IOException {
        
        noteList.clear();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/abc/" + filename))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            fullString = sb.toString();
            parts = fullString.split("-");
            topPart = parts[0];
            botPart = parts[1];
           

            for (int i = 0; i < fullString.length(); i++) {
                if (Alphabet.isLetterInAlphabet(fullString.charAt(i) + "") == true) //Måste göra så att eventuellt tecken efteråt läggs till
                {
                    noteList.add(new Note(fullString.charAt(i) + ""));
                }
            }
            
            //System.out.println(noteList.size());
            return fullString;
        }
    }
}
