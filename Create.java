import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Create extends JPanel{
    
    private Checklist checklist = new Checklist ();

    // constructor to make page
    public Create (CardLayout cardLayout, JPanel cardPanel, ArrayList <Checklist> checklists, CheckHome home) {

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

        // action listeners for the two buttons (where most of the logic goes)

        // add another button
        addMore.addActionListener(e -> {
            // check if the name field has been filled in or not
            if (inputName.isEnabled()) {
                checklist.setName(inputName.getText());
                // set false for future tries
                inputName.setEnabled(false);
            }

            // checks if empty box to just give todays date
            Date dateUse = new Date ();
            if (!inputDate.getText().equals("")) {
                dateUse = new Date(inputDate.getText());
            }
            // task text storage and then adding the new task with date
            String taskStr = inputTask.getText();
            checklist.addTask(new Task(taskStr, dateUse));

            // clean the task and date boxes and update the button to be able to be pressed again
            inputTask.setText("");
            inputDate.setText("");
            addMore.setEnabled(true);

        });

        // done button
        done.addActionListener(e -> {

            // first need same logic as the addmore to store the data (exact same code)
            if (inputName.isEnabled()) {
                checklist.setName(inputName.getText());
                inputName.setEnabled(false);
            }
            Date dateUse = new Date ();
            if (!inputDate.getText().equals("")) {
                dateUse = new Date(inputDate.getText());
            }
            String taskStr = inputTask.getText();
            checklist.addTask(new Task(taskStr, dateUse));

            // add the new checklist to the arraylist and reset the checklist
            checklists.add(checklist);
            checklist = new Checklist();

            // clear the input fields and enable button (basically refreshes the page too)
            inputName.setEnabled(true);
            inputName.setText("");
            inputTask.setText("");
            inputDate.setText("");
            done.setEnabled(true);
            // go back and refresh home page (take in as parameter just for this) and this page
            home.refresh();
            cardLayout.show(cardPanel, "home");

        });

    }


}
