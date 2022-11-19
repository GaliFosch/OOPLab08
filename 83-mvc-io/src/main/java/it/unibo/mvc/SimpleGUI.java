package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("Prints");
    private final Controller controller = new SimpleController();

    public SimpleGUI(){
        final JPanel panel = new JPanel(new BorderLayout());
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextField text = new JTextField("Write here");
        panel.add(text, BorderLayout.NORTH);
        final JTextArea area = new JTextArea();
        panel.add(area, BorderLayout.CENTER);
        area.setEditable(false);
        final JPanel buttonsPanel = new JPanel();
        panel.add(buttonsPanel, BorderLayout.SOUTH);

        final JButton print = new JButton("Print");
        buttonsPanel.add(print);
        final JButton history = new JButton("Show History");
        buttonsPanel.add(history);

        print.addActionListener( new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                controller.setNextString(text.getText());
                controller.printString();
            }

        });

        history.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String out = "";
                for(String s : controller.getHistory()){
                    out = out + s + "\n";
                }
                area.setText(out);
            }

        });
    }

    private void display() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = (int) screen.getWidth();
        int sh = (int) screen.getHeight();
        frame.setSize(sw/PROPORTION,sh/PROPORTION);
        frame.setVisible(true);
    }

    public static void main (String[] args){
        SimpleGUI gui = new SimpleGUI();
        gui.display();
    }

}
