package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.plaf.DimensionUIResource;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String TITLE = "simpleGui";
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    public SimpleGUI() {
        final JPanel panel = new JPanel(new BorderLayout());
        frame.setContentPane(panel);
        frame.setTitle(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextArea area = new JTextArea("scrivi qui");
        final JButton save = new JButton("Save");
        panel.add(area, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);
        
        save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    controller.printString(area.getText());
                } catch ( IOException e) {
                    e.printStackTrace(); //NOPMD: è un esercizio
                }
            }

        });
    }

    public void display(){
        final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) dimension.getWidth();
        final int sh = (int) dimension.getHeight();
        frame.setSize(sw/PROPORTION, sh/PROPORTION);

        frame.setLocationByPlatform(true);
        frame.pack();

        frame.setVisible(true);
    } 

    public static void main(String[] args){
        SimpleGUI gui = new SimpleGUI();

        gui.display();
    }
}
