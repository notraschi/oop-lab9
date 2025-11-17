package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    /**
     * default constructor.
     * constructs view.
     */
    public SimpleGUI() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JTextArea text = new JTextArea();
        panel.add(text, BorderLayout.CENTER);
        final JButton save = new JButton("save");
        panel.add(save, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // action listeners
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ae) {
                try {
                    controller.write(text.getText());
                } catch (final IOException ex) {
                    JOptionPane.showMessageDialog(frame, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * displays the view.
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) screen.getWidth() / 2, (int) screen.getHeight() / 2);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        // frame.pack(); // i hate swing.
    }

    /**
     * main method.
     * 
     * @param args
     *      ignored
     */
    public static void main(final String... args) {
        new SimpleGUIWithFileChooser().display();
    }
}
