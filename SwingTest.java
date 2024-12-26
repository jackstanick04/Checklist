import javax.swing.*;

// this works (FINALLY!), and now we can begin to learn all this

public class SwingTest {
    
    public static void main (String [] args) {

        // Create a new JFrame (window)
        JFrame frame = new JFrame("Hello World");

        // Create a new JLabel (text label)
        JLabel label = new JLabel("Hello, World!", SwingConstants.CENTER);

        // Add the label to the frame
        frame.add(label);

        // Set the size of the frame
        frame.setSize(300, 200);

        // Set the default close operation (exit when the window is closed)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        frame.setVisible(true);

    }

}
