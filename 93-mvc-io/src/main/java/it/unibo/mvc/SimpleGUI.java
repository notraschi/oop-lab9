package it.unibo.mvc;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    /**
     * sets up the view.
     */
    public SimpleGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.setContentPane(panel);
        final JTextField field = new JTextField();
        panel.add(field, BorderLayout.NORTH);
        final JTextArea historyArea = new JTextArea();
        historyArea.setEditable(false);
        panel.add(historyArea, BorderLayout.CENTER);
        final JPanel bottom = new JPanel();
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        panel.add(bottom, BorderLayout.SOUTH);
        final JButton print = new JButton("print");
        bottom.add(print);
        final JButton showHistory = new JButton("show history");
        bottom.add(showHistory);
    }

    /**
     * displays the view.
     */
    private void display() {
        frame.setVisible(true);
    }

    public static void main(final String... args) {
        new SimpleGUI().display();
    }
}
