import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.*;

public class CheckHome extends JPanel {

    // so can be used in refresh
    private JPanel lists;
    private ArrayList <Checklist> checklists;

    // constructor which will set up the page
    public CheckHome (CardLayout cardLayout, JPanel cardPanel, ArrayList <Checklist> checklists) {

        // make preferred font for everything (same logic as where it was first placed in the delete page)
        Font font = new Font("Arial", Font.PLAIN, 18);

        this.checklists = checklists;

        // make it border layout (already extends pannel)
        setLayout(new BorderLayout());

        // title for the page and setting margins
        JPanel top = new JPanel();
        JLabel title = new JLabel("Home Page", SwingConstants.CENTER);
        top.add(title);
        top.setBorder(new EmptyBorder(20, 0, 20, 0));
        title.setFont(font);

        add(top, BorderLayout.NORTH);

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
        create.setFont(font);
        edit.setFont(font);
        delete.setFont(font);

        // where the buttons point
        create.addActionListener(e -> cardLayout.show(cardPanel, "create"));
        edit.addActionListener(e -> cardLayout.show(cardPanel, "edit"));
        delete.addActionListener(e -> cardLayout.show(cardPanel, "delete"));

        // make panel and add the buttons and borders
        JPanel buttons = new JPanel();
        buttons.setBorder(new EmptyBorder(20, 0, 20, 0));
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
