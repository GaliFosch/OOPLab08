package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private final static String PATH = System.getProperty("user.home")
            +System.getProperty("file.separator")
            +"output.txt";
    private File file;

    public Controller() {
        this.file = new File(PATH);
    }

    public void printString(final String string) throws IOException{
        try ( PrintStream ps = new PrintStream(file) ) {
            ps.println(string);
        } catch (IOException e){
            throw e;
        }
    }

    public void setFile(final File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public String getPath(){
        return file.getPath();
    }

    
}
