package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String HOME = System.getProperty("user.home")
        + System.getProperty("file.separator");
    private File current = new File(HOME + "output.txt");

    /**
     * gets current target file.
     * 
     * @return
     *      current target file
     */
    public File getCurrent() {
        return current;
    }

    /**
     * gets current target file's path.
     * 
     * @return 
     *      current file's path as a {@code String}
     */
    public String getPath() {
        return current.toPath().toString();
    }

    /**
     * sets current file.
     * 
     * @param newCurrent
     *      new current file
     */
    public void setCurrent(final File newCurrent) {
        this.current = newCurrent;
    }

    /**
     * writes on the current target file.
     * 
     * @param content
     *      what to write on current target file
     * 
     * @throws IOException if file does not exist
     */
    public void write(final String content) throws IOException {
        try (PrintStream ps = new PrintStream(current, StandardCharsets.UTF_8)) {
            ps.print(content);
        }
    }
}
