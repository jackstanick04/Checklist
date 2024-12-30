// importing necessary swing and arraylist
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class MainFile2 {
    
    public static void main (String [] args) {

        // checklist instanciation
        ArrayList <Checklist> checklists = new ArrayList <Checklist> ();

        // make frame and size
        JFrame checklistFrame = new JFrame("Checklist Program");
        checklistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checklistFrame.setSize(850, 1200);

        // make cardlayout style
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
        cardPanel.setLayout(cardLayout);
        checklistFrame.add(cardPanel);

        // making one of every page
        CheckHome home = new CheckHome(cardLayout, cardPanel, checklists);
        Create create = new Create(cardLayout, cardPanel, checklists, home);
        Edit edit = new Edit(cardLayout, cardPanel, checklists, home);
        // takes in the home so that it can refresh the page easily
        Delete delete = new Delete(cardLayout, cardPanel, checklists, home);

        // add to the main panels, add main panels to the frame
        cardPanel.add(home, "home");
        cardPanel.add(create, "create");
        cardPanel.add(edit, "edit");
        cardPanel.add(delete, "delete");
        checklistFrame.add(cardPanel);

        // make visible
        checklistFrame.setVisible(true);

    }

}
