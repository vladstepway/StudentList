package Lab;

public class Except extends Throwable {

    String str;

    public Except(String str) {
        this.str = str;
    }

    public String getEx() {
        String str1 = "Ошибка ввода поля : " + str + "!";
        return str1;
    }
}
