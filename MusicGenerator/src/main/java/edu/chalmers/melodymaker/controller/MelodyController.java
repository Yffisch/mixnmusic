/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.melodymaker.controller;

import edu.chalmers.melodymaker.core.Melody;
import edu.chalmers.melodymaker.core.MelodyLibrary;
import edu.chalmers.melodymaker.gui.MelodyMakerUI;
import edu.chalmers.melodymaker.io.MelodyExporter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Emma
 */
public class MelodyController {

    private static MelodyController instance = null;

    protected MelodyController() {
    }

    public static MelodyController getInstance() {
        if (instance == null) {
            instance = new MelodyController();
        }
        return instance;
    }
    private ArrayList<Melody> mMelodies;
    public Set<String> genres;
   // public MelodyExporter melodyexporter = new MelodyExporter("hej","hej");

    public void sendGenerator(String title, String genre, String signature, String key, String length) {

        System.out.print("genre: " + genre + "\nsignature: " + signature);
        System.out.print("\nkey: " + key + "\nlength: " + length);

        MelodyExporter exporter = new MelodyExporter(title, genre, signature, key, length);
        exporter.exportTune("temp.abc", 3);
    }

    public Set<String> getGenres() {
        mMelodies = MelodyLibrary.getInstance().getMelodies();
        genres = new HashSet<>();
        for (Melody m : mMelodies) {

            genres.add(m.getGenre());

        }
        System.out.println("This is our genres  " + genres.toString());
        return genres;
    }

}
