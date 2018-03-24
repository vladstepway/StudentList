package Lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CancellationException;

public class FindStudentDialog extends JDialog implements ActionListener {

    private static final String FIND = "Найти";
    private static final String CANCEL = "Закрыть";
   // private static final int 10 = 10;
    //private static final int 100 = 100;
    //private static final int 300 = 300;
    //private static final int 120 = 120;
  //  private static final int 25 = 25;

    private String string;
    private boolean save = false;

    private final JTextPane textPane = new JTextPane();

    public FindStudentDialog() {
        this(null);
    }

    public FindStudentDialog(Student student) {
        setLayout(null);
        buildFields();
       // initFields();
        buildButtons();
        setModal(true);
        setResizable(false);
        setBounds(300, 300, 450, 300);
        setVisible(true);
    }

    private void buildFields() {
        JLabel stLabel = new JLabel("Город:");
        stLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        stLabel.setBounds(new Rectangle(10, 1 * 25, 100, 25));
        add(stLabel);
        textPane.setBounds(new Rectangle(100 + 2 * 10, 1 * 25 + 10, 300, 25));
        textPane.setBorder(BorderFactory.createEtchedBorder());
        add(textPane);
    }

    private void buildButtons() {
        JButton saveButton = new JButton("Искать");
        saveButton.setActionCommand(FIND);
        saveButton.addActionListener(this);
        saveButton.setBounds(new Rectangle(120 + 3 * 10 - 20, 6 * 25 + 10, 120, 25));
        add(saveButton);
        JButton cancelButton = new JButton("Закрыть");
        cancelButton.setActionCommand(CANCEL);
        cancelButton.addActionListener(this);
        cancelButton.setBounds(new Rectangle(2 * 120 + 3 * 10 - 20, 6 * 25 + 10, 120, 25));
        add(cancelButton);
    }

//    private void initFields() {
//    }

    public String getFindCity() {
        String str = textPane.getText();
        return str;
    }

    public void actionPerformed(ActionEvent ae){
        String action = ae.getActionCommand();
        save = FIND.equals(action);
        setVisible(false);
    }

    public boolean isSave() {
        return save;
    }
}
