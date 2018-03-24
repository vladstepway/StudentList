package Lab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExceptFrame extends JFrame {
    String err;

    ExceptFrame(String err) {
        this.setLayout(null);
        this.err = err;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        JButton jButton = new JButton("OK");
        jButton.setLocation(90, 100);
        JLabel jLabel = new JLabel(err);
        jLabel.setLocation(120, 20);
        jLabel.setSize(300, 50);
        ActionListener actionListener = new TestActionListener();
        jButton.addActionListener(actionListener);
        add(jButton);
        add(jLabel);
        jButton.setSize(300, 50);
    }

    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }
}

