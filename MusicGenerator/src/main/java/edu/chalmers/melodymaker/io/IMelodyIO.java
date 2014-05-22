package edu.chalmers.melodymaker.io;

import edu.chalmers.melodymaker.core.Melody;
import java.io.File;
import java.util.List;

/**
 *
 * @author David
 */
public interface IMelodyIO {

    public void exportTune(String exportName, String melody, int ID);

    public Melody loadMelody(String filename);

    public List<File> loadFileList();

}
