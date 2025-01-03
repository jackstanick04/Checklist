import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class Delete extends JPanel{

    // so these can be used in refresh
    private ArrayList <Checklist> checklists;
    private JPanel lists;

    // constructor to make page
    public Delete (CardLayout cardLayout, JPanel cardPanel, ArrayList <Checklist> checklists, CheckHome home) {

        this.checklists = checklists;

        // make preferred font for everything
        Font font = new Font("Arial", Font.PLAIN, 18);

        // create border layout
        setLayout(new BorderLayout());

        // title portion and back button (panel)

        // label and button instanciation and setting font
        JLabel title = new JLabel("Delete Page", SwingConstants.CENTER);
        JButton back = new JButton("Back");
        title.setFont(font);
        back.setFont(font);
        back.addActionListener(e -> cardLayout.show(cardPanel, "home"));
        // making panel to add them to and then add to the layout
        JPanel top = new JPanel();
        top.setBorder(new EmptyBorder(20, 0, 20, 0));
        top.add(back);
        top.add(title);
        add(top, BorderLayout.NORTH);
        
        // printing the lists left out for now
        // // print lists (see home page)
        // lists = new JPanel();
        // lists.setLayout(new BoxLayout(lists, BoxLayout.Y_AXIS));
        // for (Checklist checklist : checklists) {
        //     lists.add(new JTextArea(checklist.toString()));
        // }
        // add(lists, BorderLayout.CENTER);

        // input portion (using a panel)

        // create label for input and textfield to take in user data and font
        JLabel which = new JLabel("Enter which list to delete");
        JTextField choice = new JTextField(5);
        // make button and then action below it
        JButton delete = new JButton("Delete");
        which.setFont(font);
        delete.setFont(font);
        // removing the item from the checklist (just need to make it the appropriate index) and then sending back to home page (also refreshes)
        delete.addActionListener(e -> {
            checklists.remove(Integer.parseInt(choice.getText()) - 1);
            // calls the refresh instance method and then all homepage's, then updates which card is shown
            home.refresh();
            // refresh(); (taken away because not printing the lists right now)
            // refresh the button to be able to be used again
            choice.setText("");
            // make sure the button can be used again
            delete.setEnabled(true);
            cardLayout.show(cardPanel, "home");
        });

        // after all parts are made, make a jpanel and add them all using horizontal align
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(which);
        inputPanel.add(choice);
        inputPanel.add(delete);
        add(inputPanel, BorderLayout.CENTER);

    }

    // same as the homepage refresh
    public void refresh() {

        // leaving out the list portion for now
        // lists.removeAll();
        // for (Checklist checklist : checklists) { 
        //     lists.add(new JTextArea(checklist.toString()));
        // }

        // lists.revalidate();
        // lists.repaint();

    }


}
