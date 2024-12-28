// importing necessary swing and arraylist
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class MainFile2 {
    
    public static void main (String [] args) {

        // checklists
        ArrayList <Checklist> checklists = new ArrayList <Checklist> ();
        Task task1 = new Task ("Jack");
        Task task2 = new Task ("Kate");
        ArrayList <Task> tasks = new ArrayList <Task> ();
        tasks.add(task1);
        tasks.add(task2);
        Checklist checky1 = new Checklist ("List1", tasks);
        Checklist checky2 = new Checklist ("List2", tasks);
        checklists.add(checky1);
        checklists.add(checky2);


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
        Edit edit = new Edit(cardLayout, cardPanel);
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
