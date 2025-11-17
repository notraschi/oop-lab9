package it.unibo.mvc;

import java.util.List;

/**
 * this interface models a simple controller that considers the stdout.
 */
public interface Controller {

    /**
     * sets next string to print.
     * 
     * @param s the string in question
     */
    void setNext(String s);

    /**
     * gets next string to print.
     * 
     * @return next string to print
     */
    String getNext();

    /**
     * prints current string.
     */
    void printCurrent();

    /**
     * gets the previewsly printed strings.
     * 
     * @return a {@code List} of the strings printed earlier.
     */
    List<String> getHistory();
}
