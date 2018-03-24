package Lab;

import java.awt.*; // action listener/event
import javax.swing.*; //table,Jframe
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Except {
        MainFrame mainFrame = new MainFrame();//рамка главного окна
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);//положение ,null - по центру
    }
}

class MainFrame extends JFrame implements ActionListener {
    private final JTable studTable = new JTable();
    private static final String[] titles = {"Фамилия","Город", "Дата рождения", "Экономика", "Программирование", "Базы данных"};
    private static final String REFRESH = "REFRESH";
    private static final String ADD = "ADD";
    private static final String EDIT = "EDIT";
    private static final String DELETE = "DELETE";
    private static final String FIND = "FIND";
    private static final String SORT = "SORT";
    private final StudentInterface firstManager = new StudentInterface();
    //private final StudentInterface secondManager = new StudentInterface();
    public boolean flag = false;

    public MainFrame() throws Except {
        studTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        GridBagLayout gridBagLay = new GridBagLayout();//менеджер для размещения
        GridBagConstraints gridBagCon = new GridBagConstraints();
        gridBagCon.gridwidth = GridBagConstraints.EAST;
        gridBagCon.fill = GridBagConstraints.BOTH; //on hole size of cell
        gridBagCon.insets = new Insets(5, 5, 5, 5);//отступ от кнопки
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(gridBagLay);
        buttonPanel.add(createButton(gridBagLay, gridBagCon, "Добавить", ADD));
        buttonPanel.add(createButton(gridBagLay, gridBagCon, "Редактировать", EDIT));
        buttonPanel.add(createButton(gridBagLay, gridBagCon, "Удалить", DELETE));
        buttonPanel.add(createButton(gridBagLay, gridBagCon, "Поиск", FIND));
        buttonPanel.add(createButton(gridBagLay, gridBagCon, "Сортировать", SORT));
        buttonPanel.add(createButton(gridBagLay, gridBagCon, "Обновить", REFRESH));
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        top.add(buttonPanel, BorderLayout.SOUTH);
        add(top, BorderLayout.SOUTH);
        add(new JScrollPane(studTable), BorderLayout.CENTER);
        setBounds(100, 200, 900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadStudent();
    }

    private JButton createButton(GridBagLayout gbl, GridBagConstraints gbc, String str, String action) {
        JButton button = new JButton(str);
        button.setActionCommand(action);
        button.addActionListener(this);
        gbl.setConstraints(button, gbc);
        return button;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String act = actionEvent.getActionCommand();
        switch (act) {
            case ADD:
                try {
                    addStudent();
                } catch (NullPointerException e) {
                }
                break;
            case EDIT:
                editStudent();
                break;
            case DELETE:
                delStudent();
                break;
            case FIND:
                try {
                    findStudent();
                } catch (Except ex) {
                }
                break;
            case SORT:
                sortStudent();
                break;
            case REFRESH:
                loadStudent();
                break;
        }

    }

    private void loadStudent() {
        List<Student> studentList = firstManager.findStudent();
        class StudentModel extends AbstractTableModel {
            private final List<Student> students;

            public StudentModel(List<Student> students) {
                this.students = students;
            }

            @Override
            public int getRowCount() {
                return students.size();
            }

            @Override
            public int getColumnCount() {
                return 6;
            }
            @Override
            public String getColumnName(int col){
                return titles[col];
            }
            @Override
            public Object getValueAt(int row,int col){
                Student student = students.get(row);
                switch(col){
                    case 0:return student.getSurname();
                    case 1:return student.getCity();
                    case 2:return student.getDate();
                    case 3:return student.getFs();
                    case 4:return student.getSs();
                    case 5:return student.getThs();
                    default:return student.getStudID().toString();
                }
            }
        }
        StudentModel sm = new StudentModel(studentList);
        studTable.setModel(sm);
    }


    private void sortStudent() {
        firstManager.sortStudents();
        loadStudent();
    }

    private void editStudent(){
        if(delStudent()){
            addStudent();
        }
        loadStudent();
        sortStudent();
    }
    private void addStudent(){
        EditStudentDialog dialog = new EditStudentDialog();
        saveStudents(dialog);
        loadStudent();
    }
    private void saveStudents(EditStudentDialog dialog){
        if(dialog.isSave()){
            Student student = dialog.getStudent();
            if(student.getSurname()!=null){
                firstManager.addStudent(student);
            }
            else{
                firstManager.addStudent(student);
            }
        }

    }

    private boolean delStudent(){
        int selectedRow = studTable.getSelectedRow();
        if(selectedRow!=-1) {
            String str = studTable.getModel().getValueAt(selectedRow, 0).toString();
            firstManager.delStudent(str);
            flag = true;
        }
        else{
            JOptionPane.showMessageDialog(this,"Требуется выделить строку!");

        }
        return flag;
    }

    private void findStudent() throws Except {
        loadStudent();
        FindStudentDialog fsd = new FindStudentDialog();
        forFindStudent(fsd);
        loadStudent();
    }
    private void forFindStudent(FindStudentDialog dialog)throws Except {
        if(dialog.isSave()){
            String str = dialog.getFindCity();
            FindPanel fp = new FindPanel(str);
            fp.setVisible(true);
        }
    }

}



