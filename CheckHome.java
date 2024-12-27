import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckHome extends JPanel {

    // so can be used in refresh
    private JPanel lists;
    private ArrayList <Checklist> checklists;

    // constructor which will set up the page
    public CheckHome (CardLayout cardLayout, JPanel cardPanel, ArrayList <Checklist> checklists) {

        this.checklists = checklists;

        // make it border layout (already extends pannel)
        setLayout(new BorderLayout());

        // title for the page
        JLabel title = new JLabel("This is the home page", SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        // part for the lists (panel inside of the entire panel), vertical alignment with the box
        lists = new JPanel();
        lists.setLayout(new BoxLayout(lists, BoxLayout.Y_AXIS));
        // loop through to add every checklist to be printed (can be many)
        for (Checklist checklist : checklists) { 
            lists.add(new JTextArea(checklist.toString()));
        }
        // add this to the program to be output in the center
        add(lists, BorderLayout.CENTER);

        // make buttons
        JButton create = new JButton ("Create");
        JButton edit = new JButton ("Edit");
        JButton delete = new JButton ("Delete");

        // where the buttons point
        create.addActionListener(e -> cardLayout.show(cardPanel, "create"));
        edit.addActionListener(e -> cardLayout.show(cardPanel, "edit"));
        delete.addActionListener(e -> cardLayout.show(cardPanel, "delete"));

        // make panel and add the buttons
        JPanel buttons = new JPanel();
        buttons.add(create);
        buttons.add(edit);
        buttons.add(delete);
        add(buttons, BorderLayout.SOUTH);

    }

    // refresh method to delete and then rebuild the changing list panel
    public void refresh() {

        // remove and then rebuild the panel
        lists.removeAll();
        for (Checklist checklist : checklists) { 
            lists.add(new JTextArea(checklist.toString()));
        }

        // output again
        lists.revalidate();
        lists.repaint();

    }
    
}
