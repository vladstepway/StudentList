package Lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditStudentDialog extends JDialog implements ActionListener {
    private static final String SAVE = "Сохранить";
    private static final String CLOSE = "Закрыть";
//    private static final int 10 = 10;
//    private static final int 120 = 120;
//    private static final int 25 = 25;
    private String str1;
    private String str2;
    private String str3;
    private String str4;
    private String str5;
    private String str6;

    private boolean save = false;

    private final JTextPane textSurname = new JTextPane();
    private final JTextPane textCity = new JTextPane();



//    public EditStudentDialog() {
//        this(null);
//    }

    public EditStudentDialog() {
        setLayout(null);
        buildFields();
        buildButtons();
        setModal(true);
        setResizable(false);
        setBounds(300, 300, 450, 450);
        setVisible(true);
    }

    private void buildFields() {
        JLabel lblSurname = new JLabel("Фамилия:");
        lblSurname.setHorizontalAlignment(SwingConstants.LEFT); //положение лейбла слева
        lblSurname.setBounds(new Rectangle(10, 0 * 25 + 10 * 1, 120, 25));//границы лейбла
        add(lblSurname);
        textSurname.setBounds(new Rectangle(120 + 10, 0 * 25 + 10 * 1, 300, 25));//границы текстового поля
        textSurname.setBorder(BorderFactory.createEtchedBorder());
        add(textSurname);

        JLabel lblCity = new JLabel("Город:");
        lblCity.setHorizontalAlignment(SwingConstants.LEFT);
        lblCity.setBounds(new Rectangle(10, 1 * 25 + 10 * 2, 120, 25));
        add(lblCity);
        textCity.setBounds(new Rectangle(120 + 10, 1 * 25 + 10 * 2, 300, 25));
        textCity.setBorder(BorderFactory.createEtchedBorder());
        add(textCity);

        JLabel lblDate = new JLabel("Дата рождения:");
        lblDate.setHorizontalAlignment(SwingConstants.LEFT);
        lblDate.setBounds(new Rectangle(10, 2 * 25 + 10 * 3, 120, 25));
        add(lblDate);

        String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

        String[] years = {"1990","1991","1992", "1993", "1994", "1995","1996","1997", "1998",
                "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007","2008",
                "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"};
        JComboBox jcDay = new JComboBox(days);//выпадающий список
        jcDay.setEditable(true);
        jcDay.setBounds(new Rectangle(120 + 10, 2 * 25 + 10 * 3, 100, 25));
        add(jcDay);
        jcDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                str4 = jcDay.getSelectedItem().toString();
                setSelection4(str4);
            }
        });
        JComboBox jcMonth = new JComboBox(months);
        jcMonth.setEditable(true);
         jcMonth.setBounds(new Rectangle(220+10,2*25+10*3,100,25));
         add(jcMonth);
        jcMonth.addActionListener(e -> {
            str5 = jcMonth.getSelectedItem().toString();
            setSelection5(str5);
        });
        JComboBox jcYear = new JComboBox(years);
        jcYear.setEditable(true);
        jcYear.setBounds(new Rectangle(320+10,2*25+10*3,100,25));
         add(jcYear);
        jcYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                str6 = jcYear.getSelectedItem().toString();
                setSelection6(str6);
            }
        });


        String[] marks1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};


        JLabel lblFS = new JLabel("Экономика:");
        lblFS.setHorizontalAlignment(SwingConstants.LEFT);
        lblFS.setBounds(new Rectangle(10, 3 * 25 + 4 * 10, 120, 25));
        add(lblFS);

        JComboBox editComboBox1 = new JComboBox(marks1);//выпадающий список
        editComboBox1.setEditable(true);
        editComboBox1.setBounds(120 + 10, 3 * 25 + 4 * 10, 300, 25);
        add(editComboBox1);

        editComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                str1 = editComboBox1.getSelectedItem().toString();
                setSelection1(str1);
            }
        });

        JLabel lblSS = new JLabel("Программирование:");
        lblSS.setHorizontalAlignment(SwingConstants.LEFT);
        //lblSS.setBounds(new Rectangle(10,10,120,25));
        lblSS.setBounds(new Rectangle(10, 4 * 25 + 5 * 10, 120, 25));
        add(lblSS);

        JComboBox editComboBox2 = new JComboBox(marks1);
        editComboBox2.setEditable(true);
        editComboBox2.setBounds(120 + 10, 4 * 25 + 5 * 10, 300, 25);
        add(editComboBox2);

        editComboBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                str2 = editComboBox2.getSelectedItem().toString();
                setSelection2(str2);
            }
        });

        JLabel lblTHS = new JLabel("Базы данных:");
        lblTHS.setHorizontalAlignment(SwingConstants.LEFT);
        lblTHS.setBounds(new Rectangle(10, 5 * 25 + 6 * 10, 120, 25));
        add(lblTHS);

        JComboBox editComboBox3 = new JComboBox(marks1);
        editComboBox3.setEditable(true);
        editComboBox3.setBounds(120 + 10, 5 * 25 + 6 * 10, 300, 25);
        add(editComboBox3);

        editComboBox3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                str3 = editComboBox3.getSelectedItem().toString();
                setSelection3(str3);
            }
        });

    }

    private void setSelection1(String str) {
        this.str1 = str;
    }

    private void setSelection2(String str) {
        this.str2 = str;
    }

    private void setSelection3(String str) {
        this.str3 = str;
    }

    private void setSelection4(String str) {
        this.str4 = str;
    }

    private void setSelection5(String str) {
        this.str5 = str;
    }

    private void setSelection6(String str) {
        this.str6 = str;
    }

    private String getSelection1() {
        return str1;
    }

    private String getSelection2() {
        return str2;
    }

    private String getSelection3() {
        return str3;
    }

    private String getSelection4() {
        return str4;
    }

    private String getSelection5() {
        return str5;
    }

    private String getSelection6() {
        return str6;
    }

    private void buildButtons() {
        JButton saveButton = new JButton("Сохранить");
        saveButton.setActionCommand(SAVE);
        saveButton.addActionListener(this);
        saveButton.setBounds(new Rectangle(120 + 3 * 10 - 20, 8 * 25 + 2 * 10, 120, 25));
        add(saveButton);
        JButton closeButton = new JButton("Закрыть");
        closeButton.setActionCommand(CLOSE);
        closeButton.addActionListener(this);
        closeButton.setBounds(new Rectangle(2 * 120 + 3 * 10 - 10, 8 * 25 + 2 * 10, 120, 25));
        add(closeButton);

    }
    public boolean isSave() {
        return save;
    }

    public Student getStudent() {
        String str = textCity.getText();
        Student student = null;
        try {
            student = new Student(textSurname.getText(), textCity.getText(), getSelection4(), getSelection5(), getSelection6(), getSelection1(), getSelection2(), getSelection3());
        } catch (Except excep) {
            ExceptFrame exceptFrame = new ExceptFrame(excep.getEx());
            exceptFrame.setVisible(true);
        }
        System.out.println(str);
        return student;
    }

    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        save = SAVE.equals(action);
        setVisible(false);
    }
}
