import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Create extends JPanel{

    // constructor to make page
    public Create (CardLayout cardLayout, JPanel cardPanel) {

        // make border layout
        setLayout(new BorderLayout());

        // make back button and path it back
        JButton back = new JButton("Back");
        back.addActionListener(e -> cardLayout.show(cardPanel, "home"));

        // make panel to show button
        JPanel button = new JPanel();
        button.add(back);
        add(button, BorderLayout.SOUTH);


    }


}
