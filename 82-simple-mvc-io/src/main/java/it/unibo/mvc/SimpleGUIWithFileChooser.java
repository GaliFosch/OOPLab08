package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;

    private final static String TITLE = "GUI with filechooser";
    private final static String SAVE_TEXT = "Save";
    private static final String TEXT_AREA_TEXT = "Write here";
    private static final String BROWSE_TEXT = "Browse...";
    protected static final String ERROR_MESSAGE = "errore nell'apertura del file";

    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller = new Controller();
    
    public SimpleGUIWithFileChooser (){
        final JPanel panel = new JPanel(new BorderLayout());
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextField text = new JTextField(TEXT_AREA_TEXT);
        frame.add(text, BorderLayout.CENTER);
        final JButton save = new JButton(SAVE_TEXT);
        frame.add(save, BorderLayout.SOUTH);

        final JPanel bPanel = new JPanel(new BorderLayout());
        panel.add(bPanel,BorderLayout.NORTH);
        
        final JTextField path = new JTextField();
        path.setEditable(false);
        path.setText(controller.getPath());
        bPanel.add(path, BorderLayout.CENTER);
        final JButton browse = new JButton(BROWSE_TEXT);
        bPanel.add(browse, BorderLayout.LINE_END);

        save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    controller.printString(text.getText());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        });

        browse.addActionListener(new ActionListener(){

            final JFileChooser fileChooser = new JFileChooser();

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int result = fileChooser.showSaveDialog(browse);
                if(result == JFileChooser.APPROVE_OPTION){
                    controller.setFile(fileChooser.getSelectedFile());
                    path.setText(controller.getPath());
                }else if(result != JFileChooser.CANCEL_OPTION){
                    JOptionPane.showMessageDialog(browse, arg0, ERROR_MESSAGE, result);
                }
            }

        });
    }

    public void display(){
        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) dim.getWidth();
        final int sh = (int) dim.getHeight();
        frame.setSize(sw/PROPORTION, sh/PROPORTION);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser();
        gui.display();
    }
}
