package edu.chalmers.melodymaker;

import edu.chalmers.melodymaker.io.MelodyLoader;
import java.io.IOException;

/**
 * Author: Kristofer
 *
 */
public class App {

    MelodyLoader m;

    public static void main(String[] args) throws IOException {
        new App();
    }

    public App() throws IOException {
        m = new MelodyLoader();

    }
}
