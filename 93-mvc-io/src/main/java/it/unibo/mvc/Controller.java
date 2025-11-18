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
     * @throws NullPointerException if {@code s} is null 
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
     * 
     * @throws IllegalStateException if next string isn't set
     */
    void printCurrent();

    /**
     * gets the previewsly printed strings.
     * 
     * @return a {@code List} of the strings printed earlier.
     */
    List<String> getHistory();
}
