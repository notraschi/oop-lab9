package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * simple implementation of the stdout controller {@link Controller}.
 */
public final class SimpleController implements Controller {

    private final List<String> history = new ArrayList<>();
    private String next;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNext(final String s) {
        if (s == null) {
            throw new IllegalArgumentException("cannot print null strings");
        }
        next = s;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNext() {
        return next;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printCurrent() {
        if (next == null) {
            throw new IllegalStateException("string to print was never initialized");
        }
        System.out.println(next); // NOPMD: this is required by the interface
        history.add(next);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getHistory() {
        return List.copyOf(history);
    }
}
