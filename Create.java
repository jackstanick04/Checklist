import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Create extends JPanel{

    // constructor to make page
    public Create (CardLayout cardLayout, JPanel cardPanel) {

        // flag variable to ensure the name is only used once
        // private boolean flag = false;

        // make border layout
        setLayout(new BorderLayout());

        // same as the delete page, making nav bar with the title and the back button at the north
        // make the button and title
        JLabel label = new JLabel("Create list page");
        JButton back = new JButton("Back");
        back.addActionListener(e -> cardLayout.show(cardPanel, "home"));
        // make panel and add button and title
        JPanel top = new JPanel();
        top.add(label);
        top.add(back);
        add(top, BorderLayout.NORTH);

        // body part (where input is all taken)

        // make panel and make border layout
        JPanel middle = new JPanel();
        middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));

        // list name text box section (its own flow panel for horizontal alignment)
        JPanel name = new JPanel(new FlowLayout());
        JLabel promptName = new JLabel("What name for the list");
        JTextField inputName = new JTextField(20);
        name.add(promptName);
        name.add(inputName);

        // asking for task name (flow panel)
        JPanel task = new JPanel(new FlowLayout());
        JLabel promptTask = new JLabel("Label for first task");
        JTextField inputTask = new JTextField(20);
        task.add(promptTask);
        task.add(inputTask);

        // asking for date (flow panel)
        JPanel date = new JPanel(new FlowLayout());
        JLabel promptDate = new JLabel("Date for task");
        JTextField inputDate = new JTextField(10);
        date.add(promptDate);
        date.add(inputDate);

        // add flowpanels to center panel and add to main frame
        middle.add(name);
        middle.add(task);
        middle.add(date);
        add(middle, BorderLayout.CENTER);


        // bottom with two buttons

        // create the two buttons and add to the bottom panel to add to the main frame
        JButton done = new JButton("Done");
        JButton addMore = new JButton("Add Another");
        JPanel bottom = new JPanel();
        bottom.add(done);
        bottom.add(addMore);
        // make panel aligned to the bottom
        add(bottom, BorderLayout.SOUTH);



    }


}
