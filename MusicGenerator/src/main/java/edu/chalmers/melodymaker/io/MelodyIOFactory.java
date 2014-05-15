package edu.chalmers.melodymaker.io;

/**
 * This class only contains static method and will be used by classes that need
 * input and output, such as MelodyLibrary and MelodyController
 *
 * @author David
 */
public class MelodyIOFactory {

    private static final MelodyLoader loader = new MelodyLoader();
    private static final MelodyExporter exporter = new MelodyExporter();

    public static IMelodyIO getLoader() {
        return loader;
    }

    public static IMelodyIO getExporter() {
        return exporter;
    }
}
