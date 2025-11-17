package it.unibo.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;


/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private final String HOME = System.getProperty("user.home")
        + System.getProperty("file.separator");
    private File current = new File(HOME + "output.txt");    

    public File getCurrent() {
        return current;
    }

    public String getPath() {
        return current.toPath().toString();
    }

    public void setCurrent(final File newCurrent) {
        this.current = newCurrent;
    }

    public void write(final String content) throws IOException {
        try (PrintStream ps = new PrintStream(current)) {
            ps.print(content);
        } catch (FileNotFoundException ex) {
            throw new IOException("file not found");
        }
    }
}
