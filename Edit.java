import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Edit extends JPanel{

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
        JLabel title = new JLabel("This is the edit page page");
        top.add(back);
        top.add(title);
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
        number.add(numQuestion);
        number.add(numResp);

        // create and add buttons
        JButton addButton = new JButton("Add item");
        JButton removeButton = new JButton("Remove item");
        JButton completeButton = new JButton("Complete item");
        JButton cleanListButton = new JButton("Clean list");
        JButton checkListButton = new JButton("Check List");
        buttons.add(addButton);
        buttons.add(removeButton);
        buttons.add(completeButton);
        buttons.add(cleanListButton);
        buttons.add(checkListButton);

        // add to middle panel and to frame
        centerP.add(number);
        centerP.add(buttons);
        add(centerP, BorderLayout.CENTER);

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
            cleanListMethod();
        });
        checkListButton.addActionListener(e -> {
            numList = Integer.parseInt(numResp.getText());
            checkListMethod();
        });

        // done button at the bottom (will act as refresh)
        JPanel bottom = new JPanel();
        JButton done = new JButton("done");
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

    }

    // instance methods for every button (have access to the instance variables already)

    public void addMethod () {
        
        // remove the center panel to later be customized
        centerP.removeAll();

        // make the new center panel (customized to each)

        // how to update the page
        centerP.repaint();
        centerP.revalidate();

    }

    public void removeMethod () {

        // remove the center panel to later be customized (same as add method)
        centerP.removeAll();

        // make the new center panel (customized to each)

        // how to update the page
        centerP.repaint();
        centerP.revalidate();

    }

    public void completeMethod () {

        // remove the center panel to later be customized (same as add method)
        centerP.removeAll();

        // make the new center panel (customized to each)

        // how to update the page
        centerP.repaint();
        centerP.revalidate();

    }

    public void cleanListMethod () { 
        
        // remove the center panel to later be customized (same as add method)
        centerP.removeAll();

        // make the new center panel (customized to each)

        // how to update the page
        centerP.repaint();
        centerP.revalidate();

    }

    public void checkListMethod () { 
        
        // remove the center panel to later be customized (same as add method)
        centerP.removeAll();

        // make the new center panel (customized to each)

        // how to update the page
        centerP.repaint();
        centerP.revalidate();

    }

}
