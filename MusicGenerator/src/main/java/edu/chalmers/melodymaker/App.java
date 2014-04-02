package edu.chalmers.melodymaker;

import edu.chalmers.melodymaker.core.MelodyExporter;
import edu.chalmers.melodymaker.io.MelodyLoader;
import java.io.IOException;

/**
 * Author: Kristofer
 *
 */
public class App {

    MelodyExporter e;

    public static void main(String[] args) throws IOException {
        new App();
    }

    public App() throws IOException {
     
        e = new MelodyExporter();

    }
}
