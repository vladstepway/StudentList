package Lab;

import java.util.*;


public class StudentInterface implements AbstractInterface {


    public final List<Student> studentList = new ArrayList<>();
    public final List<Student> fstudentList = new ArrayList<>();
   // public int count = 0;

    public StudentInterface() throws Except {
        // addStudent(new Student("Иванов","Минск","2000","5","3","7"));
        //   addStudent(new Student("Дураков","Гродно","1999","8","4","10"));
        // addStudent(new Student("Шамрицкий","Жодино","1999","9","8","9"));
        // addStudent(new Student("Мойсеенко","Минск","1999","10","10","10"));
        // addStudent(new Student("Степовой","Минск","1998","8","7","9"));

        addStudent(new Student("Дураков", "Гродно", "20", "01", "2000", "8", "8", "8"));
        addStudent(new Student("Шамрицкий", "Жодино", "20", "05", "1999", "6", "6", "6"));
        addStudent(new Student("Мойсеенко", "Минск", "08", "04", "1999", "9", "9", "9"));
        addStudent(new Student("Иванов", "Минск", "19", "02", "1997", "5", "5", "5"));
        addStudent(new Student("Степовой", "Минск", "15", "02", "1998", "7", "7", "7"));
        addStudent(new Student("Дураков", "Гродно", "20", "01", "2000", "8", "8", "8"));
        addStudent(new Student("Шамрицкий", "Жодино", "20", "05", "1999", "6", "6", "6"));
        addStudent(new Student("Мойсеенко", "Минск", "08", "04", "1999", "9", "9", "9"));
        addStudent(new Student("Иванов", "Минск", "19", "02", "1997", "5", "5", "5"));
        addStudent(new Student("Степовой", "Минск", "15", "02", "1998", "7", "7", "7"));
        addStudent(new Student("Дураков", "Гродно", "20", "01", "2000", "8", "8", "8"));
        addStudent(new Student("Шамрицкий", "Жодино", "20", "05", "1999", "6", "6", "6"));
        addStudent(new Student("Мойсеенко", "Минск", "08", "04", "1999", "9", "9", "9"));
        addStudent(new Student("Иванов", "Минск", "19", "02", "1997", "5", "5", "5"));
        addStudent(new Student("Степовой", "Минск", "15", "02", "1998", "7", "7", "7"));
        addStudent(new Student("Дураков", "Гродно", "20", "01", "2000", "8", "8", "8"));
        addStudent(new Student("Дураков", "Гродно", "20", "01", "2000", "8", "8", "8"));
        addStudent(new Student("Дураков", "Гродно", "20", "01", "2000", "8", "8", "8"));
        addStudent(new Student("Дураков", "Гродно", "20", "01", "2000", "8", "8", "8"));
        addStudent(new Student("Дураков", "Гродно", "20", "01", "2000", "8", "8", "8"));
        addStudent(new Student("Дураков", "Гродно", "20", "01", "2000", "8", "8", "8"));
        addStudent(new Student("Шамрицкий", "Жодино", "20", "05", "1999", "6", "6", "6"));
        addStudent(new Student("Мойсеенко", "Минск", "08", "04", "1999", "9", "9", "9"));
        addStudent(new Student("Иванов", "Минск", "19", "02", "1997", "5", "5", "5"));
        addStudent(new Student("Степовой", "Минск", "15", "02", "1998", "7", "7", "7"));
    }

    public List<Student> findStudent() {
        return studentList;
    }

//    public Student getStudent(String surname) {
//        Student st1 = new Student();
//        for (Student student : studentList) {
//            if (student.getSurname().equals(surname)) {
//                st1 = student;
//            }
//        }
//        return st1;
//    }

    public List<Student> fStudents(String str) {
        String str1 = str;
        getFindStudent(str1);
        return fstudentList;
    }

//    public int getCount(String str) {
//        for (Student student : studentList) {
//            if (student.getCity().equals(str)) {
//                count++;
//            }
//        }
//        return count;
//    }

    public void getFindStudent(String str) {
        for (Student student : studentList) {
            if (student.getCity().equals(str)) {
                fstudentList.add(student);
            }
        }
    }

    public void sortStudents() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getProgress(o1).compareTo(o2.getProgress(o2));

            }
        });
    }

    public Long addStudent(Student student) {
        Long id = generationID();
        student.setStudID(id);
        studentList.add(student);
        return id;
    }

    private Long generationID() {
        Long ID = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        return ID;
    }

    public void delStudent(String str) {
        for (Iterator<Student> iterator = studentList.iterator(); iterator.hasNext(); ) {
            Student student = iterator.next();
            if (student.getSurname().equals(str))
                iterator.remove();
        }
    }
}

//    public void updateStudent(Student student) {
//        Student oldStudent = getStudent(student.getSurname());
//        if (oldStudent != null) {
//            oldStudent.setSurname(student.getSurname());
//            oldStudent.setCity(student.getCity());
//            oldStudent.setDate(student.getDd(),student.getMm(),student.getYyyy());
//            oldStudent.setFs(student.getFs());
//            oldStudent.setSs(student.getSs());
//            oldStudent.setThs(student.getThs());
//        }
//    }
