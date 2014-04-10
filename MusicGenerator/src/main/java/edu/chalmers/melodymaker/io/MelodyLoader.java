/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.melodymaker.io;

import util.Alphabet;
import edu.chalmers.melodymaker.core.Note;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kristofer
 */
public class MelodyLoader {

    public ArrayList<Note> noteList;
    public static ArrayList<File> files = new ArrayList();
    String[] parts;
    String topPart;
    String botPart;
    String fullString;
    String[] genrePart;
//X:1
//T:Rocky
//Z:arae69
//M:4/4
//L:1/8
//Q:96
//KC:C
    String songNumber;
    String songTitle;
    String songAuthor;
    String songSignature;
    String songNoteLength;
    String songKey;

    public MelodyLoader() {
    }

    public String getBotPart() {
        return botPart;
    }

    public String getSongNumber() {
        return songNumber;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getSongAuthor() {
        return songAuthor;
    }

    public String getSongSignature() {
        return songSignature;
    }

    public String getSongNoteLength() {
        return songNoteLength;
    }

    public String getSongKey() {
        return songKey;
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

    public ArrayList<Note> getNoteList() {
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

    public String loadMelody(String filename) {

        noteList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/abc/" + filename));

            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        } catch (IOException e) {
        }
        fullString = sb.toString();
        parts = fullString.split("-");
        topPart = parts[0];
        botPart = parts[1];
        genrePart = parts[0].split(System.getProperty("line.separator"));

        //The top part lines
        songNumber = genrePart[0].substring(2);
        songTitle = genrePart[1].substring(2);
        songAuthor = genrePart[2].substring(2);
        songSignature = genrePart[3].substring(2);
        songNoteLength = genrePart[4].substring(2);
        songKey = genrePart[5].substring(2);

        //  if (Alphabet.isLetterInAlphabet(botPart.charAt(i) + "") && Alphabet.isLetterInAlphabet(botPart.charAt(i+1) + "")&& Alphabet.isLetterInAlphabet(botPart.charAt(i+2) + "")) //Måste göra så att eventuellt tecken efteråt läggs till
        System.out.println("HEJHEJ" + songKey);
        System.out.println("\nLOADING FILE... " + filename);
        System.out.println("\nNOTES IN ABC...\n" + botPart);

        for (int i = 0; i < botPart.length() - 2; i++) {
            String note;
            if (Alphabet.isLetterInAlphabet(botPart.substring(i, i + 3))) {
                note = botPart.substring(i, i + 3);
                noteList.add(new Note(note));
            } else if (Alphabet.isLetterInAlphabet(botPart.substring(i, i + 2))) {
                note = botPart.substring(i, i + 2);
                noteList.add(new Note(note));
            } else if (Alphabet.isLetterInAlphabet(botPart.substring(i, i + 1))) {
                note = botPart.substring(i, i + 1);
                noteList.add(new Note(note));
            }
        }

        System.out.println("PARSING NOTES...\n");

        for (Note n : noteList) {
            System.out.print(n.getNote() + " ");
        }
        System.out.println("\n________________________________________________________________________________________________________________________________________________________________");
        return botPart;
    }
}
