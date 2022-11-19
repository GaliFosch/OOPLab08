package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    void setNextString(final String string);

    String getNexString();

    List<String> getHistory();
    
    void printString() throws IllegalStateException;
}
