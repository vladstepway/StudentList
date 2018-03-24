package Lab;


import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.List;

public class FindPanel extends JFrame{
    private static final String[] titles = {"Фамилия","Город", "Дата рождения", "Экономика", "Программирование", "Базы данных"};
    private final JTable findTable = new JTable();
    private final StudentInterface secondManager = new StudentInterface();
    String fname;

    public FindPanel(String str)throws Except {
        fname = str;
        findTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(findTable),BorderLayout.CENTER);
        setBounds(100,200,900,400);
        loadStudent(fname);
    }
    private void loadStudent(String str){
        //str = str;
        List<Student> students2 = secondManager.fStudents(str);
        class FindModel extends AbstractTableModel{
            private final List<Student> students;
            public FindModel(List<Student> students){
                this.students = students;
            }
            @Override
            public int getRowCount(){
                return students2.size();
            }
            @Override
            public int getColumnCount(){
                return 6;
            }
            @Override
            public String getColumnName(int col){
                return titles[col];
            }
            @Override
            public Object getValueAt(int row,int col){
                Student student = students.get(row);
                switch (col){
                    case 0:return student.getSurname();
                    case 1:return student.getCity();
                    case 2:return student.getDate();
                    case 3:return student.getFs();
                    case 4:return student.getSs();
                    case 5:return student.getThs();
                    default: return student.getStudID().toString();

                }
            }
        }
       FindModel fm = new FindModel(students2);
        findTable.setModel(fm);
    }

}
