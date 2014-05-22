package edu.chalmers.melodymaker.io;

import edu.chalmers.melodymaker.core.Melody;
import edu.chalmers.melodymaker.util.Alphabet;
import edu.chalmers.melodymaker.core.Note;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the reads the import directory (abc). The class can also
 * load files and parse them into Melody-objects for the MelodyLibrary
 *
 * @author Kristofer
 */
public class MelodyLoader implements IMelodyIO {

    private List<Note> noteList;
    private String[] parts;
    private String topPart;
    private String botPart;
    private String fullString;
    private String[] genrePart;

    public MelodyLoader() {
    }

    /**
     * Fetches all files in the directory
     * 
     * @return 
     */
    @Override
    public List<File> loadFileList() {
        List<File> files = new ArrayList();
        File folder = new File("src/main/resources/abc/");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                files.add(file);
            }
        }
        return files;
    }

    private String getNoteListVisible() {
        StringBuilder sb = new StringBuilder();
        for (Note n : noteList) {
            sb.append(n.toString());
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * Loads a file then reads the overhead and note part. Then parses the
     * information and creates a Melody-object
     *
     * @param filename
     * @return
     */
    @Override
    public Melody loadMelody(String filename) {

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
        botPart = parts[1];
        genrePart = parts[0].split(System.getProperty("line.separator"));

        //Parsing the overhead (top part)
        String songNumber = genrePart[0].substring(2);
        String songTitle = genrePart[1].substring(2);
        String songGenre = genrePart[2].substring(2);
        String songSignature = genrePart[3].substring(2);
        String songNoteLength = genrePart[4].substring(2);
        String songKey = genrePart[5].substring(2);

        //  if (Alphabet.isLetterInAlphabet(botPart.charAt(i) + "") && Alphabet.isLetterInAlphabet(botPart.charAt(i+1) + "")&& Alphabet.isLetterInAlphabet(botPart.charAt(i+2) + "")) //Måste göra så att eventuellt tecken efteråt läggs till
        //System.out.println("HEJHEJ" + songKey);
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
        System.out.print(getNoteListVisible());
        System.out.println("\n________________________________________________________________________________________________________________________________________________________________");

        Melody melody = new Melody(Integer.parseInt(songNumber), songTitle, songGenre, songNoteLength, songSignature, songKey, noteList);
        return melody;
    }

    @Override
    public void exportTune(String exportName, String melody, int ID) {
        throw new UnsupportedOperationException("Use the MelodyIOFactory to get the exporter");
    }
}
