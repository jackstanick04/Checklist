import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Edit extends JPanel{

    // constructor to make page
    public Edit(CardLayout cardLayout, JPanel cardPanel) {

        // make back button and path it back
        JButton back = new JButton("Back");
        back.addActionListener(e -> cardLayout.show(cardPanel, "home"));

        // make panel to show button
        JPanel button = new JPanel();
        button.add(back);
        add(button);


    }


}
