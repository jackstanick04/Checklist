import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

// this works (FINALLY!), and now we can begin to learn all this
// not at all related to the program

public class SwingTest {
    
    public static void main (String [] args) {

        // create java frame and visitibility and close and size
        JFrame myFrame = new JFrame ("Test frame");
        myFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(850, 1200);
        // border layout for formatting
        myFrame.setLayout(new BorderLayout());
        
        // making a label in the top center (swing constants centers horizontally)
        JLabel title = new JLabel ("Welcome to application", SwingConstants.CENTER);
        myFrame.add(title, BorderLayout.NORTH);
        // set border will put padding after it is in top center region
        title.setBorder(new EmptyBorder(40, 0, 0, 0));

        // to place bulleted lines in the middle
        // create panel and stack vertically
        JPanel items = new JPanel();
        items.setLayout(new BoxLayout(items, BoxLayout.Y_AXIS));
        JLabel item1 = new JLabel("item 1");
        JLabel item2 = new JLabel("item 2");
        // add to the panel and add panel to the window in the center
        items.add(item1);
        items.add(item2);
        myFrame.add(items, BorderLayout.CENTER);
        

        // making a panel (a little container section) to hold the buttons
        JPanel buttons = new JPanel ();
        // make it so things will be placed in it horizontally with padding in between the items and also off the end of the page
        buttons.setLayout(new FlowLayout (FlowLayout.CENTER, 20, 20));
        buttons.setBorder(new EmptyBorder (0, 0, 40, 0));

        // make my buttons and add them to the panel, then add panel to the frame in the south portion
        JButton but1  = new JButton ("First");
        JButton but2 = new JButton ("Second");
        JButton but3 = new JButton ("Third");
        buttons.add(but1);
        buttons.add(but2);
        buttons.add(but3);
        myFrame.add(buttons, BorderLayout.SOUTH);

        // set visible and last line
        myFrame.setVisible(true);
    

    }

}
