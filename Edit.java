import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class Edit extends JPanel {

    // make preferred font for everything
    Font font = new Font("Arial", Font.PLAIN, 18);

    // need all instance variables so can be used in the instance methods
    // list selection
    private int numList;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private ArrayList <Checklist> checklists;
    private CheckHome home;
    private JPanel centerP;

    // constructor to make page
    public Edit(CardLayout cardLayout, JPanel cardPanel, ArrayList <Checklist> checklists, CheckHome home) {

        // instanciate all variables aside from the list number as it will be done later
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        this.checklists = checklists;
        this.home = home;

        // make border layout
        setLayout(new BorderLayout());

        // make back button and title for the top (same idea as other pages)
        JPanel top = new JPanel();
        JButton back = new JButton("Back");
        back.addActionListener(e -> cardLayout.show(cardPanel, "home"));
        JLabel title = new JLabel("Edit Page (press enter then done)");
        back.setFont(font);
        title.setFont(font);
        top.add(back);
        top.add(title);
        top.setBorder(new EmptyBorder(20, 0, 20, 0));
        add(top, BorderLayout.NORTH);

        // middle section where the user selects the list to work with and then user choice of edit

        // middle panel which will have both the number panel and buttons panel (make centerP aligned vertically)
        centerP = new JPanel();
        centerP.setLayout(new BoxLayout(centerP, BoxLayout.Y_AXIS));
        JPanel number = new JPanel();
        JPanel buttons = new JPanel();

        // add label and textfield for the number panel
        JLabel numQuestion = new JLabel("Which list would you like to edit");
        JTextField numResp = new JTextField(5);
        numQuestion.setFont(font);
        numResp.setFont(font);
        number.add(numQuestion);
        number.add(numResp);

        // create and add buttons and set font
        JButton addButton = new JButton("Add item");
        JButton removeButton = new JButton("Remove item");
        JButton completeButton = new JButton("Complete item");
        JButton cleanListButton = new JButton("Clean list");
        JButton checkListButton = new JButton("Check List");
        addButton.setFont(font);
        removeButton.setFont(font);
        completeButton.setFont(font);
        cleanListButton.setFont(font);
        checkListButton.setFont(font);
        buttons.add(addButton);
        buttons.add(removeButton);
        buttons.add(completeButton);
        buttons.add(cleanListButton);
        buttons.add(checkListButton);

        // add to middle panel and to frame
        centerP.add(number);
        centerP.add(buttons);
        add(centerP, BorderLayout.CENTER);

        // done button at the bottom (will act as refresh)
        JPanel bottom = new JPanel();
        bottom.setBorder(new EmptyBorder(20, 0, 20, 0));
        JButton done = new JButton("Done");
        done.setFont(font);
        bottom.add(done);
        add(bottom, BorderLayout.SOUTH);

        // the refresh portion 
        done.addActionListener(e -> {
            // reset the list selection
            numResp.setText("");
            numResp.setEnabled(true);
            // clear the center panel and refill it (buttons do not need to be reset for some reason)
            centerP.removeAll();
            centerP.add(number);
            centerP.add(buttons);
            // refresh and show home page
            home.refresh();
            cardLayout.show(cardPanel, "home");
        });

        // call appropriate instance methods based on the buttons and instanciate the number list variable
        addButton.addActionListener(e -> {
            numList = Integer.parseInt(numResp.getText());
            addMethod();
        });
        removeButton.addActionListener(e -> {
            numList = Integer.parseInt(numResp.getText());
            removeMethod();
        });
        completeButton.addActionListener(e -> {
            numList = Integer.parseInt(numResp.getText());
            completeMethod();
        });
        cleanListButton.addActionListener(e -> {
            numList = Integer.parseInt(numResp.getText());
            // do not need method as it is just two lines
            checklists.get(numList - 1).cleanList();
            // if list is done remove it from checklists
            if (checklists.get(numList - 1).allDone()) {
                checklists.remove(numList - 1);
            }
            // automatically click done so that there is no need for a second page
            done.doClick();
        });
        checkListButton.addActionListener(e -> {
            numList = Integer.parseInt(numResp.getText());
            checkListMethod();
        });

    }

    // instance methods for every button (have access to the instance variables already)

    public void addMethod () {
        
        // remove the center panel to later be customized
        centerP.removeAll();

        // make the new center panel (customized to each)

        // panels (horizontal within) to be added to centralP vertically
        JPanel date = new JPanel(new FlowLayout());
        JPanel task = new JPanel(new FlowLayout());
        // make label and text field to add to the panels
        JLabel promptDate = new JLabel("Enter date (MM/DD/YYYY); Leave blank for today");
        JLabel promptTask = new JLabel("Enter task");
        JTextField inputDate = new JTextField(15);
        JTextField inputTask = new JTextField(15);
        promptDate.setFont(font);
        promptTask.setFont(font);
        // add to each panel and then central panel
        date.add(promptDate);
        date.add(inputDate);
        task.add(promptTask);
        task.add(inputTask);
        centerP.add(task);
        centerP.add(date);

        // make enter button (where the logic will go)
        JButton enter = new JButton("Enter");
        enter.setFont(font);
        enter.addActionListener(e -> {
            // store the task and date (same logic as adding an item when creating list)
            Date newDate = new Date();
            if (!inputDate.getText().equals("")) {
                newDate = new Date(inputDate.getText());
            }
            String taskStr = inputTask.getText();
            // insert to the checklists arraylist in appropriate spot, using the list index from earlier (1 less)
            checklists.get(numList - 1).addTask(new Task(taskStr, newDate));
            // clear each text field and reset button
            inputDate.setText("");
            inputTask.setText("");
            enter.setEnabled(true);
        });
        
        // add button to the panel
        centerP.add(enter);

        // how to update the page
        centerP.repaint();
        centerP.revalidate();

    }

    public void removeMethod () {

        // remove the center panel to later be customized (same as add method)
        centerP.removeAll();

        // make the new center panel (customized to each)

        // use a label and a text box to ask what number to remove (similar idea to what we have been doing)
        JPanel delPanel = new JPanel(new FlowLayout());
        JLabel promptDel = new JLabel("Which item to delete");
        JTextField inputDel = new JTextField(5);
        promptDel.setFont(font);
        delPanel.add(promptDel);
        delPanel.add(inputDel);
        centerP.add(delPanel);

        // enter button where logic will go
        JButton enter = new JButton("Enter");
        enter.setFont(font);
        enter.addActionListener(e -> {
            // take in the selection to remove
            int choice = Integer.parseInt(inputDel.getText());
            // use choice and the numlist to remove the desired task (not - 1 for second bc the method already does this)
            checklists.get(numList - 1).removeTask(choice);
            // reset the text box and enter button
            inputDel.setText("");
            enter.setEnabled(true);
        });

        // add button to panel
        centerP.add(enter);

        // how to update the page
        centerP.repaint();
        centerP.revalidate();

    }

    public void completeMethod () {

        // remove the center panel to later be customized (same as add method)
        centerP.removeAll();

        // make the new center panel (customized to each)
        // same exact method as remove, just completes the task instead of removing it

        JPanel compPanel = new JPanel(new FlowLayout());
        JLabel compDel = new JLabel("Which list to complete");
        JTextField inputComp = new JTextField(5);
        compDel.setFont(font);
        compPanel.add(compDel);
        compPanel.add(inputComp);
        centerP.add(compPanel);

        JButton enter = new JButton("Enter");
        enter.setFont(font);
        enter.addActionListener(e -> {
            int choice = Integer.parseInt(inputComp.getText());
            // complete method does -1
            checklists.get(numList - 1).completeTask(choice);
            inputComp.setText("");
            enter.setEnabled(true);
        });

        // add button to panel
        centerP.add(enter);

        // how to update the page
        centerP.repaint();
        centerP.revalidate();

    }

    public void checkListMethod () { 
        
        // remove the center panel to later be customized (same as add method)
        centerP.removeAll();

        // make the new center panel (customized to each)

        // instanciate jlabel
        JLabel result;
        // update jlabel depending on the result of the logic method
        boolean check = checklists.get(numList - 1).allDone();
        if (check) { 
            result = new JLabel("List list is all done, consider deleting.");
        }
        else {
            result = new JLabel("List still has items, consider cleaning.");
        }
        result.setFont(font);
        // add to the central panel
        centerP.add(result);

        // how to update the page
        centerP.repaint();
        centerP.revalidate();

    }

}
