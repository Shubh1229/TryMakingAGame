import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Start extends JFrame{
    public Start(){
        //title of game
        setTitle("Shubh's Game");

        //set size of window
        setSize(1500, 1200);

        //closes code when window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //centers window
        setLocationRelativeTo(null);

        //initializedGUI components
        initializeGame();
    }
    private void initializeGame(){
        //creates panels
        JPanel base = new JPanel();

        //label and button
        JLabel label = new JLabel("First Button");
        JButton button = new JButton("Click Here");

        //actionlistener to button
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                label.setText("Button clicked");
            }
            
        });

        //add Component Panel
        base.add(label);
        base.add(button);

        add(base);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {
            Start gui = new Start();
            gui.setVisible(true);
        });
    }
}