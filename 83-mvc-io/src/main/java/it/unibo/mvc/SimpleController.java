package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String nexString;
    private ArrayList<String> history;

    @Override
    public void setNextString(final String string) {
        this.nexString = string;
    }

    @Override
    public String getNexString() {
        return String.valueOf(nexString);
    }

    @Override
    public List<String> getHistory() {
        return List.copyOf(history);
    }

    @Override
    public void printString() throws IllegalStateException {
        try{
            Objects.requireNonNull(nexString);
        }catch (NullPointerException e){
            throw new IllegalStateException();
        }
        System.out.println(nexString);
        history.add(nexString);
    }

}
