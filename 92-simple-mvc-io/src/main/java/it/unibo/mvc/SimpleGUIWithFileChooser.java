package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private final JTextArea path = new JTextArea();
    private final Controller controller = new Controller();

    /**
     * basic constructor.
     * sets view.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        panel.add(topPanel, BorderLayout.NORTH);
        // path stuff
        path.setEditable(false);
        path.setText(controller.getPath());
        topPanel.add(path, BorderLayout.CENTER);
        final JButton browse = new JButton("browse");
        topPanel.add(browse, BorderLayout.LINE_END);
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
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ae) {
                final JFileChooser fileChooser = new JFileChooser();
                final int chooseFileResult = fileChooser.showSaveDialog(frame);
                if (chooseFileResult == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrent(fileChooser.getSelectedFile());
                    updateUI();
                } else if (chooseFileResult != JFileChooser.CANCEL_OPTION) {
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
     * updates the UI with the most up-to-date values.
     */
    private void updateUI() {
        path.setText(controller.getPath());
    }
}
