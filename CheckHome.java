import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckHome extends JPanel {

    // constructor which will set up the page
    public CheckHome (CardLayout cardLayout, JPanel cardPanel) {

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

        add(buttons);

    }
    
}
