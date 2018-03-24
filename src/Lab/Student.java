package Lab;


public class Student {

    private Long StudID;
    private String surname;
    private String city;
    private String dd;
    private String mm;
    private String yyyy;
    private String date;
    private String fs;
    private String ss;
    private String ths;


    public Student(String surname, String city, String dd, String mm, String yyyy, String fs, String ss, String ths) throws Except {
        if (surname.isEmpty() || surname == null) throw new Except("Фамилия");
        if (city.isEmpty() || city == null) throw new Except("Город");
        // if (Integer.parseInt(date) < 0 || Integer.parseInt(date) > 2002) throw new Except("Дата рождения");
        if (Integer.parseInt(dd) < 0 || Integer.parseInt(dd) > 31 || dd==null) throw new Except("День рождения");
        if (Integer.parseInt(mm) < 0 || Integer.parseInt(mm) > 12 || mm==null) throw new Except("Месяц рождения");
        if (Integer.parseInt(yyyy) < 1990 || Integer.parseInt(yyyy) > 2018 || yyyy == null ) throw new Except("Год рождения");
        if (Integer.parseInt(fs) < 0 || Integer.parseInt(fs) > 10 || fs == null) throw new Except("Экономика");
        if (Integer.parseInt(ss) < 0 || Integer.parseInt(ss) > 10 || ss == null) throw new Except("Программирование");
        if (Integer.parseInt(ths) < 0 || Integer.parseInt(ths) > 10 || ths == null) throw new Except("Базы данных");
        this.surname = surname;
        this.city = city;
        //this.date = date;
        this.dd = dd;
        this.mm = mm;
        this.yyyy = yyyy;
        this.fs = fs;
        this.ss = ss;
        this.ths = ths;
    }
//    public Student(String surname, String city, String date, String fs, String ss, String ths) throws Except {
//        if (surname.equals("")) throw new Except("Фамилия");
//        if (city.equals("")) throw new Except("Город");
//        if (Integer.parseInt(date) < 0 || Integer.parseInt(date) > 2002) throw new Except("Дата рождения");
//        if (Integer.parseInt(dd) < 0 || Integer.parseInt(dd) > 31) throw new Except("День рождения");
//        if (Integer.parseInt(mm) < 0 || Integer.parseInt(date) > 2002) throw new Except("Дата рождения");
//        if (Integer.parseInt(date) < 0 || Integer.parseInt(date) > 2002) throw new Except("Дата рождения");
//        //  if (Integer.parseInt(fs) <0 || Integer.parseInt(fs) > 10) throw new Except("Экономика");
//        // if (fs <0 || fs > 10) throw new Except("Экономика");
//        //  if (Integer.parseInt(ss) < 0 || Integer.parseInt(ss) > 10) throw new Except("Программирование");
//        //  if (Integer.parseInt(ths) < 0 || Integer.parseInt(ths) > 10) throw new Except("Базы данных");
//        this.surname = surname;
//        this.city = city;
//        this.date = date;
//        this.fs = fs;
//        this.ss = ss;
//        this.ths = ths;
//    }

    public Student() {
    }

//    public Student(Long ID, String surname, String city, String date, String fs, String ss, String ths) {
//        this.StudID = ID;
//        this.surname = surname;
//        this.city = city;
//        this.date = date;
//        this.fs = fs;
//        this.ss = ss;
//        this.ths = ths;
//    }

    public Long getStudID() {
        return StudID;
    }

    public String getSurname() {
        return surname;
    }

    public String getDate() {
        return getDd() + "." + getMm() + "." + getYyyy();
    }


    public String getDd() {
        return dd;
    }

    public String getMm() {
        return mm;
    }

    public String getYyyy() {
        return yyyy;
    }

    public String getFs() {
        return fs;
    }

    public String getSs() {
        return ss;
    }

    public String getThs() {
        return ths;
    }

    public String getCity() {
        return city;
    }

    public Double getProgress(Student st1) {
        //  Student st1 = new Student();
        Integer fs = Integer.parseInt(st1.getFs());
        Integer ss = Integer.parseInt(st1.getSs());
        Integer ths = Integer.parseInt(st1.getThs());
        return (double) (fs + ss + ths) / 3;
    }

    public void setStudID(Long studID) {
        this.StudID = studID;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDate(String dd, String mm, String yyyy) {
        this.dd = dd;
        this.mm = mm;
        this.yyyy = yyyy;
    }


    public void setDd(String dd) {
        this.dd = dd;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    public void setYyyy(String yyyy) {
        this.yyyy = yyyy;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public void setThs(String ths) {
        this.ths = ths;
    }

    public String toString() {
        // return "Student{" + ",Surname=" + surname + ",City=" + city + ",Date=" + date + ",FirstSubject=" + fs + ",SecondSubject=" + ss + ",ThirdSubject=" + ths + '}';
        return "Student{" + ",Surname=" + surname + ",City=" + city + ",Day=" + dd + ",Month=" + mm + ",Year=" + yyyy + ",FirstSubject=" + fs + ",SecondSubject=" + ss + ",ThirdSubject=" + ths + '}';
    }
}
