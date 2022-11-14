package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {

    private static final String PATH = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt";
    private File file;

    /**
     * 
     */
    public Controller() {
        this.file = new File(PATH);
    }

    /**
     * @param string
     * @throws IOException
     */
    public void printString(final String string) throws IOException {
        try (PrintStream ps = new PrintStream(file)) {
            ps.println(string);
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * @param file
     */
    public void setFile(final File file) {
        this.file = file;
    }

    /**
     * @return file
     */
    public File getFile() {
        return file;
    }

    /**
     * @return paht of the file
     */
    public String getPath() {
        return file.getPath();
    }
}
